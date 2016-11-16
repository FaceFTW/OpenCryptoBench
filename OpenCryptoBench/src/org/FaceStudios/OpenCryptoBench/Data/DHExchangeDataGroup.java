package org.FaceStudios.OpenCryptoBench.Data;

import java.util.ArrayList;

public class DHExchangeDataGroup {
private static ArrayList <DHExchangeDataSet> data;
	
	public DHExchangeDataGroup(){
		data = new ArrayList<DHExchangeDataSet>();
	}
	
	public void addDataSet(DHExchangeDataSet s){
		data.add(s);
	}
	
	public DHExchangeDataSet calcAggregate(){
		long temp2 = 0, temp3 = 0, temp4 = 0, temp5 = 0, temp6 = 0;
		
		for(int x = 0; x<data.size();x++){
			temp2 = temp2+data.get(x).getKeyGenTime();
			temp3 = temp3+data.get(x).getkeySnRTime();
			temp4 = temp4+data.get(x).getcommonsecretTime();
			temp5 = temp5+data.get(x).getMessageSnRTime();
			temp6 = temp6+data.get(x).getTotalTime();
		}
		
		temp2 = temp2/data.size();
		temp3 = temp3/data.size();
		temp4 = temp4/data.size();
		temp5 = temp5/data.size();
		temp6 = temp6/data.size();
		
		return new DHExchangeDataSet("Aggregate", temp2, temp3, temp4, temp5, temp6,data.get(0).getAlgorithm());
	}
	
	public DHExchangeDataSet getDataSet(int x){
		return data.get(x);
	}
}
