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
	private static volatile SymmetricKeyDataGroup aesdata;
	private static volatile SymmetricKeyDataGroup desdata;
	private static volatile SymmetricKeyDataGroup desededata;
	private static volatile SymmetricKeyDataGroup blowfishdata;
	private static volatile SymmetricKeyDataGroup twofishdata;
	private static volatile SymmetricKeyDataGroup threefishdata;
	private static volatile SymmetricKeyDataGroup rc2data;
	private static volatile SymmetricKeyDataGroup rc5data;
	private static volatile SymmetricKeyDataGroup serpentdata;
	private static volatile SymmetricKeyDataGroup rc4data;
	private static volatile SymmetricKeyDataGroup salsa20data;
	private static volatile SymmetricKeyDataGroup issacdata;
	private static volatile SymmetricKeyDataGroup grain128data;
	private static volatile SymmetricKeyDataGroup hc256data;
	

	public static void doNOGUI(){
		
		
		CryptoObject thing = new CryptoObject("Hello World");
		
		//Execute all different benchmarks
		//Initializer (Not Recorded)
		//AES
		aesdata = new SymmetricKeyDataGroup(10);
		Thread t = new Thread(new Runnable(){
			public void run(){
				aesdata.performSymmetricKeyCipherBench(SymmetricKeyCipher.AES, thing);
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
		desdata = new SymmetricKeyDataGroup(10);
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				desdata.performSymmetricKeyCipherBench(SymmetricKeyCipher.DES, thing);
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
		desededata = new SymmetricKeyDataGroup(10);
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				desededata.performSymmetricKeyCipherBench(SymmetricKeyCipher.DESEDE, thing);
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
		blowfishdata = new SymmetricKeyDataGroup(10);
		Thread t3 = new Thread(new Runnable(){
			public void run(){
				blowfishdata.performSymmetricKeyCipherBench(SymmetricKeyCipher.BLOWFISH, thing);
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
		rc2data = new SymmetricKeyDataGroup(10);
		Thread t4 = new Thread(new Runnable(){
			public void run(){
				rc2data.performSymmetricKeyCipherBench(SymmetricKeyCipher.RC2, thing);
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
		rc5data = new SymmetricKeyDataGroup(10);
		Thread t5 = new Thread(new Runnable(){
			public void run(){
				rc5data.performSymmetricKeyCipherBench(SymmetricKeyCipher.RC5, thing);
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
		twofishdata = new SymmetricKeyDataGroup(10);
		Thread t6 = new Thread(new Runnable(){
			public void run(){
				twofishdata.performSymmetricKeyCipherBench(SymmetricKeyCipher.TWOFISH, thing);
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
		/*threefishdata = new SymmetricKeyDataGroup(10);
		Thread t7 = new Thread(new Runnable(){
			public void run(){
				threefishdata.performSymmetricKeyCipherBench(SymmetricKeyCipher.THREEFISH, thing);
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
		serpentdata = new SymmetricKeyDataGroup(10);
		Thread t8 = new Thread(new Runnable(){
			public void run(){
				serpentdata.performSymmetricKeyCipherBench(SymmetricKeyCipher.SERPENT, thing);
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
		rc4data = new SymmetricKeyDataGroup(10);
		Thread t9 = new Thread(new Runnable(){
			public void run(){
				rc4data.performSymmetricKeyCipherBench(SymmetricKeyCipher.RC4, thing);
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
		salsa20data = new SymmetricKeyDataGroup(10);
		Thread t10 = new Thread(new Runnable(){
			public void run(){
				salsa20data.performSymmetricKeyCipherBench(SymmetricKeyCipher.SALSA20, thing);
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
		grain128data = new SymmetricKeyDataGroup(10);
		Thread t11 = new Thread(new Runnable(){
			public void run(){
				grain128data.performSymmetricKeyCipherBench(SymmetricKeyCipher.GRAIN128, thing);
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
		hc256data = new SymmetricKeyDataGroup(10);
		Thread t12 = new Thread(new Runnable(){
			public void run(){
				hc256data.performSymmetricKeyCipherBench(SymmetricKeyCipher.HC256, thing);
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
		issacdata = new SymmetricKeyDataGroup(10);
		Thread t13 = new Thread(new Runnable(){
			public void run(){
				issacdata.performSymmetricKeyCipherBench(SymmetricKeyCipher.ISAAC, thing);
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
