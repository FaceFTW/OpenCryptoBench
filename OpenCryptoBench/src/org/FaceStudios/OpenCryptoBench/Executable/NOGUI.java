package org.FaceStudios.OpenCryptoBench.Executable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.FaceStudios.OpenCryptoBench.Data.BlockCipherDataGroup;
import org.FaceStudios.OpenCryptoBench.Data.StreamCipherDataGroup;
import org.FaceStudios.OpenCryptoBench.Data.BlockCipherDataGroup.BlockCipher;
import org.FaceStudios.OpenCryptoBench.Data.StreamCipherDataGroup.StreamCipher;


public class NOGUI {
	private static volatile BlockCipherDataGroup aesdata;
	private static volatile BlockCipherDataGroup desdata;
	private static volatile BlockCipherDataGroup desededata;
	private static volatile BlockCipherDataGroup blowfishdata;
	private static volatile BlockCipherDataGroup twofishdata;
	private static volatile BlockCipherDataGroup threefishdata;
	private static volatile BlockCipherDataGroup rc2data;
	private static volatile BlockCipherDataGroup rc5data;
	private static volatile BlockCipherDataGroup serpentdata;
	private static volatile StreamCipherDataGroup rc4data;
	private static volatile StreamCipherDataGroup salsa20data;
	private static volatile StreamCipherDataGroup issacdata;
	private static volatile StreamCipherDataGroup grain128data;
	private static volatile StreamCipherDataGroup hc256data;
	

	public static void doNOGUI(){
		
		//Execute all different benchmarks
		//Initializer (Not Recorded)
		//AES
		aesdata = new BlockCipherDataGroup(10, BlockCipher.AES);
		Thread t = new Thread(new Runnable(){
			public void run(){
				aesdata.doBenchmark("Hello World");;
				aesdata.calcAggregate();
			}
		});
		t.start();
		try {
			t.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Runtime.getRuntime().gc();	
		
		
		//DES
		desdata = new BlockCipherDataGroup(10, BlockCipher.DES);
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				desdata.doBenchmark("Hello World");
				desdata.calcAggregate();
			}
		});
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Runtime.getRuntime().gc();	
		
		
		//3DES
		desededata = new BlockCipherDataGroup(10, BlockCipher.DESEDE);
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				desededata.doBenchmark("Hello World");
				desededata.calcAggregate();
			}
		});
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Runtime.getRuntime().gc();
		
		
		//Blowfish
		blowfishdata = new BlockCipherDataGroup(10, BlockCipher.BLOWFISH);
		Thread t3 = new Thread(new Runnable(){
			public void run(){
				blowfishdata.doBenchmark("Hello World");
				blowfishdata.calcAggregate();
			}
		});
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Runtime.getRuntime().gc();	
		
		
		//RC2
		rc2data = new BlockCipherDataGroup(10, BlockCipher.RC2);
		Thread t4 = new Thread(new Runnable(){
			public void run(){
				rc2data.doBenchmark("Hello World");;
				rc2data.calcAggregate();
			}
		});
		t4.start();
		try {
			t4.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Runtime.getRuntime().gc();	
		
		
		//RC5
		rc5data = new BlockCipherDataGroup(10, BlockCipher.RC5);
		Thread t5 = new Thread(new Runnable(){
			public void run(){
				rc5data.doBenchmark("Hello World");
				rc5data.calcAggregate();
			}
		});
		t5.start();
		try {
			t5.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Runtime.getRuntime().gc();	
		
		
		//TwoFish
		twofishdata = new BlockCipherDataGroup(10, BlockCipher.TWOFISH);
		Thread t6 = new Thread(new Runnable(){
			public void run(){
				twofishdata.doBenchmark("Hello World");;
				twofishdata.calcAggregate();
			}
		});
		t6.start();
		try {
			t6.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Runtime.getRuntime().gc();	
		
		
		//ThreeFish
		//Does not seem to be Working right now...
		/*threefishdata = new BlockCipherDataGroup(10);
		Thread t7 = new Thread(new Runnable(){
			public void run(){
				threefishdata.performSymmetricKeyCipherBench(BlockCipher.THREEFISH, thing);
				threefishdata.calcAggregate();
			}
		});
		t7.start();
		try {
			t7.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Runtime.getRuntime().gc();	
		 */
		
		//Serpent
		serpentdata = new BlockCipherDataGroup(10, BlockCipher.SERPENT);
		Thread t8 = new Thread(new Runnable(){
			public void run(){
				serpentdata.doBenchmark("Hello World");;
				serpentdata.calcAggregate();
			}
		});
		t8.start();
		try {
			t8.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Runtime.getRuntime().gc();	
		
		
		//RC4
		rc4data = new StreamCipherDataGroup(10, StreamCipher.RC4);
		Thread t9 = new Thread(new Runnable(){
			public void run(){
				rc4data.doBenchmark("Hello World");
				rc4data.calcAggregate();
			}
		});
		t9.start();
		try {
			t9.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Runtime.getRuntime().gc();	
		
		
		//Salsa20
		salsa20data = new StreamCipherDataGroup(10, StreamCipher.SALSA20);
		Thread t10 = new Thread(new Runnable(){
			public void run(){
				salsa20data.doBenchmark("Hello World");
				salsa20data.calcAggregate();
			}
		});
		t10.start();
		try {
			t10.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Runtime.getRuntime().gc();	
		
		
		//Grain128
		grain128data = new StreamCipherDataGroup(10, StreamCipher.GRAIN128);
		Thread t11 = new Thread(new Runnable(){
			public void run(){
				grain128data.doBenchmark("Hello World");
				grain128data.calcAggregate();
			}
		});
		t11.start();
		try {
			t11.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Runtime.getRuntime().gc();
		
		
		//HC256
		hc256data = new StreamCipherDataGroup(10, StreamCipher.HC256);
		Thread t12 = new Thread(new Runnable(){
			public void run(){
				hc256data.doBenchmark("Hello World");
				hc256data.calcAggregate();
			}
		});
		t12.start();
		try {
			t12.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Runtime.getRuntime().gc();	
		
		//ISSAC
		issacdata = new StreamCipherDataGroup(10, StreamCipher.ISAAC);
		Thread t13 = new Thread(new Runnable(){
			public void run(){
				issacdata.doBenchmark("Hello World");
				issacdata.calcAggregate();
			}
		});
		t13.start();
		try {
			t13.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Runtime.getRuntime().gc();	
		
		ArrayList<BlockCipherDataGroup> blockcipherdata = new ArrayList<BlockCipherDataGroup>();
		ArrayList<StreamCipherDataGroup> streamcipherdata = new ArrayList<StreamCipherDataGroup>();

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
