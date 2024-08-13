import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class aes {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a 16-character key for AES encryption: ");
        String keyStr = scanner.nextLine();
        if (keyStr.length() != 16) {
            System.out.println("Key must be 16 characters long.");
          
        }

        System.out.print("Enter message to encrypt: ");
        String message = scanner.nextLine();

        SecretKeySpec secretKey = new SecretKeySpec(keyStr.getBytes("UTF-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        String encryptedMessage = Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
        System.out.println("Encrypted message: " + encryptedMessage);

        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        String decryptedMessage = new String(cipher.doFinal(Base64.getDecoder().decode(encryptedMessage)),"UTF-8");
        System.out.println("Decrypted message: " + decryptedMessage);

        scanner.close();
    }
}
