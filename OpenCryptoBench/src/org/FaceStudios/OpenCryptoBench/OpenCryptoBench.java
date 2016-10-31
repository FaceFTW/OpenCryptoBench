package org.FaceStudios.OpenCryptoBench;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.FaceStudios.OpenCryptoBench.Executable.NOGUI;

public class OpenCryptoBench {
	public static final Logger GLOBALLOG = Logger.getLogger("org.FaceStudios.OpenCryptoBench");
	public static void main(String[] args) {
		int x = 20;
		/*if(args.length<0){
			if(args[0].compareTo("nogui")==0){
				try{
					x = Integer.parseInt(args[1]);
				}
				catch(NumberFormatException ex){
					ex.printStackTrace();
				}*/
				try {
					GLOBALLOG.addHandler(new FileHandler("OpenCryptoBench.log"));
				} catch (SecurityException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				NOGUI.doNOGUI("default",x);
				
			/*	}
			}
			else{
				System.out.println("Unfortunately, the GUI is still under developement.");
				System.out.println("Please run this program with the \"nogui\" parameter");
			}*/

	}

}
