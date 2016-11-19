package org.FaceStudios.OpenCryptoBench.Data;

import java.util.AbstractList;

public class SymmetricKeyDataGroup extends AbstractList<IDataSet>{
	private static SymmetricKeyDataSet[] data;
	
	public SymmetricKeyDataGroup(int x){
		data = new SymmetricKeyDataSet[x];
	}
	
	public void addDataSet(SymmetricKeyDataSet s, int x){
		data[x] = s;
	}
	
	public SymmetricKeyDataSet calcAggregate(){
		long temp2 = 0, temp3 = 0, temp4 = 0, temp5 = 0;
		
		for(int x = 0; x<data.length;x++){
			temp2 = temp2+data[x].getKeyGenTime();
			temp3 = temp3+data[x].getEncryptTime();
			temp4 = temp4+data[x].getDecryptTime();
			temp5 = temp5+data[x].getTotalTime();
		}
		
		temp2 = temp2/data.length;
		temp3 = temp3/data.length;
		temp4 = temp4/data.length;
		temp5 = temp5/data.length;
		
		return new SymmetricKeyDataSet("Aggregate", temp2, temp3, temp4, temp5,data[0].getBitLength(),data[0].getAlgorithm());
	}

	@Override
	public IDataSet get(int arg0) {
		return data[arg0];
	}

	@Override
	public int size() {
		return data.length;
	}
	
	
}
