package org.FaceStudios.OpenCryptoBench.Data;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.FaceStudios.OpenCryptoBench.Data.PublicKeyDataSet.PublicKeyCipher;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.google.common.base.Stopwatch;

public class PublicKeyDataGroup extends DataGroup<PublicKeyDataSet> {
	private volatile ArrayList<PublicKeyDataSet> data;
	private int runs;
	private int pubKeyBitLen;
	private String algorithm;
	private PublicKeyCipher cipher;
	
	private static final BouncyCastleProvider PROVIDER = new BouncyCastleProvider();
	
	public PublicKeyDataGroup(int x, PublicKeyCipher c){
		data = new ArrayList<>();
		runs = x;
		cipher = c;
		switch(cipher){
		case ELGAMAL:
			algorithm = "ElGamal";
			pubKeyBitLen = 2048;
			break;
		case RSA:
			algorithm = "RSA";
			pubKeyBitLen = 2048;
			break;
		default:
			break;
		
		}
	}

	@Override
	public int getRuns() {
		return runs;
	}
	
	@Override
	public PublicKeyDataSet get(int x) {
		return data.get(x);
	}
	
	@Override
	public void add(PublicKeyDataSet t) {
		data.add(t);
	}

	@Override
	public void calcAggregate() {
		long pubKeyGenTime = 0;
		long encryptTime = 0;
		long decryptTime = 0;
		long totalTime = 0;
		
		for(int x = 0; x < data.size(); x++){
			pubKeyGenTime = pubKeyGenTime + data.get(x).getPublicKeyGenerationTime();
			encryptTime = encryptTime + data.get(x).getEncryptTime();
			decryptTime = decryptTime + data.get(x).getDecryptTime();
			totalTime = totalTime + data.get(x).getTotalTime();
		}
		
		data.add(new PublicKeyDataSet("Aggregate", data.get(0).getAlgorithm(), pubKeyGenTime, encryptTime, decryptTime, totalTime));

	}

	@Override
	public synchronized void doBenchmark(String param) {
		
		for(int x = 0; x< runs; x++){
			Stopwatch total = Stopwatch.createStarted();
		
		
		//KEY GENERATION
		Stopwatch pubKeyGenTimer = Stopwatch.createStarted();
		SecureRandom rand;
		KeyPairGenerator gen;
		KeyPair pair;
		PublicKey key = null;
		try {
			gen = KeyPairGenerator.getInstance(algorithm, PROVIDER);
			rand = SecureRandom.getInstance("SHA1PRNG", "SUN");
			gen.initialize(pubKeyBitLen, rand);
			pair = gen.generateKeyPair();
			key = pair.getPublic();
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			e.printStackTrace();
		}
		pubKeyGenTimer.stop();
		long pubKeyGenTime = pubKeyGenTimer.elapsed(TimeUnit.NANOSECONDS);
		
		
		//ENCRYPTION
		Stopwatch encryptTimer = Stopwatch.createStarted();
		Cipher c;
		byte[] ciphertext = null;
		try {
			c = Cipher.getInstance(algorithm, PROVIDER);
			c.init(Cipher.ENCRYPT_MODE, key);
			ciphertext = c.doFinal(param.getBytes(Charset.forName("US-ASCII")));
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		encryptTimer.stop();
		long encryptTime = encryptTimer.elapsed(TimeUnit.NANOSECONDS);
		
		
		//DECRYPTION
		Stopwatch decryptTimer = Stopwatch.createStarted();
		Cipher d;
		try {
			d = Cipher.getInstance(algorithm, PROVIDER);
			d.init(Cipher.DECRYPT_MODE, key);
			d.doFinal(ciphertext);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
			e.printStackTrace();
		}
		decryptTimer.stop();
		long decryptTime = decryptTimer.elapsed(TimeUnit.NANOSECONDS);
		
		total.stop();
		long totalTime = total.elapsed(TimeUnit.NANOSECONDS);
		
		data.add(new PublicKeyDataSet(Integer.toString(x+1), cipher, pubKeyGenTime, encryptTime, decryptTime, totalTime));
		}
	}

	

}
