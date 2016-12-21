package org.FaceStudios.OpenCryptoBench.Data;

public abstract class DataGroup <T extends DataSet>{
	//Abstraction of the Data Group Class, with some included methods
	
	public DataGroup(){
		
	}
	
	public abstract T get(int x);
	
	public abstract int getRuns();
	
	public abstract void add(T t);
	
	public abstract void calcAggregate();
	
	public abstract void doBenchmark(String param);
}
