package org.FaceStudios.OpenCryptoBench.Data;

public class PublicKeyDataSet extends DataSet {
	private String run;
	private String algorithm;
	private int pubBitLen;
	private int privBitLen;
	private long pubKeyGenTime;
	private long privKeyGenTime;
	private long agreeTime;
	private long keyCalcTime;
	private long totalTime;
	
	public enum PublicKeyCipher{ELGAMAL, RSA};
	
	public PublicKeyDataSet(String r, PublicKeyCipher cipher, long pug, long pig, long ag, long k, long t){
		run = r;
		pubKeyGenTime = pug;
		privKeyGenTime = pig;
		agreeTime = ag;
		keyCalcTime = k;
		totalTime = t;
		
		switch(cipher){
		case ELGAMAL:
			algorithm = "ElGamal";
			pubBitLen = 0;
			privBitLen = 0;
			break;
		case RSA:
			algorithm = "RSA";
			pubBitLen = 0;
			privBitLen = 0;
			break;
		default:
			break;
		
		}
	}
	
	public String getRun(){
		return run;
	}
	
	public String getAlgorithm(){
		return algorithm;
	}
	
	public int getPublicKeyBitLength(){
		return pubBitLen;
	}
	
	public int getPrivateKeyBitLength(){
		return privBitLen;
	}
	
	public long getPublicKeyGenTime(){
		return pubKeyGenTime;
	}
	
	public long getPrivateKeyGenerationTime(){
		return privKeyGenTime;
	}
	
	public long getAgreementTime(){
		return agreeTime;
	}
	
	public long getKeyCalcTime(){
		return keyCalcTime;
	}
	
	public long getTotalTime(){
		return totalTime;
	}
	
	@Override
	public String toString() {
		return run+","+algorithm+","+pubBitLen+","+privBitLen+","+pubKeyGenTime+","+privKeyGenTime+","+agreeTime+","+keyCalcTime+","+totalTime;
	}

}
