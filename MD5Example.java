import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Example {
    public static void main(String[] args) {
        String text = "Hello, world!";

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            md.update(text.getBytes());

            byte[] hashBytes = md.digest();

            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte b : hashBytes) {

                hexStringBuilder.append(String.format("%02x", b));
            }

            System.out.println("MD5 Hash: " + hexStringBuilder.toString());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("MD5 algorithm not found.");
            e.printStackTrace();
        }
    }
}
