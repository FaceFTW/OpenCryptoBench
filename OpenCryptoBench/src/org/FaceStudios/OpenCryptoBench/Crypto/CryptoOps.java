package org.FaceStudios.OpenCryptoBench.Crypto;

import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.BlockCipherBenchmark;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.BlockCipherBenchmark.BlockCipher;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.DiffieHellman.DHKeyExchangeCryptoOps;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.StreamCipherBenchmark;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.StreamCipherBenchmark.StreamCipher;

public class CryptoOps {
	//This class is mainly intended for a invoker method
	//This will be used to attach a logger to a encryption invoked by the program
	//Enum representing the functions
	public enum Algorithm{AES, DES, DES3, BLOWFISH, RC2, RC4, RC5, TWOFISH, THREEFISH, SERPENT, SALSA20, GRAIN128, ISSAC, HC256, DHSIM};
	
	public static void invokeCrypto(Algorithm method, CryptoObject thing, int n) {
		switch(method){
		//This will invoke different methods depending on the parameters given.
		case AES:
			BlockCipherBenchmark.performBlockCipherBench(BlockCipher.AES,  thing, n);
			break;
		case DES:
			BlockCipherBenchmark.performBlockCipherBench(BlockCipher.DES,  thing, n);
			break;
		case DES3:
			BlockCipherBenchmark.performBlockCipherBench(BlockCipher.DESEDE,  thing, n);
			break;
		case BLOWFISH:
			BlockCipherBenchmark.performBlockCipherBench(BlockCipher.BLOWFISH,  thing, n);
			break;
		case RC2:
			BlockCipherBenchmark.performBlockCipherBench(BlockCipher.RC2,  thing, n);
			break;
		case RC4:
			StreamCipherBenchmark.performStreamCipherBenchmark(StreamCipher.RC4,  thing, n);
			break;
		case RC5:
			BlockCipherBenchmark.performBlockCipherBench(BlockCipher.RC5,  thing, n);
			break;
		case TWOFISH:
			BlockCipherBenchmark.performBlockCipherBench(BlockCipher.TWOFISH,  thing, n);
			break;
		case THREEFISH:
			BlockCipherBenchmark.performBlockCipherBench(BlockCipher.THREEFISH,  thing, n);
			break;
		case SERPENT:
			BlockCipherBenchmark.performBlockCipherBench(BlockCipher.SERPENT,  thing, n);
			break;
		case SALSA20:
			StreamCipherBenchmark.performStreamCipherBenchmark(StreamCipher.SALSA20,  thing, n);
			break;
		case GRAIN128:
			StreamCipherBenchmark.performStreamCipherBenchmark(StreamCipher.GRAIN128,  thing, n);
			break;
		case ISSAC:
			StreamCipherBenchmark.performStreamCipherBenchmark(StreamCipher.ISSAC,  thing, n);
			break;
		case HC256:
			StreamCipherBenchmark.performStreamCipherBenchmark(StreamCipher.HC256,  thing, n);
			break;
		case DHSIM:
			DHKeyExchangeCryptoOps.performDHBench(n);
			break;
		}
		
	}
	
}