package org.FaceStudios.OpenCryptoBench.Data;

import java.util.ArrayList;

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
		long aggregateHashTime;
		long aggregateCheckTime;
		long aggregateTotalTime;
		String method = data.get(0).getHashMethod();
		int bitSize = data.get(0).getBitSize();
	}

	@Override
	public void doBenchmark(String param) {
		
	}

	
    
}