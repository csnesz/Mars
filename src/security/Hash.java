package security;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

import control.MainControl;

public  class Hash {
private MainControl main;
	public  String getHash(byte[] inputBytes, String algorithm) {
		String hashValue = "";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.update(inputBytes);
			byte[] digestedBytes = messageDigest.digest();
			hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
		} catch (Exception e) {

		}

		return hashValue;

	}

	public void SetControl(MainControl main) {
		this.main=main;
		
	}
	public   void main(String[] args) {
		String password = "k";
		System.out.println(getHash(password.getBytes(), "SHA-256"));
	}
}
