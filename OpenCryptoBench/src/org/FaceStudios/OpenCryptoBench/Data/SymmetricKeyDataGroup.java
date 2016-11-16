package org.FaceStudios.OpenCryptoBench.Data;

import java.util.ArrayList;

public class SymmetricKeyDataGroup {
	private static ArrayList <SymmetricCipherDataSet> data;
	
	public SymmetricKeyDataGroup(){
		data = new ArrayList<SymmetricCipherDataSet>();
	}
	
	public void addDataSet(SymmetricCipherDataSet s){
		data.add(s);
	}
	
	public void calcAggregate(){
		long temp2 = 0, temp3 = 0, temp4 = 0, temp5 = 0;
		
		for(int x = 0; x<data.size();x++){
			temp2 = temp2+data.get(x).getKeyGenTime();
			temp3 = temp3+data.get(x).getEncryptTime();
			temp4 = temp4+data.get(x).getDecryptTime();
			temp5 = temp5+data.get(x).getTotalTime();
		}	
		data.add(new SymmetricCipherDataSet("Aggregate", temp2, temp3, temp4, temp5,data.get(0).getBitLength(),data.get(0).getAlgorithm()));
	}
	
	public SymmetricCipherDataSet getDataSet(int x){
		return data.get(x);
	}
	
	
}
