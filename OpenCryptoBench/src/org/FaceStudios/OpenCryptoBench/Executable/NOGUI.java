package org.FaceStudios.OpenCryptoBench.Executable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.FaceStudios.OpenCryptoBench.Crypto.CryptoObject;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.BlockCipherBenchmark;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.BlockCipherBenchmark.BlockCipher;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.StreamCipherBenchmark;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.StreamCipherBenchmark.StreamCipher;
import org.FaceStudios.OpenCryptoBench.Data.SymmetricKeyDataGroup;

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
		aesdata = BlockCipherBenchmark.performBlockCipherBench(BlockCipher.AES, thing);
		//DES
		desdata = BlockCipherBenchmark.performBlockCipherBench(BlockCipher.DES, thing);
		//3DES
		desededata = BlockCipherBenchmark.performBlockCipherBench(BlockCipher.DESEDE, thing);
		//Blowfish
		blowfishdata = BlockCipherBenchmark.performBlockCipherBench(BlockCipher.BLOWFISH, thing);
		//RC2
		rc2data = BlockCipherBenchmark.performBlockCipherBench(BlockCipher.RC2, thing);
		//RC5
		rc5data = BlockCipherBenchmark.performBlockCipherBench(BlockCipher.RC5, thing);
		//TwoFish
		twofishdata = BlockCipherBenchmark.performBlockCipherBench(BlockCipher.TWOFISH, thing);
		//ThreeFish
		threefishdata = BlockCipherBenchmark.performBlockCipherBench(BlockCipher.THREEFISH, thing);
		//Serpent
		serpentdata = BlockCipherBenchmark.performBlockCipherBench(BlockCipher.SERPENT, thing);
		//RC4
		rc4data = StreamCipherBenchmark.performStreamCipherBenchmark(StreamCipher.RC4, thing);
		//Salsa20
		salsa20data = StreamCipherBenchmark.performStreamCipherBenchmark(StreamCipher.SALSA20, thing);
		//Grain128
		grain128data = StreamCipherBenchmark.performStreamCipherBenchmark(StreamCipher.GRAIN128, thing);
		//HC256
		hc256data = StreamCipherBenchmark.performStreamCipherBenchmark(StreamCipher.HC256, thing);
		//ISSAC
		issacdata = StreamCipherBenchmark.performStreamCipherBenchmark(StreamCipher.ISSAC, thing);
		
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
