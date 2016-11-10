package org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.DiffieHellman;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

public class DHKeyExchangeCryptoOps {
	private static Stopwatch s;
	private static Stopwatch s1;
	//Key Generation
	private static long keygenTime;
	//Key Send and Recieve
	private static long keySnRTime;
	//Common Secret Generation
	private static long commonsecretTime;
	//Message Send and Recieve
	private static long messageSnRTime;
	//Total Time
	private static long totalTime;
	
   public static void performDHBench(int n){
	
    final EndUser alice = new EndUser();
    final EndUser bob   = new EndUser();
    
    s = Stopwatch.createStarted();
    s1 = Stopwatch.createStarted();
    
    alice.generateKeys();
    bob.generateKeys();
    
    s1.stop();
    keygenTime = s1.elapsed(TimeUnit.NANOSECONDS);
    s1.reset();
    s1.start();
    
    alice.receivePublicKeyFrom(bob);
    bob.receivePublicKeyFrom(alice);

    s1.stop();
    keySnRTime = s1.elapsed(TimeUnit.NANOSECONDS);
    s1.reset();
    s1.start();
    
    alice.generateCommonSecretKey();
    bob.generateCommonSecretKey();
    
    s1.stop();
    commonsecretTime = s1.elapsed(TimeUnit.NANOSECONDS);
    s1.reset();
    s1.start();
    
    alice.encryptAndSendMessage("Bob! Guess Who I am.", bob);   
    bob.whisperTheSecretMessage();
    
    s1.stop();
    messageSnRTime = s1.elapsed(TimeUnit.NANOSECONDS);
    s1.reset();
    s1.start();
    
    s.stop();
    totalTime = s.elapsed(TimeUnit.NANOSECONDS);
    
    BufferedWriter print = null;
	try {
		print = new BufferedWriter(new FileWriter(new File("OpenCryptoBench.csv"),true));
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		print.newLine();
		print.write((n+1)+","+keygenTime+","+keySnRTime+","+commonsecretTime+","+messageSnRTime+","+totalTime+",Diffie-Hellman");
		print.close();
	} catch (IOException e) {
		e.printStackTrace();
	}


   }
}