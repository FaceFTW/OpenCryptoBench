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
		aesdata = new SymmetricKeyDataGroup(11);
		desdata = new SymmetricKeyDataGroup(11);
		desededata = new SymmetricKeyDataGroup(11);
		blowfishdata = new SymmetricKeyDataGroup(11);
		twofishdata = new SymmetricKeyDataGroup(11);
		threefishdata = new SymmetricKeyDataGroup(11);
		rc2data = new SymmetricKeyDataGroup(11);
		rc5data = new SymmetricKeyDataGroup(11);
		serpentdata = new SymmetricKeyDataGroup(11);
		rc4data = new SymmetricKeyDataGroup(11);
		salsa20data = new SymmetricKeyDataGroup(11);
		issacdata = new SymmetricKeyDataGroup(11);
		grain128data = new SymmetricKeyDataGroup(11);
		hc256data = new SymmetricKeyDataGroup(11);
		
		CryptoObject thing = new CryptoObject("Hello World");
		
		//Execute all different benchmarks
		//Initializer (Not Recorded)
		BlockCipherBenchmark.performBlockCipherBench(BlockCipher.AES, thing, 0);
		//AES
		for(int x = 0; x<10; x++){
			aesdata.add(BlockCipherBenchmark.performBlockCipherBench(BlockCipher.AES, thing, x));
		}
		//DES
		for(int x = 0; x<10; x++){
			desdata.add(BlockCipherBenchmark.performBlockCipherBench(BlockCipher.DES, thing, x));
		}
		//3DES
		for(int x = 0; x<10; x++){
			desededata.add(BlockCipherBenchmark.performBlockCipherBench(BlockCipher.DESEDE, thing, x));
		}
		//Blowfish
		for(int x = 0; x<10; x++){
			blowfishdata.add(BlockCipherBenchmark.performBlockCipherBench(BlockCipher.BLOWFISH, thing, x));
		}
		//RC2
		for(int x = 0; x<10; x++){
			rc2data.add(BlockCipherBenchmark.performBlockCipherBench(BlockCipher.RC2, thing, x));
		}
		//RC5
		for(int x = 0; x<10; x++){
			rc5data.add(BlockCipherBenchmark.performBlockCipherBench(BlockCipher.RC5, thing, x));
		}
		//TwoFish
		for(int x = 0; x<10; x++){
			twofishdata.add(BlockCipherBenchmark.performBlockCipherBench(BlockCipher.TWOFISH, thing, x));
		}
		//ThreeFish
		for(int x = 0; x<10; x++){
			threefishdata.add(BlockCipherBenchmark.performBlockCipherBench(BlockCipher.THREEFISH, thing, x));
		}
		//Serpent
		for(int x = 0; x<10; x++){
			serpentdata.add(BlockCipherBenchmark.performBlockCipherBench(BlockCipher.SERPENT, thing, x));
		}
		//RC4
		for(int x = 0; x<10; x++){
			rc4data.add(StreamCipherBenchmark.performStreamCipherBenchmark(StreamCipher.RC4, thing, x));
		}
		//Salsa20
		for(int x = 0; x<10; x++){
			salsa20data.add(StreamCipherBenchmark.performStreamCipherBenchmark(StreamCipher.SALSA20, thing, x));
		}
		//Grain128
		for(int x = 0; x<10; x++){
			grain128data.add(StreamCipherBenchmark.performStreamCipherBenchmark(StreamCipher.GRAIN128, thing, x));
		}
		//HC256
		for(int x = 0; x<10; x++){
			hc256data.add(StreamCipherBenchmark.performStreamCipherBenchmark(StreamCipher.HC256, thing, x));
		}
		//ISSAC
		for(int x = 0; x<10; x++){
			issacdata.add(StreamCipherBenchmark.performStreamCipherBenchmark(StreamCipher.ISSAC, thing, x));
		}
		
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
		
		//Calcualte Aggregates for the data
		for(int a = 0; a<blockcipherdata.size();a++){
			blockcipherdata.get(a).add(blockcipherdata.get(a).calcAggregate());
		}
		
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
