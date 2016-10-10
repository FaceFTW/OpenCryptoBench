package org.FaceStudios.OpenCryptoBench;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

@SuppressWarnings("unused")

public class MainGUI {
	//This class will serve as a mainstream GUI for the program
	//All the swing components...
	private JPanel mainFrame;
	
	private JScrollBar outPanel;
	private JTextArea termOut;
	
	public MainGUI(){
		mainFrame = new JPanel();
		outPanel = new JScrollBar();
		termOut = new JTextArea();
	}
}
