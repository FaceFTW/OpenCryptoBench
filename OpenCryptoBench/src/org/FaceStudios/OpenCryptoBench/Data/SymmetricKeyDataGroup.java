package org.FaceStudios.OpenCryptoBench.Data;

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

import org.FaceStudios.OpenCryptoBench.Crypto.CryptoObject;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.google.common.base.Stopwatch;

public class SymmetricKeyDataGroup {
	
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
	protected static KeyGenerator gen;
	private static int bitlen;
	
	public static enum SymmetricKeyCipher {AES, DES, DESEDE, TWOFISH, SERPENT, RC2, RC5, RC6, BLOWFISH, THREEFISH, RC4, SALSA20, GRAIN128, ISSAC, HC256};
	
	
	private static ArrayList<SymmetricKeyDataSet> data;
	
	public SymmetricKeyDataGroup(int x){
		data = new ArrayList<SymmetricKeyDataSet>();
	}
	
	public SymmetricKeyDataSet get(int x){
		return data.get(x);
	}
	public synchronized void calcAggregate(){
		long temp2 = 0, temp3 = 0, temp4 = 0, temp5 = 0;
		
		for(int x = 0; x<data.size();x++){
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
	public synchronized void performSymmetricKeyCipherBench(SymmetricKeyCipher cipher, CryptoObject thing){
		PROVIDER = new BouncyCastleProvider();		
		switch(cipher){
				case AES:
					algorithm = "AES";
					bitlen = 256;
					break;
				case DES:
					algorithm = "DES";
					bitlen = 56;
					break;
				case DESEDE:
					algorithm = "DESede";
					bitlen = 168;
					break;
				case TWOFISH:
					algorithm = "TwoFish";
					bitlen = 128;
					break;
				case SERPENT:
					algorithm = "Serpent";
					bitlen = 128;
					break;
				case RC2:
					algorithm = "RC2";
					bitlen = 128;
					break;
				case RC5:
					algorithm = "RC5";
					bitlen = 128;
					break;
				case RC6:
					algorithm = "RC6";
					bitlen = 128;
					break;
				case BLOWFISH:
					algorithm = "Blowfish";
					bitlen = 128;
					break;
				case THREEFISH:
					algorithm = "ThreeFish";
					bitlen = 256;
					break;
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
					throw new IllegalArgumentException("ERROR: The Algorithm could not be identified as a block cipher");
			}
			for(int x = 0;x< data.size()-2;x++){
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
			
			data.add(new SymmetricKeyDataSet(Integer.toString(x),keygenTime,encryptTime,decryptTime,totalTime,bitlen,algorithm)); 
			}
	}
	
	public int size() {
		return data.size();
	}
	
}
