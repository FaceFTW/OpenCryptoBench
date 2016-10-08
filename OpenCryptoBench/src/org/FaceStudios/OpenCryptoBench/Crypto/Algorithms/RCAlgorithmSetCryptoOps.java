package org.FaceStudios.OpenCryptoBench.Crypto.Algorithms;

import java.util.logging.Logger;

import org.FaceStudios.OpenCryptoBench.Crypto.CryptoObject;
import org.FaceStudios.OpenCryptoBench.Crypto.CryptoOps;

public class RCAlgorithmSetCryptoOps {
	//This is the redirect implementation for the RC Algorithms (RC2, RC4, RC5, and ARCFOUR)
			//This will allow data to be logged and processed
			//All methods should be static
			
			//Logger Implementaion
			private static final Logger LOGGER = Logger.getLogger(DESCryptoOps.class.getName());
					
			public static void performRC2(CryptoOps.Mode mode, CryptoObject thing){
				switch(mode){
				case ENCRYPTION:          //Encryption
					//Enter Code Here
					break;
				case DECRYPTION:
					//Decryption Code Here
				}
			}
			
			public static void performRC4(CryptoOps.Mode mode, CryptoObject thing){
				switch(mode){
				case ENCRYPTION:          //Encryption
					//Enter Code Here
					break;
				case DECRYPTION:
					//Decryption Code Here
				}
			}
			
			public static void performRC5(CryptoOps.Mode mode, CryptoObject thing){
				switch(mode){
				case ENCRYPTION:          //Encryption
					//Enter Code Here
					break;
				case DECRYPTION:
					//Decryption Code Here
				}
			}
			
			public static void performARCFOUR(CryptoOps.Mode mode, CryptoObject thing){
				switch(mode){
				case ENCRYPTION:          //Encryption
					//Enter Code Here
					break;
				case DECRYPTION:
					//Decryption Code Here
				}
			}
}
