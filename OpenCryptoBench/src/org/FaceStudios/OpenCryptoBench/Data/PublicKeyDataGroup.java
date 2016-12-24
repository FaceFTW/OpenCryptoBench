package org.FaceStudios.OpenCryptoBench.Data;

import java.util.ArrayList;

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
	

	}

	@Override
	public synchronized void doBenchmark(String param) {
		
	}

	

}
