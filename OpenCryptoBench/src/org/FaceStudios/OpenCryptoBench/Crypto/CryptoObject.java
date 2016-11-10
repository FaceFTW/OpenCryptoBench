package org.FaceStudios.OpenCryptoBench.Crypto;

public class CryptoObject{
	//This intends to be a class that creates an object with data already localized
	//The Object is intended only for use with the crypto programs
	private String input;

	//Constructor
	public CryptoObject(String i){
		input = i;
	}
	
	//Return Methods
	public String getInput(){
		return input;
	}
	
}
