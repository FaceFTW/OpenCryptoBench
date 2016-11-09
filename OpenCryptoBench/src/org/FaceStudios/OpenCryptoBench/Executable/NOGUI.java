package org.FaceStudios.OpenCryptoBench.Executable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.FaceStudios.OpenCryptoBench.Crypto.CryptoObject;
import org.FaceStudios.OpenCryptoBench.Crypto.CryptoOps;
import org.FaceStudios.OpenCryptoBench.Crypto.CryptoOps.Algorithm;

public class NOGUI {

	public static void doNOGUI(){
		
		CryptoObject thing = new CryptoObject("Hello World");
		
		BufferedWriter print = null;
		try {
			print = new BufferedWriter(new FileWriter(new File("OpenCryptoBench.csv"),true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			print.write("Run, KeyGeneration, Encryption, Decryption, Total, BitLength, Method");
			print.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Execute all different benchmarks
		//AES
		for(int x = 0; x<11; x++){
			CryptoOps.invokeCrypto(Algorithm.AES, 128, thing, x);
		}
		//DES
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.DES, 56, thing, x);
		}
		//3DES
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.DES3, 168, thing, x);
		}
		//Blowfish
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.BLOWFISH, 128, thing, x);
		}
		//RC5
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.RC5, 128, thing, x);
		}
		//TwoFish
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.TWOFISH, 128, thing, x);
		}
		//ThreeFish
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.THREEFISH, 128, thing, x);
		}
		//Serpent
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.SERPENT, 128, thing, x);
		}
		//Salsa20
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.SALSA20, 128, thing, x);
		}
		//Grain128
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.GRAIN128, 128, thing, x);
		}
		//HC256
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.HC256, 256, thing, x);
		}
		//ISSAC
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.ISSAC, 256, thing, x);
		}
				
	}
}
