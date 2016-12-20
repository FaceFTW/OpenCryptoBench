package org.FaceStudios.OpenCryptoBench.Data.depreciated;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.FaceStudios.OpenCryptoBench.Crypto.CryptoObject;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.google.common.base.Stopwatch;

public class StreamCipherDataGroup {
	
	private static BouncyCastleProvider PROVIDER; //Initialize in later in the class
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
	private static KeyGenerator gen;
	private static int bitlen;
	private static int runs;
	private static int ivsize;
	
	public static enum StreamCipher{ RC4, SALSA20, GRAIN128, ISAAC, HC256}
	
private static ArrayList<SymmetricKeyDataSet> data;
	
	public StreamCipherDataGroup(int x){
		data = new ArrayList<SymmetricKeyDataSet>();
		runs = x;
	}
	
	public SymmetricKeyDataSet get(int x){
		return data.get(x);
	}
	public synchronized void calcAggregate(){
		long temp2 = 0, temp3 = 0, temp4 = 0, temp5 = 0;
		
		for(int x = 0; x<runs;x++){
			temp2 = temp2+data.get(x).getKeyGenTime();
			temp3 = temp3+data.get(x).getEncryptTime();
			temp4 = temp4+data.get(x).getDecryptTime();
			temp5 = temp5+data.get(x).getTotalTime();
		}
		
		temp2 = temp2/data.size();
		temp3 = temp3/data.size();
		temp4 = temp4/data.size();
		temp5 = temp5/data.size();
		
		data.add(new SymmetricKeyDataSet("Aggregate", temp2, temp3, temp4, temp5,data.get(0).getBitLength(),data.get(0).getAlgorithm()));
	}
	
	@SuppressWarnings("unused")
	public void doBenchmark(StreamCipher cipher, CryptoObject thing){
		switch(cipher){
			case RC4:
				algorithm = "RC4";
				ivsize = 0;
				bitlen = 256;
				break;
			case SALSA20:
				algorithm = "Salsa20";
				ivsize = 0;
				bitlen = 256;
				break;
			case GRAIN128:
				algorithm = "RC4";
				ivsize = 0;
				bitlen = 256;
				break;
			case ISAAC:
				algorithm = "RC4";
				ivsize = 0;
				bitlen = 256;
				break;
			case HC256:
				algorithm = "HC256";
				ivsize = 0;
				bitlen = 256;
		}
		for(int x = 0;x< runs;x++){
			encryptTime = 0;
			decryptTime = 0;
			keygenTime = 0;
			totalTime=  0;
			//Total Time Stopwatch
			stopwatch = Stopwatch.createStarted();
			final byte[] ivData = new byte[ivsize];
			// create (or retrieve) a cryptographic secure random implementation (auto-seeded)
			final SecureRandom rng = new SecureRandom();
			// fill the IV array with random data
			rng.nextBytes(ivData);
			// generate the ParameterSpec (to create a general parameter for Cipher.init())
			IvParameterSpec iv = new IvParameterSpec(ivData);
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
				c.init(Cipher.ENCRYPT_MODE, secret, iv);

			} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException e) {
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
				c1.init(Cipher.DECRYPT_MODE, secret, iv);

			} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException e) {
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
			
			data.add(new SymmetricKeyDataSet(Integer.toString(x),keygenTime,encryptTime,decryptTime,totalTime,bitlen,algorithm)); 
			}
	}
}
