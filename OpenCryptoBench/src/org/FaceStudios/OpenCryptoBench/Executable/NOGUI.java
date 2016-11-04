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
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.AES, 128, thing, x);
		}
		//DES
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.DES, 56, thing, x);
		}
		//3DES
		for(int x = 0; x<10; x++){	
		CryptoOps.invokeCrypto(Algorithm.DES3, 112, thing, x);
	}
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.DES3, 168, thing, x);
		}
		//Blowfish
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.BLOWFISH, 32, thing, x);
		}
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.BLOWFISH, 64, thing, x);
		}
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.BLOWFISH, 128, thing, x);
		}
		//RC2
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.RC2, 40, thing, x);
		}
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.RC2, 64, thing, x);
		}
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.RC2, 128, thing, x);
		}
		//RC4
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.RC4, 40, thing, x);
		}
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.RC4, 64, thing, x);
		}
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.RC4, 128, thing,x);
		}
		//RC5
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.RC5, 8, thing,x);
		}
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.RC5, 16, thing, x);
		}
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.RC5, 32, thing,x);
		}
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.RC5, 64, thing, x);
		}
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.RC5, 128, thing, x);
		}
		//TwoFish
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.TWOFISH, 128, thing, x);
		}
		//ThreeFish
		//Serpent
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.SERPENT, 128, thing, x);
		}
		//Salsa20;
	}
}
