package symmetric;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class symmetricEncryption {
	private SecretKey secretKey;
	
	public symmetricEncryption() throws Exception {
		// générer la clé de chiffrement
		this.secretKey = generateSecretKey();
	}
	
	// methode pour générer une clé secrete AES
	private SecretKey generateSecretKey() throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128); //Taille de la clé
		
		return keyGen.generateKey();
	}
	
	//Methode pour chiffrer le texte
	public byte[] encrypt(String plainText) throws Exception{
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
		return cipher.doFinal(plainText.getBytes());
	}
	
	// methode pour déchiffrer le text
	public String decrypt(byte[] cipherText) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, this.secretKey);
		byte[] decryptedBytes = cipher.doFinal(cipherText);
		return new String(decryptedBytes);
	}
}
