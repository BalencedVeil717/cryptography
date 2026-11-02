import substitution.Caesar;
import substitution.Atbash;

import java.util.Scanner;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        System.out.println("A T B A S H    C I P H E R\n");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your message : ");
        String input = sc.nextLine();

        Atbash cipher = new Atbash();

        String cipheredMessage = cipher.cipher(input);
        System.out.println("Cipher Text : " + cipheredMessage);

        String decipheredMessage = cipher.decipher(cipheredMessage);
        System.out.println("Decipher Text : " + decipheredMessage);


    }
}
