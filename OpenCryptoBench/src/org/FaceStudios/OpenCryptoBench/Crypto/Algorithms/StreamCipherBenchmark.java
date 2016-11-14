package org.FaceStudios.OpenCryptoBench.Crypto.Algorithms;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.FaceStudios.OpenCryptoBench.Crypto.CryptoObject;
import org.FaceStudios.OpenCryptoBench.Data.SymmetricCipherDataSet;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.google.common.base.Stopwatch;

public class StreamCipherBenchmark {
	private static final BouncyCastleProvider PROVIDER = new BouncyCastleProvider();
	private static Stopwatch stopwatch;
	private static Stopwatch s2;
	private static long keygenTime;
	private static long encryptTime;
	private static long decryptTime;
	private static long totalTime;
	private static Cipher c;
	private static Cipher c1;
	private static SecretKey secret;
	private static String algorithm;
	protected static KeyGenerator gen;
	private static int bitlen;
	
	public enum StreamCipher{RC4, SALSA20, GRAIN128, ISSAC, HC256}
	
	@SuppressWarnings("unused")
	public static SymmetricCipherDataSet performStreamCipherBenchmark(StreamCipher cipher,CryptoObject thing, int n){
		switch(cipher){
		case RC4:
			algorithm = "RC4";
			bitlen = 256;
			break;
		case SALSA20:
			algorithm = "Salsa20";
			bitlen = 128;
			break;
		case GRAIN128:
			algorithm = "Grain128";
			bitlen = 128;
			break;
		case ISSAC:
			algorithm = "ISSAC";
			bitlen = 256;
			break;
		case HC256:
			algorithm = "HC256";
			bitlen = 256;
			break;
		default:
			throw new IllegalArgumentException("ERROR: The Algorithm could not be identified as a stream cipher");
		}
	encryptTime = 0;
	decryptTime = 0;
	keygenTime = 0;
	totalTime=  0;
	//Total Time Stopwatch
	stopwatch = Stopwatch.createStarted();
	
	try {
		gen = KeyGenerator.getInstance(algorithm,PROVIDER);
		gen.init(bitlen);

	} catch (NoSuchAlgorithmException e1) {
		e1.printStackTrace();
	}
	
	s2 = Stopwatch.createStarted();
	secret = gen.generateKey();
	s2.stop();
	keygenTime = s2.elapsed(TimeUnit.NANOSECONDS);
	s2.reset();
	try {
		c = Cipher.getInstance(algorithm,PROVIDER);
		c.init(Cipher.ENCRYPT_MODE, secret);

	} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
		e.printStackTrace();
	}
	byte[] outBytes = null;
	s2.start();
	try {
		outBytes = c.doFinal(thing.getInput().getBytes());
	} catch (IllegalBlockSizeException | BadPaddingException e) {
		e.printStackTrace();
	}
	s2.stop();
	encryptTime = s2.elapsed(TimeUnit.NANOSECONDS);
	s2.reset();
	try {
		c1 = Cipher.getInstance(algorithm,PROVIDER);
		c1.init(Cipher.DECRYPT_MODE, secret);

	} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
	e.printStackTrace();
	}
	s2.start();
	try {
	byte[] out1Bytes = c1.doFinal(outBytes);
	} catch (IllegalBlockSizeException | BadPaddingException e) {
		e.printStackTrace();
	}
	s2.stop();
	decryptTime = s2.elapsed(TimeUnit.NANOSECONDS);
	
	stopwatch.stop();
	totalTime = stopwatch.elapsed(TimeUnit.NANOSECONDS);
	return new SymmetricCipherDataSet(Integer.toString(n),keygenTime,encryptTime, decryptTime, totalTime, bitlen, algorithm);
	

}

}
