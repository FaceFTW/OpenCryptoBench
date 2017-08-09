package org.FaceStudios.OpenCryptoBench.Data;

import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.google.common.base.Stopwatch;

public class StreamCipherDataGroup extends DataGroup<StreamCipherDataSet> {
	private volatile ArrayList<StreamCipherDataSet> data;
	private int runs;
	private String algorithm;
	private int bitlen;
	private int ivlen;
	
	public enum StreamCipher{RC4, SALSA20, ISAAC, HC256, GRAINV1, GRAIN128}
	private final BouncyCastleProvider PROVIDER = new BouncyCastleProvider();
	
	public StreamCipherDataGroup(int r, StreamCipher cipher){
		data = new ArrayList<>();
		runs = r;
		
		switch(cipher){
		case GRAIN128:
			algorithm = "Grain128";
			bitlen = 0;
			ivlen = 0;
			break;
		case GRAINV1:
			algorithm = "Grainv1";
			bitlen = 0;
			ivlen = 0;
			break;
		case HC256:
			algorithm = "HC256";
			bitlen = 256;
			ivlen = 0;
			break;
		case ISAAC:
			algorithm = "ISAAC";
			bitlen = 0;
			ivlen = 0;
			break;
		case RC4:
			algorithm = "RC4";
			bitlen = 0;
			ivlen = 0;
			break;
		case SALSA20:
			algorithm = "Salsa20";
			bitlen = 0;
			ivlen = 0;
			break;
		default:
			break;
		
		}
	}
	
	@Override
	public StreamCipherDataSet get(int x) {
		return data.get(x);
	}

	@Override
	public int getRuns() {
		return runs;
	}

	@Override
	public void add(StreamCipherDataSet t) {
		data.add(t);
	}

	@Override
	public void calcAggregate() {
		long keygentime = 0, ivgentime = 0, encrypttime = 0, decrypttime = 0, totaltime = 0;
		
		for(int x = 0; x < data.size(); x++){
			keygentime = keygentime + data.get(x).getKeyGenTime();
			ivgentime = ivgentime + data.get(x).getIVGenTime();
			encrypttime = encrypttime + data.get(x).getEncryptTime();
			decrypttime = decrypttime + data.get(x).getDecryptTime();
			totaltime = totaltime + data.get(x).getTotalTime();
		}
		
		keygentime = keygentime / data.size();
		ivgentime = ivgentime / data.size();
		encrypttime = encrypttime / data.size();
		decrypttime = decrypttime / data.size();
		totaltime = totaltime / data.size();
		
		data.add(new StreamCipherDataSet("Aggregate", algorithm, bitlen, ivlen, keygentime, ivgentime, encrypttime, decrypttime, totaltime));
	}

	@Override
	public synchronized void doBenchmark(String param) {
		for(int x = 0; x < runs; x++){
		Stopwatch total = Stopwatch.createStarted();
		
		//KEY GENERATION
		Stopwatch keyGenTimer = Stopwatch.createStarted();
		SecretKey secret = null;
		try {
			KeyGenerator gen = KeyGenerator.getInstance(algorithm, PROVIDER);
			gen.init(bitlen);
			secret = gen.generateKey();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		keyGenTimer.stop();
		long keyGenTime = keyGenTimer.elapsed(TimeUnit.NANOSECONDS);
		
		/*This part of the code gets weird:
		 * Essentially the Cipher will be initialized
		 * an IV will be extracted
		 * Then the encryption will be done 
		 */
		//ENCRYPTION + IV GENERATION
		Stopwatch ivGenTimer = Stopwatch.createStarted();
		Cipher encrypt = null;
		IvParameterSpec iv = null;
		try {
			encrypt = Cipher.getInstance(algorithm, PROVIDER);
			encrypt.init(Cipher.ENCRYPT_MODE, secret);
			iv = new IvParameterSpec(encrypt.getIV());
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
			e.printStackTrace();
		}
		ivGenTimer.stop();
		long ivGenTime = ivGenTimer.elapsed(TimeUnit.NANOSECONDS);
		byte[] ciphertext = null;
		Stopwatch encryptTimer = Stopwatch.createStarted();
		try{
			ciphertext = encrypt.doFinal(param.getBytes(Charset.forName("US-ASCII")));
		} catch(Exception e){
			e.printStackTrace();
		}
		encryptTimer.stop();
		long encryptTime = encryptTimer.elapsed(TimeUnit.NANOSECONDS);
		
		
		//DECRYPTION
		Stopwatch decryptTimer = Stopwatch.createStarted();
		Cipher decrypt = null;
		try {
			decrypt = Cipher.getInstance(algorithm, PROVIDER);
			decrypt.init(Cipher.DECRYPT_MODE, secret, iv);
			decrypt.doFinal(ciphertext);
		} catch (InvalidKeyException | InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		decryptTimer.stop();
		long decryptTime = decryptTimer.elapsed(TimeUnit.NANOSECONDS);
		
		total.stop();
		long totalTime = total.elapsed(TimeUnit.NANOSECONDS);
		
		data.add(new StreamCipherDataSet(Integer.toString(x), algorithm, bitlen, ivlen, keyGenTime, ivGenTime, encryptTime, decryptTime, totalTime));
		}
	}

}
