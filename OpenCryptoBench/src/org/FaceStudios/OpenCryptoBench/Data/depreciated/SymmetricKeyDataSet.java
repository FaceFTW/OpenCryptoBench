package org.FaceStudios.OpenCryptoBench.Data.depreciated;

public class SymmetricKeyDataSet{
	private static String run;
	private static long keygenTime;
	private static long encryptTime;
	private static long decryptTime;
	private static long totalTime;
	private static int bitlen;
	private static String algorithm;
	
	public SymmetricKeyDataSet(String d1, long d2, long d3, long d4, long d5, int d6, String d7){
		run = d1;
		keygenTime = d2;
		encryptTime = d3;
		decryptTime = d4;
		totalTime = d5;
		bitlen = d6;
		algorithm = d7;
	}
	
	Override toString;
	public String toString(){
		return run+","+keygenTime+","+encryptTime+","+decryptTime+","+totalTime+","+bitlen+","+algorithm;
	}
	
	public String getRun(){
		return run;
	}
	
	public long getKeyGenTime(){
		return keygenTime;
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
	
	public int getBitLength(){
		return bitlen;
	}
	
	public String getAlgorithm(){
		return algorithm;
	}
}
