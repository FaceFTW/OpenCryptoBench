package org.FaceStudios.OpenCryptoBench.Crypto.Algorithms;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
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
	private static Cipher c;
	
	public static void performAES(int bitlen, CryptoObject thing){
		LOGGER.info("Starting Stopwatch");
		stopwatch = Stopwatch.createStarted();
		LOGGER.info("Starting Encryption procedures for AES");
		LOGGER.config("CryptoObject's input string is "+thing.getInput());
		LOGGER.config("CryptoObject's SecretKey Object is "+Hex.encodeHexString(thing.getKey().getEncoded()));
		LOGGER.config("Bit-size of key for encryption is "+bitlen+" bits");
		LOGGER.info("Initializing Cipher as AES, "+bitlen+" bit key");
		try {
			c = Cipher.getInstance("AES/PKCS5 Padding");
			c.init(Cipher.ENCRYPT_MODE, thing.getKey());
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
			LOGGER.severe("ERROR: Cipher object could not initialize with given algorithm and parameter");
			e.printStackTrace();
		}
		LOGGER.config("Success in initializing Cipher with given params");
		LOGGER.info("Creating an output String");
		String out = "";
		LOGGER.config("Starting Encryption");
		try {
			out = Hex.encodeHexString(c.doFinal());
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
		}
}
	
