package org.FaceStudios.OpenCryptoBench.Data.MessageDigest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import org.FaceStudios.OpenCryptoBench.Data.DataGroup;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.google.common.base.Stopwatch;

public class MessageDigestDataGroup extends DataGroup<MessageDigestDataSet>{
	
	private static final BouncyCastleProvider PROVIDER = new BouncyCastleProvider();
	
	public enum MessageDigestMethod {SHA1, SHA256, SHA3, MD2, MD4, MD5, KECCAK, BLAKE2B, GOST3411, RIPEMD128, RIPEMD256, SKEIN, SM3, TIGER, WHIRLPOOL};
	
	ArrayList<MessageDigestDataSet> data;
	int runs;
	String input;
	String algorithm;
	int bitsize;
	
	public MessageDigestDataGroup(int r, String i, MessageDigestMethod m, int b){
		data = new ArrayList<>();
		runs = r;
		input = i;
		switch (m){
		case BLAKE2B:
			algorithm = "Blake2b";
			bitsize = 0;
			break;
		case GOST3411:
			algorithm = "GOST3411";
			bitsize = 0;
			break;
		case KECCAK:
			algorithm = "Keccak";
			bitsize = 0;
			break;
		case MD2:
			algorithm = "MD2";
			bitsize = 0;
			break;
		case MD4:
			algorithm = "MD4";
			bitsize = 0;
			break;
		case MD5:
			algorithm = "MD5";
			bitsize = 0;
			break;
		case RIPEMD128:
			algorithm = "RIPEMD128";
			bitsize = 128;
			break;
		case RIPEMD256:
			algorithm = "RIPEMD256";
			bitsize = 256;
			break;
		case SHA1:
			algorithm = "SHA1";
			bitsize = 128;				//TODO Please Check and ensure this is correct
			break;
		case SHA256:
			algorithm = "SHA256";
			bitsize = 256;
			break;
		case SHA3:
			algorithm = "SHA3";
			bitsize = 0;
			break;
		case SKEIN:
			algorithm = "Skein";
			bitsize = 0;
			break;
		case SM3:
			algorithm = "SM3";
			bitsize = 0;
			break;
		case TIGER:
			algorithm = "Tiger";
			bitsize = 0;
			break;
		case WHIRLPOOL:
			algorithm = "Whrilpool";
			bitsize = 0;
			break;
		default:
			break;
		
		}
	}
	
	@Override
	public MessageDigestDataSet get(int x) {
		return data.get(x);
	}

	@Override
	public int getRuns() {
		return runs;
	}

	@Override
	public void add(MessageDigestDataSet t) {
		data.add(t);
	}

	@Override
	public void calcAggregate() {
		String run = "Aggregate";
		long aggregateHashTime = 0;
		long aggregateCheckTime = 0;
		long aggregateTotalTime = 0;
		String method = data.get(0).getHashMethod();
		int bitSize = data.get(0).getBitSize();
		
		for (int x = 0; x < runs; x++){
			aggregateHashTime = aggregateHashTime + data.get(x).getHashTime();
			aggregateCheckTime = aggregateCheckTime + data.get(x).getCheckTime();
			aggregateTotalTime = aggregateTotalTime + data.get(x).getTotalTime();
		}
		
		aggregateHashTime = aggregateHashTime/runs;
		aggregateCheckTime = aggregateCheckTime/runs;
		aggregateTotalTime = aggregateTotalTime/runs;
		
		data.add(new MessageDigestDataSet(run, aggregateHashTime, aggregateCheckTime, aggregateTotalTime, method, bitSize));
	}

	@Override
	public void doBenchmark(String param) {
		for(int x = 1; x <= runs; x++){
			Stopwatch total = Stopwatch.createStarted();
			
			//HASH TIMER
			try {
				MessageDigest md = MessageDigest.getInstance(algorithm, PROVIDER);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
    
}