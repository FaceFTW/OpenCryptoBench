package org.FaceStudios.OpenCryptoBench.Crypto.Algorithms;

import java.util.logging.Logger;

import org.FaceStudios.OpenCryptoBench.Crypto.CryptoObject;
import org.FaceStudios.OpenCryptoBench.Crypto.CryptoOps;

public class AESCryptoOps {
	//This is the redirect implementation for AES
	//This will allow data to be logged and processed
	//All methods should be static
	
	//Logger Implementaion
	private static final Logger LOGGER = Logger.getLogger(DESCryptoOps.class.getName());
	
	//Mode Constans enum
	

	
	public static void performAES(CryptoOps.Mode mode, int bitlen, CryptoObject thing){
		switch(mode){
		case ENCRYPTION:          //Encryption
			//Enter AES Code Here
			break;
		case DECRYPTION:
			//Decryption Code Here
		}
	}
	
}
