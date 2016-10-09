package org.FaceStudios.OpenCryptoBench.Crypto;

import java.util.logging.Logger;

public class CryptoOps {
	//This class is mainly intended for a invoker method
	//This will be used to attach a logger to a encryption invoked by the program
	private static final Logger LOGGER = Logger.getLogger(CryptoOps.class.getName());
	//Enum representing the functions
	public enum Algorithm{AES, DES, DES3, BLOWFISH, RC2, RC4, RC5, RSA, ECIES, CCM, GCM, ARCFOUR};
	
	public static void invokeCrypto(Algorithm method, int bitlen){
		LOGGER.info("Detecting Algorithm");
		switch(method){
		//This will invoke different methods depending on the parameters given.
		case AES:
			LOGGER.info("Detected Algorithm AES");
			LOGGER.config("Invoking AES Procedure");
			break;
		case DES:
			//Code
			break;
		case DES3:
			//Code
			break;
		case BLOWFISH:
			//Code
			break;
		case RC2:
			//Code
			break;
		case RC4:
			//Code
			break;
		case RC5:
			//Code
			break;
		case RSA:
			//Code
			break;
		case ECIES:
			//Code
			break;
		case CCM:
			//Code
			break;
		case GCM:
			//Code
			break;
		case ARCFOUR:
			//Code
			break;
		}
	}
	
}
