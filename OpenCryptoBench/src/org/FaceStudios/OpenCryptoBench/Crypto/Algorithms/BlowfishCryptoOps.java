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

public class BlowfishCryptoOps {
		//This is the redirect implementation for Blowfish
		//This will allow data to be logged and processed
		//All methods should be static
		//Logger Implementaion
		private static final Logger LOGGER = Logger.getLogger(BlowfishCryptoOps.class.getName());
		//Stopwatch Implementation
		private static Stopwatch stopwatch;
		private static Cipher c;
		private static Cipher c1;
		private static SecretKey secret;
		protected static KeyGenerator gen;
		
		public static void performBlowfish(int bitlen,CryptoObject thing, String file){
			try {
				LOGGER.addHandler(new FileHandler(file));
			} catch (SecurityException | IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			LOGGER.info("##############################################################");
			LOGGER.info("BEGIN BLOWFISH PROCEDURE");
			LOGGER.info("##############################################################");
			LOGGER.info("Starting Stopwatch");
			stopwatch = Stopwatch.createStarted();
			LOGGER.info("Starting Encryption procedures for Blowfish");
			LOGGER.config("Creating a SecretKey Generator");
			try {
				gen = KeyGenerator.getInstance("Blowfish");
			} catch (NoSuchAlgorithmException e1) {
				LOGGER.severe("ERROR: Could not find Algorithm Blowfish");
				e1.printStackTrace();
			}
			LOGGER.config("Initializing the generator for bitlength of "+bitlen+" bits");
		
			gen.init(bitlen);
			
			LOGGER.config("Generating Key");
			
			secret = gen.generateKey();
			
			
			LOGGER.config("CryptoObject's input string is "+thing.getInput());
			LOGGER.config("CryptoObject's SecretKey Object is "+Hex.encodeHexString(secret.getEncoded()));
			LOGGER.info("Initializing Cipher as Blowfish");
			try {
				c = Cipher.getInstance("Blowfish/PKCS5Padding");
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
			//TODO Finish Encryption
			LOGGER.info("Restarting Stopwatch");
			stopwatch.start();		
			LOGGER.info("Using Output string "+out+" for decryption");
			LOGGER.info("Using SecretKey "+Hex.encodeHexString(secret.getEncoded())+" as SecretKey for decryption");
			LOGGER.info("Starting Decryption process for Blowfish");
			try {
				c1 = Cipher.getInstance("Blowfish/PKCS5Padding");
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
			LOGGER.info("END BLOWFISH PROCEDURE");
			LOGGER.info("#################################################################");
		}
}
