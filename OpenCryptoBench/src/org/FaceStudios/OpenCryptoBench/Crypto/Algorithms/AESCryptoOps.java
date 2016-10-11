package org.FaceStudios.OpenCryptoBench.Crypto.Algorithms;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import org.FaceStudios.OpenCryptoBench.Crypto.CryptoObject;
import org.apache.commons.codec.binary.Hex;
import com.google.common.base.Stopwatch;

public class AESCryptoOps {
	//This is the redirect implementation for AES
	//This will allow data to be logged and processed
	//All methods should be static
	//Logger Implementaion
	private static final Logger LOGGER = Logger.getLogger(AESCryptoOps.class.getName());
	//Stopwatch Implementation
	private static Stopwatch stopwatch;
	//CryptoObjects and things...
	private static Cipher c;
	private static Cipher c1;
	private static SecretKey secret;
	protected static KeyGenerator gen;
	
	public static void performAES(int bitlen, CryptoObject thing, String file){
		try {
			LOGGER.addHandler(new FileHandler(file));
		} catch (SecurityException | IOException e2) {
			e2.printStackTrace();
		}
		LOGGER.info("##############################################################");
		LOGGER.info("BEGIN AES PROCEDURE");
		LOGGER.info("##############################################################");
		LOGGER.info("Starting Stopwatch");
		stopwatch = Stopwatch.createStarted();
		LOGGER.info("Starting Encryption procedures for AES");
		LOGGER.config("Making a SecretKey Generator");
		try {
			gen = KeyGenerator.getInstance("AES");
		} catch (NoSuchAlgorithmException e1) {
			LOGGER.severe("ERROR: Algorithm AES Could not be registered");
			e1.printStackTrace();
		}
		LOGGER.config("Initializing KeyGenerator Object");
		gen.init(bitlen);
		LOGGER.config("Generating SecretKey of bitlength "+bitlen+" bits");
		secret = gen.generateKey();
		LOGGER.config("CryptoObject's input string is "+thing.getInput());
		LOGGER.config("CryptoObject's SecretKey Object is "+Hex.encodeHexString(secret.getEncoded()));
		LOGGER.config("Bit-size of key for encryption is "+bitlen+" bits");
		LOGGER.info("Initializing Cipher as AES, "+bitlen+" bit key");
		try {
			c = Cipher.getInstance("AES/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE, secret);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
			LOGGER.severe("ERROR: Cipher object could not initialize with given algorithm and parameter");
			e.printStackTrace();
		}
		LOGGER.config("Success in initializing Cipher with given params");
		LOGGER.info("Creating an output String");
		String out = "";
		LOGGER.config("Starting Encryption");
		try {
			out = Hex.encodeHexString(c.doFinal(thing.getInput().getBytes()));
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			LOGGER.severe("ERROR: Cipher could not execute encryption");
			e.printStackTrace();
		}
		LOGGER.info("Success");
		LOGGER.info("Output string is " +out);
		LOGGER.info("Stopping Stopwatch for Encryption");
		stopwatch.stop();
		LOGGER.info("Time Elapsed for Encryption is "+stopwatch.elapsed(TimeUnit.MILLISECONDS) );
		LOGGER.info("Resetting Stopwatch");
		stopwatch.reset();
		LOGGER.config("Success in resetting stopwatch");
		LOGGER.info("Restarting Stopwatch");
		stopwatch.start();		
		LOGGER.info("Using Output string "+out+" for decryption");
		LOGGER.info("Using SecretKey "+Hex.encodeHexString(secret.getEncoded())+" as SecretKey for decryption");
		LOGGER.info("Starting Decryption process for AES, "+bitlen+" bit key");
		try {
			c1 = Cipher.getInstance("AES/PKCS5Padding");
			c1.init(Cipher.DECRYPT_MODE, secret);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
			LOGGER.severe("ERROR: Could not initialize the cipher object with given parameters");
			e.printStackTrace();
		}
		LOGGER.config("Success in initializing a Cipher");
		LOGGER.config("Creating an output String");
		String out1 = "";
		LOGGER.info("Starting Decryption");
		try {
			out = new String(c1.doFinal(out1.getBytes()));
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			LOGGER.severe("ERROR: Could Not Decrypt Data");
			e.printStackTrace();
		}
		LOGGER.info("Success");
		LOGGER.info("Output string is"+out);
		LOGGER.info("Stopping Stopwatch");
		stopwatch.stop();
		LOGGER.info("Time elapsed is "+ stopwatch.elapsed(TimeUnit.MILLISECONDS));
		LOGGER.info("#################################################################");
		LOGGER.info("END AES PROCEDURE");
		LOGGER.info("#################################################################");
		}
}
	
