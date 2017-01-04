package org.FaceStudios.OpenCryptoBench.Data;

public class PublicKeyDataSet extends DataSet {
	private String run;
	private String algorithm;
	private int keyPairBitLen;
	private long keyPairGenTime;
	private long pubKeyDerivTime;
	private long privKeyDerivTime;
	private long agreeTime;
	private long keyCalcTime;
	private long totalTime;
	private PublicKeyCipher cipher;
	
	public enum PublicKeyCipher{ELGAMAL, RSA};
	
	public PublicKeyDataSet(String r, PublicKeyCipher c, long kpg, long pug, long pig, long ag, long k, long t){
		run = r;
		keyPairGenTime = kpg;
		pubKeyDerivTime = pug;
		privKeyDerivTime = pig;
		agreeTime = ag;
		keyCalcTime = k;
		totalTime = t;
		cipher = c;
		
		switch(c){
		case ELGAMAL:
			algorithm = "ElGamal";
			keyPairBitLen = 2048;
			break;
		case RSA:
			algorithm = "RSA";
			keyPairBitLen = 2048;
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
	
	public int getKeyPairBitLen(){
		return keyPairBitLen;
	}
	
	public long getKeyPairGenerationTime(){
		return keyPairGenTime;
	}
	
	public long getPublicKeyDerivationeTime(){
		return pubKeyDerivTime;
	}
	
	public long getPrivateKeyDerivationTime(){
		return privKeyDerivTime;
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
		return run+","+algorithm+","+keyPairBitLen+","+keyPairGenTime+","+pubKeyDerivTime+","+privKeyDerivTime+","+agreeTime+","+keyCalcTime+","+totalTime;
	}

}
