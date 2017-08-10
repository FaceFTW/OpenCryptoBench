package org.FaceStudios.OpenCryptoBench.Data.MessageDigest;

import org.FaceStudios.OpenCryptoBench.Data.DataSet;

public class MessageDigestDataSet extends DataSet {
    
    String run;
    long hashTime; 
    long checkTime;
    long totalTime;
    String hashMethod;
    int bitSize;

    public MessageDigestDataSet(String r, long h, long ch, long t, String m, int b){
        run = r;
        hashTime = h;
        checkTime = ch;
        totalTime = t;
        hashMethod = m;
        bitSize = b;
    }

    public String toString(){
        return run + "," + hashTime + "," + checkTime + "," + totalTime + "," + hashMethod + "," + bitSize;
    }
    
    public String getRun(){
    	return run;
    }
    
    public long getHashTime(){
    	return hashTime;
    }
    
    public long getCheckTime(){
    	return checkTime;
    }
    
    public long getTotalTime(){
    	return totalTime;
    }
    
    public String getHashMethod(){
    	return hashMethod;
    }
    
    public int getBitSize(){
    	return bitSize;
    }
}