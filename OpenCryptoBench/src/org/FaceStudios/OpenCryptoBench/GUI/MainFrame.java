package org.FaceStudios.OpenCryptoBench.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField inField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("OpenCryptoBench");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel configPanel = new JPanel();
		configPanel.setBounds(5, 5, 689, 169);
		contentPane.add(configPanel);
		configPanel.setLayout(null);
		
		JLabel inLabel = new JLabel("Test String");
		inLabel.setBounds(10, 8, 59, 14);
		configPanel.add(inLabel);
		
		inField = new JTextField();
		inField.setBounds(65, 5, 86, 20);
		configPanel.add(inField);
		inField.setColumns(10);
		
		JPanel methodPanel = new JPanel();
		methodPanel.setBorder(new TitledBorder(null, "Methods", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		methodPanel.setBounds(0, 30, 689, 139);
		configPanel.add(methodPanel);
		methodPanel.setLayout(new GridLayout(1, 10, 0, 0));
		
		JPanel aesPanel = new JPanel();
		aesPanel.setBorder(new TitledBorder(null, "AES", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		methodPanel.add(aesPanel);
		aesPanel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JCheckBox aes128 = new JCheckBox("AES (128-bit)");
		aesPanel.add(aes128);
		
		JCheckBox aes192 = new JCheckBox("AES (192-bit)");
		aesPanel.add(aes192);
		
		JCheckBox aes256 = new JCheckBox("AES (256-bit)");
		aesPanel.add(aes256);
		
		JPanel desPanel = new JPanel();
		desPanel.setBorder(new TitledBorder(null, "DES", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		methodPanel.add(desPanel);
		desPanel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JCheckBox des56 = new JCheckBox("DES (56-bit)");
		desPanel.add(des56);
		
		JCheckBox desede56 = new JCheckBox("3DES (56-bit)");
		desPanel.add(desede56);
		
		JCheckBox desede112 = new JCheckBox("3DES (112-bit)");
		desPanel.add(desede112);
		
		JCheckBox desede168 = new JCheckBox("3DES (168-bit)");
		desPanel.add(desede168);
		
		JPanel blowfishPanel = new JPanel();
		blowfishPanel.setBorder(new TitledBorder(null, "Blowfish", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		methodPanel.add(blowfishPanel);
		blowfishPanel.setLayout(new GridLayout(6, 1, 0, 0));
		
		JCheckBox blowfish32 = new JCheckBox("Blowfish (32-bit)");
		blowfishPanel.add(blowfish32);
		
		JCheckBox blowfish64 = new JCheckBox("Blowfish (64-bit)");
		blowfishPanel.add(blowfish64);
		
		JCheckBox blowfish128 = new JCheckBox("Blowfish (128-bit)");
		blowfishPanel.add(blowfish128);
		
		JCheckBox blowfish256 = new JCheckBox("Blowfish (256-bit)");
		blowfishPanel.add(blowfish256);
		
		JCheckBox blowfish384 = new JCheckBox("Blowfish (384-bit)");
		blowfishPanel.add(blowfish384);
		
		JCheckBox blowfish448 = new JCheckBox("Blowfish (448-bit)");
		blowfishPanel.add(blowfish448);
		
		JPanel ARC2Panel = new JPanel();
		ARC2Panel.setBorder(new TitledBorder(null, "RC2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		methodPanel.add(ARC2Panel);
		ARC2Panel.setLayout(new GridLayout(6, 1, 0, 0));
		
		JCheckBox rc2_8 = new JCheckBox("RC2 (8-bit)");
		ARC2Panel.add(rc2_8);
		
		JCheckBox rc2_16 = new JCheckBox("RC2 (16-bit)");
		ARC2Panel.add(rc2_16);
		
		JCheckBox rc2_32 = new JCheckBox("RC2 (32-bit)");
		ARC2Panel.add(rc2_32);
		
		JCheckBox rc2_64 = new JCheckBox("RC2 (64-bit)");
		ARC2Panel.add(rc2_64);
		
		JCheckBox rc2_128 = new JCheckBox("RC2 (128-bit)");
		ARC2Panel.add(rc2_128);
		
		JCheckBox rc2_256 = new JCheckBox("RC2 (256-bit)");
		ARC2Panel.add(rc2_256);
		
		JPanel ARCFOURPanel = new JPanel();
		ARCFOURPanel.setBorder(new TitledBorder(null, "RC4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		methodPanel.add(ARCFOURPanel);
		ARCFOURPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane LoggerArea = new JScrollPane();
		LoggerArea.setBounds(15, 174, 689, 97);
		contentPane.add(LoggerArea);
		
		JTextPane LogPane = new JTextPane();
		LoggerArea.setViewportView(LogPane);
	}
}
