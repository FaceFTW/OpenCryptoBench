package org.FaceStudios.OpenCryptoBench.Crypto;

import java.util.logging.Logger;

public class CryptoOps {
	//This class is mainly intended for a invoker method
	//This will be used to attach a logger to a encryption invoked by the program
	private static final Logger LOGGER = Logger.getLogger(CryptoOps.class.getName());
	//A Universal Enum representing the mode
	public enum Mode{ENCRYPTION, DECRYPTION};
	//Enum representing the functions
	public enum Algorithm{AES, DES, DES3, BLOWFISH};
	
	public static void invokeCrypto(Algorithm method, int bitlen, Mode mode){
		switch(method){
		//This will invoke different methods depending on the parameters given.
		case AES:
			//Code
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
		}
	}
	
}
