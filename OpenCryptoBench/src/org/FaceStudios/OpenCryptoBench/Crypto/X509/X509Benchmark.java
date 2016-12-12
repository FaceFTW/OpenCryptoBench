package org.FaceStudios.OpenCryptoBench.Crypto.X509;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.security.cert.CertificateFactory;

import org.bouncycastle.asn1.x509.Certificate;

public class X509Benchmark {
	public static void doX509Bench(){
		 FileInputStream fis = new FileInputStream("sample.x509");
		 BufferedInputStream bis = new BufferedInputStream(fis);

		 CertificateFactory cf = CertificateFactory.getInstance("X.509");

		 while (bis.available() > 0) {
		    java.security.cert.Certificate cert = cf.generateCertificate(bis);
		    System.out.println(cert.toString());
		 }
	}

}
