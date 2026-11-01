import java.util.Scanner;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        System.out.println("C A E S A R    C I P H E R\n");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your message : ");
        String input = sc.nextLine();

        CaesarCipher cipher = new CaesarCipher();

        String cipheredMessage = cipher.cipher(input, new Random().nextInt(26));
        System.out.println("Cipher Text : " + cipheredMessage);

        int offset = cipher.breakCipher(cipheredMessage);
        System.out.println("Offset : " + offset);

        String decipheredMessage = cipher.decipher(cipheredMessage, offset);
        System.out.println("Decipher Text : " + decipheredMessage);



    }
}
