package org.FaceStudios.OpenCryptoBench.Executable;

import org.FaceStudios.OpenCryptoBench.Crypto.CryptoObject;
import org.FaceStudios.OpenCryptoBench.Crypto.CryptoOps;
import org.FaceStudios.OpenCryptoBench.Crypto.CryptoOps.Algorithm;

public class NOGUI {
	
	public static void doNOGUI(String f){
		//Create a CryptoObject
		CryptoObject thing = new CryptoObject("Dank Memes");
		String file;
		if(f.equals("default")){
			file = "OpenCryptoBench.log";
		}
		else{
			file = f;
		}
		
		//Execute all different benchmarks
		//AES
		CryptoOps.invokeCrypto(Algorithm.AES, 128, thing, file);
		CryptoOps.invokeCrypto(Algorithm.AES, 192, thing, file);
		CryptoOps.invokeCrypto(Algorithm.AES, 256, thing, file);
		//DES
		CryptoOps.invokeCrypto(Algorithm.DES, 56, thing, file);
		//3DES
		CryptoOps.invokeCrypto(Algorithm.DES3, 56, thing, file);
		CryptoOps.invokeCrypto(Algorithm.DES3, 112, thing, file);
		CryptoOps.invokeCrypto(Algorithm.DES3, 168, thing, file);
		//Blowfish
		CryptoOps.invokeCrypto(Algorithm.BLOWFISH, 32, thing, file);
		CryptoOps.invokeCrypto(Algorithm.BLOWFISH, 64, thing, file);
		CryptoOps.invokeCrypto(Algorithm.BLOWFISH, 128, thing, file);
		CryptoOps.invokeCrypto(Algorithm.BLOWFISH, 256, thing, file);
		CryptoOps.invokeCrypto(Algorithm.BLOWFISH, 384, thing, file);
		CryptoOps.invokeCrypto(Algorithm.BLOWFISH, 448, thing, file);
		//RC2
		CryptoOps.invokeCrypto(Algorithm.RC2, 8, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC2, 16, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC2, 32, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC2, 64, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC2, 128, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC2, 256, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC2, 384, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC2, 448, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC2, 512, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC2, 640, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC2, 768, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC2, 896, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC2, 1024, thing, file);
		//RC4
		CryptoOps.invokeCrypto(Algorithm.RC4, 40, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC4, 64, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC4, 128, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC4, 256, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC4, 384, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC4, 448, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC4, 512, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC4, 640, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC4, 768, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC4, 896, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC4, 1024, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC4, 1156, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC4, 1284, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC4, 1412, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC4, 1540, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC4, 1668, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC4, 1796, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC4, 1924, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC4, 2048, thing, file);
		//RC5
		CryptoOps.invokeCrypto(Algorithm.RC5, 8, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 16, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 32, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 64, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 128, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 256, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 384, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 448, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 512, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 640, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 768, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 896, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 1024, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 1156, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 1284, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 1412, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 1540, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 1668, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 1796, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 1924, thing, file);
		CryptoOps.invokeCrypto(Algorithm.RC5, 2040, thing, file);
	}
}
