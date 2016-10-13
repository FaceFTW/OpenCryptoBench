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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel configPanel = new JPanel();
		configPanel.setBounds(5, 5, 574, 152);
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
		methodPanel.setBounds(0, 41, 574, 111);
		configPanel.add(methodPanel);
		methodPanel.setLayout(new GridLayout(6, 10, 0, 0));
		
		JCheckBox aes128 = new JCheckBox("AES (128-bit)");
		methodPanel.add(aes128);
		
		JCheckBox des56 = new JCheckBox("DES (56-bit)");
		methodPanel.add(des56);
		
		JCheckBox blowfish64 = new JCheckBox("Blowfish (64-bit)");
		methodPanel.add(blowfish64);
		
		JCheckBox aes192 = new JCheckBox("AES (192-bit)");
		methodPanel.add(aes192);
		
		JCheckBox desede56 = new JCheckBox("3DES (56-bit)");
		methodPanel.add(desede56);
		
		JCheckBox blowfish32 = new JCheckBox("Blowfish (32-bit)");
		methodPanel.add(blowfish32);
		
		JCheckBox aes256 = new JCheckBox("AES (256-bit)");
		methodPanel.add(aes256);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("New check box");
		methodPanel.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_12 = new JCheckBox("New check box");
		methodPanel.add(chckbxNewCheckBox_12);
		
		JCheckBox aes512 = new JCheckBox("AES (512-bit)");
		methodPanel.add(aes512);
		
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox("New check box");
		methodPanel.add(chckbxNewCheckBox_9);
		
		JCheckBox chckbxNewCheckBox_11 = new JCheckBox("New check box");
		methodPanel.add(chckbxNewCheckBox_11);
		
		JCheckBox blowfish128 = new JCheckBox("Blowfish (128-bit)");
		methodPanel.add(blowfish128);
		
		JCheckBox chckbxNewCheckBox_14 = new JCheckBox("New check box");
		methodPanel.add(chckbxNewCheckBox_14);
		
		JCheckBox chckbxNewCheckBox_15 = new JCheckBox("New check box");
		methodPanel.add(chckbxNewCheckBox_15);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		methodPanel.add(verticalStrut);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		methodPanel.add(verticalStrut_1);
		
		JScrollPane LoggerArea = new JScrollPane();
		LoggerArea.setBounds(5, 158, 574, 97);
		contentPane.add(LoggerArea);
		
		JTextPane LogPane = new JTextPane();
		LoggerArea.setViewportView(LogPane);
	}
}
