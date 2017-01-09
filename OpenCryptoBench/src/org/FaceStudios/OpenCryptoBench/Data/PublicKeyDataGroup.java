package org.FaceStudios.OpenCryptoBench.Data;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.KeyGenerator;

import org.FaceStudios.OpenCryptoBench.Data.PublicKeyDataSet.PublicKeyCipher;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.google.common.base.Stopwatch;

public class PublicKeyDataGroup extends DataGroup<PublicKeyDataSet> {
	private volatile ArrayList<PublicKeyDataSet> data;
	private int runs;
	private int pubKeyBitLen;
	private String algorithm;
	
	private static final BouncyCastleProvider PROVIDER = new BouncyCastleProvider();
	
	PublicKeyDataGroup(int x, PublicKeyCipher cipher){
		data = new ArrayList<>();
		runs = x;
		switch(cipher){
		case ELGAMAL:
			algorithm = "ElGamal";
			pubKeyBitLen = 2048;
			break;
		case RSA:
			algorithm = "RSA";
			pubKeyBitLen = 2048;
			break;
		default:
			break;
		
		}
	}

	@Override
	public int getRuns() {
		return runs;
	}
	
	@Override
	public PublicKeyDataSet get(int x) {
		return data.get(x);
	}
	
	@Override
	public void add(PublicKeyDataSet t) {
		data.add(t);
	}

	@Override
	public void calcAggregate() {
		long pubKeyGenTime = 0;
		long encryptTime = 0;
		long decryptTime = 0;
		long totalTime = 0;
		
		for(int x = 0; x < data.size(); x++){
			pubKeyGenTime = pubKeyGenTime + data.get(x).getPublicKeyGenerationTime();
			encryptTime = encryptTime + data.get(x).getEncryptTime();
			decryptTime = decryptTime + data.get(x).getDecryptTime();
			totalTime = totalTime + data.get(x).getTotalTime();
		}
		
		data.add(new PublicKeyDataSet("Aggregate", data.get(0).getAlgorithm(), pubKeyGenTime, encryptTime, decryptTime, totalTime));

	}

	@Override
	public synchronized void doBenchmark(String param) {
		Stopwatch total = Stopwatch.createStarted();
		
		//KEY GENERATION
		Stopwatch pubKeyGenTimer = Stopwatch.createStarted();
		KeyGenerator gen;
		RSAPublicKey key;
		try {
			gen = KeyGenerator.getInstance(algorithm, PROVIDER);
			gen.init(pubKeyBitLen);
			key = gen.generateKey();		
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	

}
