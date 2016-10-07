package org.FaceStudios.OpenCryptoBench.Crypto;

import javax.crypto.SecretKey;

public class CryptoObject {
	//This intends to be a class that creates an object with data already localized
	//The Object is intended only for use with the crypto programs
	private String input;
	private SecretKey secret; //Battleblock Theatre Reference
	//Constructor
	public CryptoObject(String i, SecretKey s){
		input = i;
		secret = s;
	}
	
	//Return Methods
	public String getInput(){
		return input;
	}
	//TODO Figure out if SecretKey class allows the actual key to be returned to another function
	public SecretKey getKey(){
		return secret;
	}
}
