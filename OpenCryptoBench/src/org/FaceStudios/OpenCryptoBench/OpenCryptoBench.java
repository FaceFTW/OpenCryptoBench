package org.FaceStudios.OpenCryptoBench;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.FaceStudios.OpenCryptoBench.Crypto.CryptoOps;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.AESCryptoOps;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.BlowfishCryptoOps;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.DESCryptoOps;
import org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.RCAlgorithmSetCryptoOps;
import org.FaceStudios.OpenCryptoBench.Executable.NOGUI;

public class OpenCryptoBench {
	private static final LogManager LOGMAN = LogManager.getLogManager();
	public static void main(String[] args) {

		/*if(args.length<0){
			if(args[0].equals("nogui")){
				if(args[1].equals("")){
				*/	
					LOGMAN.addLogger(CryptoOps.LOGGER);
					LOGMAN.addLogger(AESCryptoOps.LOGGER);
					LOGMAN.addLogger(BlowfishCryptoOps.LOGGER);
					LOGMAN.addLogger(DESCryptoOps.LOGGER);
					LOGMAN.addLogger(RCAlgorithmSetCryptoOps.LOGGER);
					LOGMAN.addLogger(NOGUI.LOGGER);
					
					NOGUI.doNOGUI("default");
				/*}
				else{
					NOGUI.doNOGUI(args[1]);
				}
			}
			else{
				System.out.println("Unfortunately, the GUI is still under developement.");
				System.out.println("Please run this program with the \"nogui\" parameter");
			}
		}*/

	}

}
