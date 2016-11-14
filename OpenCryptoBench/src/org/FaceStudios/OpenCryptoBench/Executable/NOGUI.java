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
			CryptoOps.invokeCrypto(Algorithm.AES, thing, x);
		}
		//DES
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.DES, thing, x);
		}
		//3DES
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.DES3, thing, x);
		}
		//Blowfish
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.BLOWFISH, thing, x);
		}
		//RC2
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.RC2, thing, x);
		}
		//RC5
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.RC5, thing, x);
		}
		//TwoFish
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.TWOFISH, thing, x);
		}
		//ThreeFish
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.THREEFISH, thing, x);
		}
		//Serpent
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.SERPENT, thing, x);
		}
		//RC4
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.RC4, thing, x);
		}
		//Salsa20
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.SALSA20, thing, x);
		}
		//Grain128
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.GRAIN128, thing, x);
		}
		//HC256
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.HC256, thing, x);
		}
		//ISSAC
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.ISSAC, thing, x);
		}
		
		//Key Exchange Setup
		BufferedWriter print2 = null;
		try {
			print2 = new BufferedWriter(new FileWriter(new File("OpenCryptoBench.csv"),true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			print2.newLine();
			print2.write("Run, KeyGeneration, KeyExchange, CommonSecret, MessageSnR, Total, Method");
			print2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int x = 0; x<10; x++){
			CryptoOps.invokeCrypto(Algorithm.DHSIM, thing, x);
		}
		
		
				
	}
}
