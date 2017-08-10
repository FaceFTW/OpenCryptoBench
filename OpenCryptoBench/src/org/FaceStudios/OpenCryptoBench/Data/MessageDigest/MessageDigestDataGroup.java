package org.FaceStudios.OpenCryptoBench.Data.MessageDigest;

import java.util.ArrayList;

import org.FaceStudios.OpenCryptoBench.Data.DataGroup;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class MessageDigestDataGroup extends DataGroup<MessageDigestDataSet>{
	
	private static final BouncyCastleProvider PROVIDER = new BouncyCastleProvider();
	
	ArrayList<MessageDigestDataSet> data;
	int runs;
	String input;
	
	public MessageDigestDataGroup(int r, String i){
		data = new ArrayList<>();
		runs = r;
		input = i;
	}
	
	@Override
	public MessageDigestDataSet get(int x) {
		return data.get(x);
	}

	@Override
	public int getRuns() {
		return runs;
	}

	@Override
	public void add(MessageDigestDataSet t) {
		data.add(t);
	}

	@Override
	public void calcAggregate() {
		String run = "Aggregate";
		long aggregateHashTime = 0;
		long aggregateCheckTime = 0;
		long aggregateTotalTime = 0;
		String method = data.get(0).getHashMethod();
		int bitSize = data.get(0).getBitSize();
		
		for (int x = 0; x < runs; x++){
			aggregateHashTime = aggregateHashTime + data.get(x).getHashTime();
			aggregateCheckTime = aggregateCheckTime + data.get(x).getCheckTime();
			aggregateTotalTime = aggregateTotalTime + data.get(x).getTotalTime();
		}
		
		aggregateHashTime = aggregateHashTime/runs;
		aggregateCheckTime = aggregateCheckTime/runs;
		aggregateTotalTime = aggregateTotalTime/runs;
		
		data.add(new MessageDigestDataSet(run, aggregateHashTime, aggregateCheckTime, aggregateTotalTime, method, bitSize));
	}

	@Override
	public void doBenchmark(String param) {
		
	}

	
    
}