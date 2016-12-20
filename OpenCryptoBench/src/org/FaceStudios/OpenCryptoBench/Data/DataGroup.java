package org.FaceStudios.OpenCryptoBench.Data;

import java.util.ArrayList;

public abstract class DataGroup <T extends DataSet>{
	//Abstraction of the Data Group Class, with some included methods
	
	private ArrayList<T> data;
	private int runs;
	
	public DataGroup(int x){
		data = new ArrayList<>();
		runs = x;
	}
	
	public T get(int x){
		return data.get(x);
	}
	
	public int getRuns(){
		return runs;
	}
	
	public void add(T t){
		data.add(t);
	}
	
	public abstract void calcAggregate();
	
	public abstract void doBenchmark();
}
