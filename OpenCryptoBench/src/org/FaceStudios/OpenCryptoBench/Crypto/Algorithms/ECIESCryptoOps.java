package org.FaceStudios.OpenCryptoBench.Crypto.Algorithms;

import java.util.logging.Logger;

import org.FaceStudios.OpenCryptoBench.Crypto.CryptoObject;
import org.FaceStudios.OpenCryptoBench.Crypto.CryptoOps;

public class ECIESCryptoOps {
	//This is the redirect implementation for the ECIES Algorithm
	//This will allow data to be logged and processed
	//All methods should be static
	
	//Logger Implementaion
	private static final Logger LOGGER = Logger.getLogger(DESCryptoOps.class.getName());
			
	public static void performECIES(CryptoOps.Mode mode, CryptoObject thing){
		switch(mode){
		case ENCRYPTION:          //Encryption
			//Enter Code Here
			break;
		case DECRYPTION:
			//Decryption Code Here
		}
	}
}