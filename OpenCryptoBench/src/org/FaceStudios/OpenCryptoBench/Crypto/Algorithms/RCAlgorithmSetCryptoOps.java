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

public class RCAlgorithmSetCryptoOps {
	//This is the redirect implementation for the RC Algorithms (RC2, RC4, RC5, and ARCFOUR)
			//This will allow data to be logged and processed
			//All methods should be static
			
			//Logger Implementaion
			private static final Logger LOGGER = Logger.getLogger(RCAlgorithmSetCryptoOps.class.getName());
			//Stopwatch Implementation
			private static Stopwatch stopwatch;
			private static Cipher c;
			private static Cipher c1;
			//TODO Adjust Procedure As Needed
			public static void performRC2(CryptoObject thing){
				LOGGER.info("##############################################################");
				LOGGER.info("BEGIN RC2 PROCEDURE");
				LOGGER.info("##############################################################");
				LOGGER.info("Starting Stopwatch");
				stopwatch = Stopwatch.createStarted();
				LOGGER.info("Starting Encryption procedures for RC2");
				LOGGER.config("CryptoObject's input string is "+thing.getInput());
				LOGGER.config("CryptoObject's SecretKey Object is "+Hex.encodeHexString(thing.getKey().getEncoded()));
				LOGGER.info("Initializing Cipher as RC2");
				try {
					c = Cipher.getInstance("RC2/PKCS5Padding");
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
				LOGGER.info("Using SecretKey "+Hex.encodeHexString(thing.getKey().getEncoded())+" as SecretKey for decryption");
				LOGGER.info("Starting Decryption process for RC2");
				try {
					c1 = Cipher.getInstance("RC2/PKCS5Padding");
					c1.init(Cipher.DECRYPT_MODE, thing.getKey());
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
				LOGGER.info("END RC2 PROCEDURE");
				LOGGER.info("#################################################################");
			}
			public static void performRC4(CryptoObject thing){
				LOGGER.info("##############################################################");
				LOGGER.info("BEGIN RC4 PROCEDURE");
				LOGGER.info("##############################################################");
				LOGGER.info("Starting Stopwatch");
				stopwatch = Stopwatch.createStarted();
				LOGGER.info("Starting Encryption procedures for RC4");
				LOGGER.config("CryptoObject's input string is "+thing.getInput());
				LOGGER.config("CryptoObject's SecretKey Object is "+Hex.encodeHexString(thing.getKey().getEncoded()));
				LOGGER.info("Initializing Cipher as RC4");
				try {
					c = Cipher.getInstance("RC4/PKCS5Padding");
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
				LOGGER.info("Using SecretKey "+Hex.encodeHexString(thing.getKey().getEncoded())+" as SecretKey for decryption");
				LOGGER.info("Starting Decryption process for RC4");
				try {
					c1 = Cipher.getInstance("RC4/PKCS5Padding");
					c1.init(Cipher.DECRYPT_MODE, thing.getKey());
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
				LOGGER.info("END RC4 PROCEDURE");
				LOGGER.info("#################################################################");
			}
			
			public static void performRC5(CryptoObject thing){
				LOGGER.info("##############################################################");
				LOGGER.info("BEGIN RC5 PROCEDURE");
				LOGGER.info("##############################################################");
				LOGGER.info("Starting Stopwatch");
				stopwatch = Stopwatch.createStarted();
				LOGGER.info("Starting Encryption procedures for RC5");
				LOGGER.config("CryptoObject's input string is "+thing.getInput());
				LOGGER.config("CryptoObject's SecretKey Object is "+Hex.encodeHexString(thing.getKey().getEncoded()));
				LOGGER.info("Initializing Cipher as RC5");
				try {
					c = Cipher.getInstance("RC5/PKCS5Padding");
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
				LOGGER.info("Using SecretKey "+Hex.encodeHexString(thing.getKey().getEncoded())+" as SecretKey for decryption");
				LOGGER.info("Starting Decryption process for RC5");
				try {
					c1 = Cipher.getInstance("RC5/PKCS5Padding");
					c1.init(Cipher.DECRYPT_MODE, thing.getKey());
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
				LOGGER.info("END RC5 PROCEDURE");
				LOGGER.info("#################################################################");
			}
			
			public static void performARCFOUR(CryptoObject thing){
				LOGGER.info("##############################################################");
				LOGGER.info("BEGIN ARCFOUR PROCEDURE");
				LOGGER.info("##############################################################");
				LOGGER.info("Starting Stopwatch");
				stopwatch = Stopwatch.createStarted();
				LOGGER.info("Starting Encryption procedures for ARCFOUR");
				LOGGER.config("CryptoObject's input string is "+thing.getInput());
				LOGGER.config("CryptoObject's SecretKey Object is "+Hex.encodeHexString(thing.getKey().getEncoded()));
				LOGGER.info("Initializing Cipher as ARCFOUR");
				try {
					c = Cipher.getInstance("ARCFOUR/PKCS5Padding");
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
				LOGGER.info("Using SecretKey "+Hex.encodeHexString(thing.getKey().getEncoded())+" as SecretKey for decryption");
				LOGGER.info("Starting Decryption process for ARCFOUR");
				try {
					c1 = Cipher.getInstance("ARCFOUR/PKCS5Padding");
					c1.init(Cipher.DECRYPT_MODE, thing.getKey());
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
				LOGGER.info("END ARCFOUR PROCEDURE");
				LOGGER.info("#################################################################");
			}
}
