package org.FaceStudios.OpenCryptoBench.Data;

public class StreamCipherDataSet extends DataSet {
	private String run;
	private String algorithm;
	private int bitlen;
	private int ivlen;
	private long keyGenTime;
	private long ivGenTime;
	private long encryptTime;
	private long decryptTime;
	private long totalTime;
	
	public StreamCipherDataSet(String r, String a, int b, int i, long k, long i2, long e, long d, long t){
		run = r;
		algorithm = a;
		bitlen = b;
		ivlen = i;
		keyGenTime = k;
		ivGenTime = i2;
		encryptTime = e;
		decryptTime = d;
		totalTime = t;
	}
	
	public String getRun(){
		return run;
	}
	
	public String getAlgorithm(){
		return algorithm;
	}
	
	public int getBitLength(){
		return bitlen;
	}
	
	public int getIVLength(){
		return ivlen;
	}
	
	public long getKeyGenTime(){
		return keyGenTime;
	}
	
	public long getIVGenTime(){
		return ivGenTime;
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
	
	@Override
	public String toString() {
		return run+","+algorithm+","+bitlen+","+keyGenTime+","+ivGenTime+","+encryptTime+","+decryptTime+","+totalTime;
	}

}
