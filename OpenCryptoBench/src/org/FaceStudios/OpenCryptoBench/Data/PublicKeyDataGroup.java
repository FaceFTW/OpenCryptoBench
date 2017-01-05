package org.FaceStudios.OpenCryptoBench.Data;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.crypto.KeyAgreement;

import org.FaceStudios.OpenCryptoBench.Data.PublicKeyDataSet.PublicKeyCipher;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.google.common.base.Stopwatch;

public class PublicKeyDataGroup extends DataGroup<PublicKeyDataSet> {
	private volatile ArrayList<PublicKeyDataSet> data;
	private int runs;
	private int keyPairBitLen;
	private String algorithm;
	
	private static final BouncyCastleProvider PROVIDER = new BouncyCastleProvider();
	
	PublicKeyDataGroup(int x, PublicKeyCipher cipher){
		data = new ArrayList<>();
		runs = x;
		switch(cipher){
		case ELGAMAL:
			algorithm = "ElGamal";
			keyPairBitLen = 2048;
			break;
		case RSA:
			algorithm = "RSA";
			keyPairBitLen = 2048;
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
		long keyPairGenTime = 0;
		long pubKeyGenTime = 0;
		long privKeyGenTime = 0;
		long agreeTime = 0;
		long keyCalcTime = 0;
		long totalTime = 0;
		
		for(int x = 0; x < data.size(); x++){
			pubKeyGenTime = pubKeyGenTime + data.get(x).getPublicKeyDerivationTime();
			privKeyGenTime = privKeyGenTime + data.get(x).getPrivateKeyDerivationTime();
			agreeTime = agreeTime + data.get(x).getAgreementTime();
			keyCalcTime = keyCalcTime + data.get(x).getKeyCalcTime();
			totalTime = totalTime + data.get(x).getTotalTime();
		}
		
		data.add(new PublicKeyDataSet("Aggregate", data.get(0).getAlgorithm(),keyPairGenTime, pubKeyGenTime, privKeyGenTime, agreeTime, keyCalcTime, totalTime));

	}

	@Override
	public synchronized void doBenchmark(String param) {
		Stopwatch total = Stopwatch.createStarted();
		
		//KEY PAIR GENERATION
		Stopwatch keyPairGenTimer = Stopwatch.createStarted();
		KeyPair kp = null;
		KeyPairGenerator gen;
		try {
			gen = KeyPairGenerator.getInstance(algorithm, PROVIDER);
			gen.initialize(keyPairBitLen);
			kp = gen.generateKeyPair();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		keyPairGenTimer.stop();
		long keyPairGenTime = keyPairGenTimer.elapsed(TimeUnit.NANOSECONDS);
		
		
		//PUBLIC KEY DERIVATION TIME
		Stopwatch pubKeyDerivTimer = Stopwatch.createStarted();
		PublicKey pubkey = kp.getPublic();
		pubKeyDerivTimer.stop();
		long pubKeyDerivTime = pubKeyDerivTimer.elapsed(TimeUnit.NANOSECONDS);
		
		
		//PRIVATE KEY DERIVATION TIME
		Stopwatch privKeyDerivTimer = Stopwatch.createStarted();
		PrivateKey privkey = kp.getPrivate();
		privKeyDerivTimer.stop();
		long privKeyDerivTime = privKeyDerivTimer.elapsed(TimeUnit.NANOSECONDS);
		
		
		//ENCRYPTION TIME
		Stopwatch agreeTimer = Stopwatch.createStarted();
		KeyAgreement keyagree;
		try {
			keyagree = KeyAgreement.getInstance(algorithm, PROVIDER);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}

	

}
