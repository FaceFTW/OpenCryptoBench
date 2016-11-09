package org.FaceStudios.OpenCryptoBench.Crypto.Algorithms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.google.common.base.Stopwatch;

public class BlockCipherBenchmark {
	private static final BouncyCastleProvider PROVIDER = new BouncyCastleProvider();
	private static Stopwatch stopwatch;
	private static Stopwatch s2;
	private static long keygenTime;
	private static long encryptTime;
	private static long encryptAgTime;
	private static long decryptAgTime;
	private static long decryptTime;
	private static long cryptoTime;
	private static long totalTime;
	private static Cipher c;
	private static Cipher c1;
	private static SecretKey secret;
	private static String algorithm;
	protected static KeyGenerator gen;
	
	public static enum BlockCipher {AES, DES, DESEDE, TWOFISH, SERPENT, RC2, RC5, RC6, BLOWFISH, THREEFISH};

	@SuppressWarnings("unused")
	public static void performBlockCipherBench(BlockCipher cipher, int bitlen, CryptoObject thing, int n){
		switch(cipher){
			case AES:
				algorithm = "AES";
				break;
			case DES:
				algorithm = "DES";
				break;
			case DESEDE:
				algorithm = "DESede";
				break;
			case TWOFISH:
				algorithm = "TwoFish";
				break;
			case SERPENT:
				algorithm = "Serpent";
				break;
			case RC2:
				algorithm = "RC2";
				break;
			case RC5:
				algorithm = "RC5";
			case RC6:
				algorithm = "RC6";
				break;
			case BLOWFISH:
				algorithm = "Blowfish";
				break;
			case THREEFISH:
				algorithm = "ThreeFish";
				break;
			default:
				throw new IllegalArgumentException("ERROR: The Algorithm could not be identified as a block cipher");
		}
		encryptTime = 0;
		decryptTime = 0;
		keygenTime = 0;
		cryptoTime=  0;
		totalTime=  0;
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
		cryptoTime = cryptoTime+keygenTime;
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
		cryptoTime = cryptoTime+encryptTime;
		s2.reset();
		stopwatch.stop();
		encryptAgTime = stopwatch.elapsed(TimeUnit.NANOSECONDS);
		totalTime = totalTime+encryptAgTime;
		stopwatch.reset();
		stopwatch.start();
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
		cryptoTime = cryptoTime+decryptTime;
		stopwatch.stop();
		decryptAgTime = stopwatch.elapsed(TimeUnit.NANOSECONDS);
		totalTime = totalTime+decryptAgTime;
		BufferedWriter print = null;
		try {
			print = new BufferedWriter(new FileWriter(new File("OpenCryptoBench.csv"),true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			print.newLine();
			print.write((n+1)+","+keygenTime+","+encryptTime+","+decryptTime+","+totalTime+","+bitlen+","+algorithm);
			print.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
