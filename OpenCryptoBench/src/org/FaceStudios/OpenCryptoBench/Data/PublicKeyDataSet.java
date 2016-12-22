package org.FaceStudios.OpenCryptoBench.Data;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

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
	private static final BouncyCastleProvider PROVIDER = new BouncyCastleProvider();
	
	public PublicKeyDataSet(String r, String a, int pu){
		
	}
	
	@Override
	public String toString() {
		return null;
	}

}
