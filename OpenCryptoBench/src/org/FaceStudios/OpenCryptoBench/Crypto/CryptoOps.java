package org.FaceStudios.OpenCryptoBench.Crypto;

import java.util.logging.Logger;

import org.FaceStudios.OpenCryptoBench.OpenCryptoBench;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.AESCryptoOps;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.BlowfishCryptoOps;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.DESCryptoOps;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.RCAlgorithmSetCryptoOps;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.Salsa20CryptoOps;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.SerpentCryptoOps;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.TwoFishCryptoOps;

public class CryptoOps {
	//This class is mainly intended for a invoker method
	//This will be used to attach a logger to a encryption invoked by the program
	@SuppressWarnings("static-access")
	public static final Logger LOGGER = OpenCryptoBench.GLOBALLOG.getLogger(CryptoOps.class.getName());
	//Enum representing the functions
	public enum Algorithm{AES, DES, DES3, BLOWFISH, RC2, RC4, RC5, TWOFISH, THREEFISH, SERPENT, SALSA20};
	
	public static void invokeCrypto(Algorithm method, int bitlen, CryptoObject thing) {
		LOGGER.setUseParentHandlers(true);
		LOGGER.info("Detecting Algorithm");
		switch(method){
		//This will invoke different methods depending on the parameters given.
		case AES:
			LOGGER.info("Detected Algorithm AES");
			LOGGER.config("Invoking AES Procedure");
			AESCryptoOps.performAES(bitlen, thing);
			break;
		case DES:
			LOGGER.info("Detected Algorithm DES");
			LOGGER.config("Invoking DES Procedure");
			DESCryptoOps.performDES(bitlen, thing);
			break;
		case DES3:
			LOGGER.info("Detected Algorithm 3DES");
			LOGGER.config("Invoking 3DES Procedure");
			DESCryptoOps.performDESede(bitlen, thing);
			break;
		case BLOWFISH:
			LOGGER.info("Detected Algorithm Blowfish");
			LOGGER.config("Invoking Blowfish Procedure");
			BlowfishCryptoOps.performBlowfish(bitlen, thing);
			break;
		case RC2:
			LOGGER.info("Detected Algorithm RC2");
			LOGGER.config("Invoking RC2 Procedure");
			RCAlgorithmSetCryptoOps.performRC2(bitlen, thing);
			break;
		case RC4:
			LOGGER.info("Detected Algorithm RC4");
			LOGGER.config("Invoking RC4 Procedure");
			RCAlgorithmSetCryptoOps.performARC4(bitlen, thing);
			break;
		case RC5:
			LOGGER.info("Detected Algorithm RC5");
			LOGGER.config("Invoking RC5 Procedure");
			RCAlgorithmSetCryptoOps.performRC5(bitlen, thing);
			break;
		case TWOFISH:
			LOGGER.info("Detected Algorithm TwoFish");
			LOGGER.config("Invoking TwoFish Procedure");
			TwoFishCryptoOps.performTwoFish(bitlen, thing);
			break;
		case THREEFISH:
			LOGGER.info("Detected Algorithm ThreeFish");
			LOGGER.config("Invoking ThreeFish Procedure");
			TwoFishCryptoOps.performThreeFish(bitlen, thing);
			break;
		case SERPENT:
			LOGGER.info("Detected Algorithm Serpent");
			LOGGER.config("Invoking Serpent Procedure");
			SerpentCryptoOps.performSerpent(bitlen, thing);;
			break;
		case SALSA20:
			LOGGER.info("Detected Algorithm Salsa20");
			LOGGER.config("Invoking Salsa20 Procedure");
			Salsa20CryptoOps.performSalsa20(bitlen, thing);;
			break;
		}
		
	}
	
}