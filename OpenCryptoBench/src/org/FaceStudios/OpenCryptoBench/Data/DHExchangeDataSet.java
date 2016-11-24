package org.FaceStudios.OpenCryptoBench.Data;

public class DHExchangeDataSet {
	private static String run;
	private static long keygenTime;
	private static long keySnRTime;
	private static long commonsecretTime;
	private static long totalTime;
	private static long messageSnRTime;
	private static String algorithm;
	
	public DHExchangeDataSet(String d1, long d2, long d3, long d4, long d5, long d6, String d7){
		run = d1;
		keygenTime = d2;
		keySnRTime = d3;
		commonsecretTime = d4;
		messageSnRTime = d5;
		totalTime = d6;
		algorithm = d7;
	}
	
	Override toString;
	public String toString(){
		return run+","+keygenTime+","+keySnRTime+","+commonsecretTime+","+messageSnRTime+","+totalTime+","+algorithm;
	}
	
	public String getRun(){
		return run;
	}
	
	public long getKeyGenTime(){
		return keygenTime;
	}
	
	public long getkeySnRTime(){
		return keySnRTime;
	}
	
	public long getcommonsecretTime(){
		return commonsecretTime;
	}
	
	public long getTotalTime(){
		return totalTime;
	}
	
	public long getMessageSnRTime(){
		return messageSnRTime;
	}
	
	public String getAlgorithm(){
		return algorithm;
	}

}
