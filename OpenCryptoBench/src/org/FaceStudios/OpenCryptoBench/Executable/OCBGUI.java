package org.FaceStudios.OpenCryptoBench.Executable;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class OCBGUI {

	private JFrame frmOpencryptobench;
	private JCheckBox chckbxGRAIN128;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OCBGUI window = new OCBGUI();
					window.frmOpencryptobench.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OCBGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOpencryptobench = new JFrame();
		frmOpencryptobench.setTitle("OpenCryptoBench");
		frmOpencryptobench.setBounds(100, 100, 600, 500);
		frmOpencryptobench.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmOpencryptobench.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);
		
		JPanel BackPanel = new JPanel();
		frmOpencryptobench.getContentPane().add(BackPanel, BorderLayout.CENTER);
		
		JPanel blockCipherChkBoxPanel = new JPanel();
		blockCipherChkBoxPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Block Ciphers", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		BackPanel.add(blockCipherChkBoxPanel);
		blockCipherChkBoxPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JCheckBox aesChkBox = new JCheckBox("AES (256-bit)");
		blockCipherChkBoxPanel.add(aesChkBox);
		
		JCheckBox desChkBox = new JCheckBox("DES (56-bit)");
		blockCipherChkBoxPanel.add(desChkBox);
		
		JCheckBox desedeChkBox = new JCheckBox("3DES (168-bit)");
		blockCipherChkBoxPanel.add(desedeChkBox);
		
		JCheckBox blowfishChkBox = new JCheckBox("Blowfish (448-bit)");
		blockCipherChkBoxPanel.add(blowfishChkBox);
		
		JCheckBox twofishChkBox = new JCheckBox("TwoFish (128-bit)");
		blockCipherChkBoxPanel.add(twofishChkBox);
		
		JCheckBox threefishChkBox = new JCheckBox("Threefish (256-bit)");
		blockCipherChkBoxPanel.add(threefishChkBox);
		
		JCheckBox serpentChkBox = new JCheckBox("Serpent (128-bit)");
		blockCipherChkBoxPanel.add(serpentChkBox);
		
		JCheckBox rc2ChkBox = new JCheckBox("RC2 (256-bit)");
		blockCipherChkBoxPanel.add(rc2ChkBox);
		
		JCheckBox rc5ChkBox = new JCheckBox("RC5 (256-bit)");
		blockCipherChkBoxPanel.add(rc5ChkBox);
		
		JPanel streamCipherChkBoxPanel = new JPanel();
		streamCipherChkBoxPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "StreamCiphers", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		BackPanel.add(streamCipherChkBoxPanel);
		streamCipherChkBoxPanel.setLayout(new GridLayout(3, 2, 0, 0));
		
		JCheckBox chckbxRc = new JCheckBox("RC4");
		streamCipherChkBoxPanel.add(chckbxRc);
		
		JCheckBox chckbxSalsa = new JCheckBox("Salsa20");
		streamCipherChkBoxPanel.add(chckbxSalsa);
		
		chckbxGRAIN128 = new JCheckBox("GRAINv128a");
		streamCipherChkBoxPanel.add(chckbxGRAIN128);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("GRAINv1");
		streamCipherChkBoxPanel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxIsaac = new JCheckBox("ISAAC");
		streamCipherChkBoxPanel.add(chckbxIsaac);
		
		JCheckBox chckbxHc = new JCheckBox("HC256");
		streamCipherChkBoxPanel.add(chckbxHc);
	}

}
