package org.FaceStudios.OpenCryptoBench.Data;

import java.util.ArrayList;

public abstract class ISymmetricKeyDataGroup {
	private ArrayList<SymmetricKeyDataSet> data;
	private int runs;
	
	public ISymmetricKeyDataGroup(int x) {
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
	
	public int size() {
		return data.size();
	}
	
	public abstract void doBenchmark();
	
}
