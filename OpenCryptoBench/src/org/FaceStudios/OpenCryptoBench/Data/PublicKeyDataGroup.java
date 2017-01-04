package org.FaceStudios.OpenCryptoBench.Data;

import java.util.ArrayList;

import com.google.common.base.Stopwatch;

public class PublicKeyDataGroup extends DataGroup<PublicKeyDataSet> {
	private volatile ArrayList<PublicKeyDataSet> data;
	private int runs;
	
	PublicKeyDataGroup(int x){
		data = new ArrayList<>();
		runs = x;
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
		Stopwatch pubKeyGenTimer = Stopwatch.createStarted();
		
		
		
	}

	

}
