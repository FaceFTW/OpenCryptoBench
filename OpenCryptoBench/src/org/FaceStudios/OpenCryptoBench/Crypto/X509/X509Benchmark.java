package org.FaceStudios.OpenCryptoBench.Crypto.X509;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

import org.bouncycastle.asn1.x509.Certificate;

public class X509Benchmark {
	public static void doX509Bench(){
		 FileInputStream fis = null;
		try {
			fis = new FileInputStream("sample.x509");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 BufferedInputStream bis = new BufferedInputStream(fis);

		 CertificateFactory cf = null;
		try {
			cf = CertificateFactory.getInstance("X.509");
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 try {
			while (bis.available() > 0) {
			    java.security.cert.Certificate cert = null;
				try {
					cert = cf.generateCertificate(bis);
				} catch (CertificateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    System.out.println(cert.toString());
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
