package org.FaceStudios.OpenCryptoBench.Data;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.KeyGenerator;

import org.bouncycastle.jcajce.provider.symmetric.AES;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.google.common.base.Stopwatch;

public class BlockCipherDataGroup extends DataGroup<BlockCipherDataSet>{
	private volatile ArrayList<BlockCipherDataSet> data;
	private int runs;
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
			break;
		case BLOWFISH:
			algorithm = "Blowfish";
			break;
		case DES:
			algorithm = "DES";
			break;
		case DESEDE:
			algorithm = "DESede";
			break;
		case RC2:
			algorithm = "RC2";
			break;
		case RC5:
			algorithm = "RC5";
			break;
		case SERPENT:
			algorithm = "Serpent";
			break;
		case THREEFISH:
			algorithm = "Threefish";
			break;
		case TWOFISH:
			algorithm = "Twofish";
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
		Stopwatch total = Stopwatch.createStarted();
		
		Stopwatch keyGenTimer = Stopwatch.createStarted();
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance(algorithm, PROVIDER);
			keyGen.init();		
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
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
