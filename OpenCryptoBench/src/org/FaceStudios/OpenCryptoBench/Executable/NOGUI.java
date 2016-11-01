package org.FaceStudios.OpenCryptoBench.Executable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import org.FaceStudios.OpenCryptoBench.OpenCryptoBench;
import org.FaceStudios.OpenCryptoBench.Crypto.CryptoObject;
import org.FaceStudios.OpenCryptoBench.Crypto.CryptoOps;
import org.FaceStudios.OpenCryptoBench.Crypto.CryptoOps.Algorithm;

public class NOGUI {
	@SuppressWarnings("static-access")
	public static final Logger LOGGER = OpenCryptoBench.GLOBALLOG.getLogger(NOGUI.class.getName());
	public static void doNOGUI(String f, int pass){
		LOGGER.setUseParentHandlers(true); 
		LOGGER.info("####################################################################");
		LOGGER.info("PERFORMING NOGUI OPERATION");
		LOGGER.info("####################################################################");
		//Create a CryptoObject
		LOGGER.info("####################################################################");
		LOGGER.info("SYSTEM INFORMATION");
		LOGGER.info("####################################################################");
		LOGGER.info("OS Name: "+System.getProperty("os.name"));
		LOGGER.info("OS Architecture: "+ System.getProperty("os.arch"));
		LOGGER.info("OS Version: "+System.getProperty("os.version"));
		LOGGER.info("Java Version: "+System.getProperty("java.version"));
		LOGGER.info("Java Vendor: "+System.getProperty("java.vendor"));
		LOGGER.info("Username: "+System.getProperty("user.name"));
		LOGGER.info("Working Directory: "+System.getProperty("user.dir"));
		LOGGER.info("####################################################################");
		LOGGER.info("STARTING EXECUTION");
		LOGGER.info("####################################################################");
		CryptoObject thing = new CryptoObject("Hello World");
		/*String file;
		if(f.equals("default")){
			file = "OpenCryptoBench.log";
		}
		else{
			file = f;
		}
		try {
			LOGGER.addHandler(new FileHandler(file));
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}*/
		
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
		//CryptoOps.invokeCrypto(Algorithm.AES, 192, thing);
		//CryptoOps.invokeCrypto(Algorithm.AES, 256, thing);
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
		//CryptoOps.invokeCrypto(Algorithm.BLOWFISH, 256, thing);
		//CryptoOps.invokeCrypto(Algorithm.BLOWFISH, 384, thing);
		//CryptoOps.invokeCrypto(Algorithm.BLOWFISH, 448, thing);
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
		//CryptoOps.invokeCrypto(Algorithm.RC2, 256, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC2, 384, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC2, 448, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC2, 512, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC2, 640, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC2, 768, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC2, 896, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC2, 1024, thing);
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
		//CryptoOps.invokeCrypto(Algorithm.RC4, 256, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC4, 384, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC4, 448, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC4, 512, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC4, 640, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC4, 768, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC4, 896, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC4, 1024, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC4, 1156, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC4, 1284, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC4, 1412, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC4, 1540, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC4, 1668, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC4, 1796, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC4, 1924, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC4, 2048, thing);
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
		//CryptoOps.invokeCrypto(Algorithm.RC5, 256, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC5, 384, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC5, 448, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC5, 512, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC5, 640, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC5, 768, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC5, 896, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC5, 1024, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC5, 1156, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC5, 1284, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC5, 1412, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC5, 1540, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC5, 1668, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC5, 1796, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC5, 1924, thing);
		//CryptoOps.invokeCrypto(Algorithm.RC5, 2040, thing);
		//TwoFish
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.TWOFISH, 128, thing, x);
		}
		//CryptoOps.invokeCrypto(Algorithm.TWOFISH, 192, thing);
		//CryptoOps.invokeCrypto(Algorithm.TWOFISH, 256, thing);
		//ThreeFish
		//CryptoOps.invokeCrypto(Algorithm.THREEFISH, 256, thing);
		//CryptoOps.invokeCrypto(Algorithm.THREEFISH, 512, thing);
		//CryptoOps.invokeCrypto(Algorithm.THREEFISH, 1024, thing);
		//Serpent
		for(int x = 0; x<10; x++){
		CryptoOps.invokeCrypto(Algorithm.SERPENT, 128, thing, x);
		}
		//CryptoOps.invokeCrypto(Algorithm.SERPENT, 192, thing);
		//CryptoOps.invokeCrypto(Algorithm.SERPENT, 256, thing);
		//Salsa20
		//CryptoOps.invokeCrypto(Algorithm.SALSA20, 256, thing);
		LOGGER.info("####################################################################");
		LOGGER.info("FINISHED NOGUI OPERATION");
		LOGGER.info("####################################################################");
	}
}
