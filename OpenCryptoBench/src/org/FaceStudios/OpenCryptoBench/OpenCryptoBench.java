package org.FaceStudios.OpenCryptoBench;

import org.FaceStudios.OpenCryptoBench.Executable.NOGUI;

public class OpenCryptoBench {

	public static void main(String[] args) {
		/*if(args.length<0){
			if(args[0].equals("nogui")){
				if(args[1].equals("")){
				*/
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
