package org.FaceStudios.OpenCryptoBench.GUI;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4646343597441301669L;
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
		setBounds(100, 100, 750, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel configPanel = new JPanel();
		configPanel.setBounds(5, 5, 737, 169);
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
		methodPanel.setBounds(0, 30, 738, 139);
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
		ARCFOURPanel.setLayout(new GridLayout(6, 1, 0, 0));
		
		JCheckBox arcfour40 = new JCheckBox("RC4 (40-bit)");
		ARCFOURPanel.add(arcfour40);
		
		JCheckBox arcfour64 = new JCheckBox("RC4 (64-bit)");
		ARCFOURPanel.add(arcfour64);
		
		JCheckBox arcfour128 = new JCheckBox("RC4 (128-bit)");
		ARCFOURPanel.add(arcfour128);
		
		JCheckBox arcfour256 = new JCheckBox("RC4 (256-bit)");
		ARCFOURPanel.add(arcfour256);
		
		JCheckBox arcfour512 = new JCheckBox("RC4 (512-bit)");
		ARCFOURPanel.add(arcfour512);
		
		JCheckBox arcfour1024 = new JCheckBox("RC4 (1024-bit)");
		ARCFOURPanel.add(arcfour1024);
		
		JPanel RC5Panel = new JPanel();
		RC5Panel.setBorder(new TitledBorder(null, "RC5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		methodPanel.add(RC5Panel);
		RC5Panel.setLayout(new GridLayout(6, 1, 0, 0));
		
		JCheckBox rc5_64 = new JCheckBox("RC5 (64-bit)");
		RC5Panel.add(rc5_64);
		
		JCheckBox rc5_128 = new JCheckBox("RC5 (128-bit)");
		RC5Panel.add(rc5_128);
		
		JCheckBox rc5_256 = new JCheckBox("RC5 (256-bit)");
		RC5Panel.add(rc5_256);
		
		JCheckBox rc5_512 = new JCheckBox("RC5 (512-bit)");
		RC5Panel.add(rc5_512);
		
		JCheckBox rc5_1024 = new JCheckBox("RC5 (1024-bit)");
		RC5Panel.add(rc5_1024);
		
		JCheckBox rc5_2040 = new JCheckBox("RC5 (2040-bit)");
		RC5Panel.add(rc5_2040);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new StartListener());
		btnStart.setBounds(512, 4, 89, 23);
		configPanel.add(btnStart);
		
		JScrollPane LoggerArea = new JScrollPane();
		LoggerArea.setBounds(5, 174, 737, 97);
		contentPane.add(LoggerArea);
		
		JTextPane LogPane = new JTextPane();
		LoggerArea.setViewportView(LogPane);
	}
	
	private class StartListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
		
		}

	}
}
