package org.FaceStudios.OpenCryptoBench.Crypto;

public class CryptoObject{
	//This intends to be a class that creates an object with data already localized
	//The Object is intended only for use with the crypto programs
	private String input;
	//timeEncrypt and timeDecrypt are in ms
	private long timeEncrypt;
	private long timeDecrypt;
	//Constructor
	public CryptoObject(String i){
		input = i;
		timeEncrypt = 0;
		timeDecrypt = 0;
	}
	
	//Return Methods
	public String getInput(){
		return input;
	}
	
	public synchronized void writeEncryptTime(long in){
		timeEncrypt = in;
	}
	
	public long getEncryptTime(){
		return timeEncrypt;
	}
	
	public synchronized void writeDecryptTime(long in){
		timeDecrypt = in;
	}
	
	public long getDecryptTime(){
		return timeDecrypt;
	}
}
