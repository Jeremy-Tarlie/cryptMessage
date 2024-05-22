package symmetric;

import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        symmetricEncryption symmetricEncryption = new symmetricEncryption();
        
        // LE texte à chiffrer
        String plainText = "Coucou c'est moi";
        
        // chiffrer le texte
        byte[] encryptedText = symmetricEncryption.encrypt(plainText);
        
        // convertir en Base64 pour affichage
        String base64EncryptedText = Base64.getEncoder().encodeToString(encryptedText);
        System.out.println("Texte chiffré : " + base64EncryptedText);
        
        // décoder le texte chiffré Base64
        byte[] decodedEncryptedText = Base64.getDecoder().decode(base64EncryptedText);
        
        // déchiffrer le texte
        String decryptedText = symmetricEncryption.decrypt(decodedEncryptedText);
        System.out.println("Texte déchiffré : " + decryptedText);
    }
}
