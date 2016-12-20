package org.FaceStudios.OpenCryptoBench.Data;

public class BlockCipherDataSet extends DataSet {
	private String run;
	private String algorithm;
	private long keyGenTime;
	private long encryptTime;
	private long decryptTime;
	private long totalTime;
	
	
	public BlockCipherDataSet(String r, String a, long k, long e, long d, long t){
		run = r;
		algorithm = a;
		keyGenTime = k;
		encryptTime = e;
		decryptTime = d;
		totalTime = t;
	}
	
	@Override
	public String toString() {
		
		return run+","+algorithm+","+keyGenTime+","+encryptTime+","+decryptTime+","+totalTime;
	}
	
	public String getRun(){
		return run;
	}
	
	public String getAlgorithm(){
		return algorithm;
	}
	
	public long getKeyGenTime(){
		return keyGenTime;
	}
	
	public long getEncryptTime(){
		return encryptTime;
	}
	
	public long getDecryptTime(){
		return decryptTime;
	}
	
	public long getTotalTime(){
		return totalTime;
	}

}
