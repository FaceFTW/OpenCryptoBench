package org.FaceStudios.OpenCryptoBench.Crypto.Algorithms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.FaceStudios.OpenCryptoBench.OpenCryptoBench;
import org.FaceStudios.OpenCryptoBench.Crypto.CryptoObject;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.google.common.base.Stopwatch;

public class RCAlgorithmSetCryptoOps {
	//This is the redirect implementation for the RC Algorithms (RC2, ARC4, RC5, and ARCFOUR)

	//This will allow data to be logged and processed
	//All methods should be static

	//Logger Implementaion
	public static final BouncyCastleProvider PROVIDER = new BouncyCastleProvider();
	@SuppressWarnings("static-access")
	public static final Logger LOGGER =  OpenCryptoBench.GLOBALLOG.getLogger(RCAlgorithmSetCryptoOps.class.getName());
	//Stopwatch Implementation
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
	protected static KeyGenerator gen;

	public static void performRC4(int bitlen,CryptoObject thing, int n){
		LOGGER.setUseParentHandlers(true);
		encryptTime = 0;
		encryptAgTime = 0;
		decryptTime = 0;
		decryptAgTime = 0;
		keygenTime = 0;
		cryptoTime=  0;
		totalTime=  0;
		stopwatch = Stopwatch.createStarted();
		try {
			gen = KeyGenerator.getInstance("RC4",PROVIDER);
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}

		gen.init(bitlen);
		s2 = Stopwatch.createStarted();
		secret = gen.generateKey();
		s2.stop();
		keygenTime = s2.elapsed(TimeUnit.NANOSECONDS);
		cryptoTime = cryptoTime+keygenTime;
		s2.reset();
		try {
			c = Cipher.getInstance("RC4",PROVIDER);
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
			c1 = Cipher.getInstance("RC4",PROVIDER);
			c1.init(Cipher.DECRYPT_MODE, secret);

		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
			e.printStackTrace();
		}
		byte[] out1Bytes = null;
		s2.start();
		try {
			out1Bytes = c1.doFinal(outBytes);
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
			print.write(n+","+keygenTime+","+encryptTime+","+decryptTime+","+totalTime+","+bitlen+","+"RC4");
			print.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}

