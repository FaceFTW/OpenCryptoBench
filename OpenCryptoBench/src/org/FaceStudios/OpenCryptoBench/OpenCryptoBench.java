package org.FaceStudios.OpenCryptoBench;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.FaceStudios.OpenCryptoBench.Executable.NOGUI;

public class OpenCryptoBench {
	public static final Logger GLOBALLOG = Logger.getLogger("org.FaceStudios.OpenCryptoBench");
	public static void main(String[] args) {

		/*if(args.length<0){
			if(args[0].equals("nogui")){
				if(args[1].equals("")){
			*/
				try {
					GLOBALLOG.addHandler(new FileHandler("OpenCryptoBench.log"));
				} catch (SecurityException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				NOGUI.doNOGUI("default",10);
				
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
