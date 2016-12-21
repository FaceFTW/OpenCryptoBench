package org.FaceStudios.OpenCryptoBench.Data;

import java.nio.charset.Charset;
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

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.google.common.base.Stopwatch;

public class BlockCipherDataGroup extends DataGroup<BlockCipherDataSet>{
	private volatile ArrayList<BlockCipherDataSet> data;
	private int runs;
	private int bitlen;
	private String algorithm;
	
	public enum BlockCipher{AES, DES, DESEDE, BLOWFISH, TWOFISH, THREEFISH, RC2, RC5, SERPENT}
	private static final BouncyCastleProvider PROVIDER = new BouncyCastleProvider();
	
	public BlockCipherDataGroup(int x, BlockCipher cipher) {
		super();
		data = new ArrayList<>();
		runs = x;
		
		switch(cipher){
		case AES:
			algorithm = "AES";
			bitlen = 256;
			break;
		case BLOWFISH:
			algorithm = "Blowfish";
			bitlen = 448;
			break;
		case DES:
			algorithm = "DES";
			bitlen = 56;
			break;
		case DESEDE:
			algorithm = "DESede";
			bitlen = 168;
			break;
		case RC2:
			algorithm = "RC2";
			bitlen = 256;
			break;
		case RC5:
			algorithm = "RC5";
			bitlen = 256;
			break;
		case SERPENT:
			algorithm = "Serpent";
			bitlen = 128;
			break;
		case THREEFISH:
			algorithm = "Threefish";
			bitlen = 256;
			break;
		case TWOFISH:
			algorithm = "Twofish";
			bitlen = 128;
			break;
		default:
			break;
		}
	}
	
	@Override
	public void calcAggregate() {
		String run = "Aggregate";
		String algorithm = data.get(0).getAlgorithm();
		long keyGenTime = 0;
		long encryptTime = 0;
		long decryptTime = 0;
		long totalTime = 0;
		
		for(int x = 0; x < data.size(); x++){
			keyGenTime = keyGenTime + data.get(x).getKeyGenTime();
			encryptTime = encryptTime + data.get(x).getEncryptTime();
			decryptTime = decryptTime + data.get(x).getDecryptTime();
			totalTime = totalTime + data.get(x).getTotalTime();
		}
		
		keyGenTime = keyGenTime/data.size();
		encryptTime = encryptTime/data.size();
		decryptTime = decryptTime/data.size();
		totalTime = totalTime/data.size();
		
		data.add(new BlockCipherDataSet(run, algorithm, keyGenTime, encryptTime, decryptTime, totalTime));	
	}

	
	public synchronized void doBenchmark(String param){
		for(int x = 0 ; )
		Stopwatch total = Stopwatch.createStarted();
		
		//KEY GENERATION BENCHMARK
		Stopwatch keyGenTimer = Stopwatch.createStarted();
		SecretKey key = null;
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance(algorithm, PROVIDER);
			keyGen.init(bitlen);
			key = keyGen.generateKey();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		keyGenTimer.stop();
		long keyGenTimeResult = keyGenTimer.elapsed(TimeUnit.NANOSECONDS);
		
		
		//ENCRYPTION BENCHMARK
		byte[] cipherText = null;
		Cipher encrypt;
		Stopwatch encryptTimer = Stopwatch.createStarted();
		try {
			encrypt = Cipher.getInstance(algorithm, PROVIDER);
			encrypt.init(Cipher.ENCRYPT_MODE, key);
			cipherText = encrypt.doFinal(param.getBytes(Charset.forName("US-ASCII")));
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		encryptTimer.stop();
		long encryptTimeResult = encryptTimer.elapsed(TimeUnit.NANOSECONDS);
		
		
		//DECRYPTION BENCHMARK
		Cipher decrypt;
		Stopwatch decryptTimer = Stopwatch.createStarted();
		try {
			decrypt = Cipher.getInstance(algorithm, PROVIDER);
			decrypt.init(Cipher.DECRYPT_MODE, key);
			decrypt.doFinal(cipherText);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		decryptTimer.stop();
		long decryptTimeResult = decryptTimer.elapsed(TimeUnit.NANOSECONDS);
		
		
		//Total Time Result
		total.stop();
		long totalTimeResult = total.elapsed(TimeUnit.NANOSECONDS);
		
		data.add(new BlockCipherDataSet());
		
	}
	
	@Override
	public BlockCipherDataSet get(int x) {
		return data.get(x);
	}

	@Override
	public int getRuns() {
		return runs;
	}
	
	public String getAlgorithm(){
		return algorithm;
	}
	
	public void add(BlockCipherDataSet t) {
		data.add(t);		
	}


}
