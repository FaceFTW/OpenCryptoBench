package org.FaceStudios.OpenCryptoBench.Crypto.Algorithms;

import java.util.logging.Logger;

import org.FaceStudios.OpenCryptoBench.Crypto.CryptoObject;
import org.FaceStudios.OpenCryptoBench.Crypto.CryptoOps;

public class DESCryptoOps {
	//This is the redirect implementation for DES
	//This will allow data to be logged and processed
	//All methods should be static
	
	//Logger Implementaion
	private static final Logger LOGGER = Logger.getLogger(DESCryptoOps.class.getName());
	
	//Mode Constans enum
	

	
	public static void performDES(CryptoOps.Mode mode, CryptoObject thing){
		switch(mode){
		case ENCRYPTION:          //Encryption
			//Enter DES Code Here
			break;
		case DECRYPTION:
			//Decryption Code Here
		}
	}
	
	public static void perform3DES(){
		//Enter 3DES Code Here
	}

}