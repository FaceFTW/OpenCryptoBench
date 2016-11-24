package org.FaceStudios.OpenCryptoBench.Executable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.FaceStudios.OpenCryptoBench.Crypto.CryptoObject;
import org.FaceStudios.OpenCryptoBench.Data.SymmetricKeyDataGroup;
import org.FaceStudios.OpenCryptoBench.Data.SymmetricKeyDataGroup.SymmetricKeyCipher;

public class NOGUI {
	private static SymmetricKeyDataGroup aesdata;
	private static SymmetricKeyDataGroup desdata;
	private static SymmetricKeyDataGroup desededata;
	private static SymmetricKeyDataGroup blowfishdata;
	private static SymmetricKeyDataGroup twofishdata;
	private static SymmetricKeyDataGroup threefishdata;
	private static SymmetricKeyDataGroup rc2data;
	private static SymmetricKeyDataGroup rc5data;
	private static SymmetricKeyDataGroup serpentdata;
	private static SymmetricKeyDataGroup rc4data;
	private static SymmetricKeyDataGroup salsa20data;
	private static SymmetricKeyDataGroup issacdata;
	private static SymmetricKeyDataGroup grain128data;
	private static SymmetricKeyDataGroup hc256data;
	

	public static void doNOGUI(){
		
		
		CryptoObject thing = new CryptoObject("Hello World");
		
		//Execute all different benchmarks
		//Initializer (Not Recorded)
		//AES
		aesdata.performSymmetricKeyCipherBench(SymmetricKeyCipher.AES, thing);
		//DES
		desdata.performSymmetricKeyCipherBench(SymmetricKeyCipher.DES, thing);
		//3DES
		desededata.performSymmetricKeyCipherBench(SymmetricKeyCipher.DESEDE, thing);
		//Blowfish
		blowfishdata.performSymmetricKeyCipherBench(SymmetricKeyCipher.BLOWFISH, thing);
		//RC2
		rc2data.performSymmetricKeyCipherBench(SymmetricKeyCipher.RC2, thing);
		//RC5
		rc5data.performSymmetricKeyCipherBench(SymmetricKeyCipher.RC5, thing);
		//TwoFish
		twofishdata.performSymmetricKeyCipherBench(SymmetricKeyCipher.TWOFISH, thing);
		//ThreeFish
		threefishdata.performSymmetricKeyCipherBench(SymmetricKeyCipher.THREEFISH, thing);
		//Serpent
		serpentdata.performSymmetricKeyCipherBench(SymmetricKeyCipher.SERPENT, thing);
		//RC4
		rc4data.performSymmetricKeyCipherBench(SymmetricKeyCipher.RC4, thing);
		//Salsa20
		salsa20data.performSymmetricKeyCipherBench(SymmetricKeyCipher.SALSA20, thing);
		//Grain128
		grain128data.performSymmetricKeyCipherBench(SymmetricKeyCipher.GRAIN128, thing);
		//HC256
		hc256data.performSymmetricKeyCipherBench(SymmetricKeyCipher.HC256, thing);
		//ISSAC
		
		ArrayList<SymmetricKeyDataGroup> blockcipherdata = new ArrayList<SymmetricKeyDataGroup>();
		ArrayList<SymmetricKeyDataGroup> streamcipherdata = new ArrayList<SymmetricKeyDataGroup>();

		blockcipherdata.add(aesdata);
		blockcipherdata.add(desdata);
		blockcipherdata.add(desededata);
		blockcipherdata.add(blowfishdata);
		blockcipherdata.add(twofishdata);
		blockcipherdata.add(threefishdata);
		blockcipherdata.add(rc2data);
		blockcipherdata.add(rc5data);
		blockcipherdata.add(serpentdata);
		
		streamcipherdata.add(rc4data);
		streamcipherdata.add(salsa20data);
		streamcipherdata.add(grain128data);
		streamcipherdata.add(hc256data);
		streamcipherdata.add(issacdata);
		//Start formatting the data
		
		BufferedWriter print = null;
		try {
			print = new BufferedWriter(new FileWriter(new File("OpenCryptoBench.csv"),true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			print.write("Run, KeyGeneration, Encryption, Decryption, Total, BitLength, Method");
			print.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* Procedure:
		 * 1: Print out all of the data (Inner Loop)
		 * 2: Add two newline sequences
		 * 3: Repeat until all data is printed (Outer Loop)
		 */
		
		//BLOCK CIPHER DATA
		try{
			for(int x = 0; x < blockcipherdata.size(); x++){
				//OUTER BLOCK
			
				for(int y = 0; y < 11; x++){
					//INNER BLOCK
				
					print.write(blockcipherdata.get(x).get(y).toString());				
					print.newLine();
				
					//END INNER BLOCK
				}
				print.newLine();
				print.newLine();
				
				//END OUTER BLOCK
			}
			
			//STREAM CIPHER DATA
			for(int x = 0; x < streamcipherdata.size(); x++){
				//OUTER BLOCK
			
				for(int y = 0; y < 11; x++){
					//INNER BLOCK
			
					print.write(streamcipherdata.get(x).get(y).toString());				
					print.newLine();
				
					//END INNER BLOCK
				}
				print.newLine();
				print.newLine();
				
				//END OUTER BLOCK
			}
			
			} catch (IOException | NullPointerException e) {
			e.printStackTrace();
		}
		
		
		
		/*
		 * for(int x = 0; x<10; x++){
		 
			CryptoOps.invokeCrypto(Algorithm.DHSIM, thing, x);
		}
		*/
		
				
	}
}
