package org.FaceStudios.OpenCryptoBench.Data;

public class PublicKeyDataSet extends DataSet {
	private String run;
	private String algorithm;
	private int pubkeyBitLen;
	private long pubKeyGenTime;
	private long encryptTime;
	private long decryptTime;
	private long totalTime;
	private PublicKeyCipher cipher;
	
	public enum PublicKeyCipher{ELGAMAL, RSA};
	
	public PublicKeyDataSet(String r, PublicKeyCipher c, long k, long e, long d, long t){
		run = r;
		totalTime = t;
		cipher = c;
		
		switch(c){
		case ELGAMAL:
			algorithm = "ElGamal";
			pubkeyBitLen = 2048;
			break;
		case RSA:
			algorithm = "RSA";
			pubkeyBitLen = 2048;
			break;
		default:
			break;
		
		}
	}
	
	public String getRun(){
		return run;
	}
	
	public PublicKeyCipher getAlgorithm(){
		return cipher;
	}
	
	public int getPublicKeyBitLength(){
		return pubkeyBitLen;
	}
	
	public long getPublicKeyGenerationTime(){
		return pubKeyGenTime;
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
		return run+","+algorithm+","+pubkeyBitLen+","+pubKeyGenTime+","+encryptTime+","+decryptTime+","+totalTime;
	}

}
