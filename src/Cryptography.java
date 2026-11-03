import substitution.Caesar;
import substitution.Atbash;
import substitution.Rot13;
import substitution.Rot47;

import java.util.Scanner;
import java.util.Random;

public class Cryptography {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your secret message : ");
        String message = sc.nextLine();

        String cipheredMessage;
        String decipheredMessage;
        while (true) {
            System.out.println("\nC R Y P T O G R A P H Y\n");

            System.out.println("1. Substitution");

            System.out.println("0. Exit");

            int choice2 = sc.nextInt();

            if (choice2 == 0) {
                break;
            }

            switch (choice2) {
                case 1:
                    System.out.println("\nS U B S T I T U T I O N    C I P H E R");

                    System.out.println("1. Caesar Cipher");
                    System.out.println("2. Atbash Cipher");
                    System.out.println("3. ROT13 Cipher");
                    System.out.println("4. ROT47 Cipher");

                    System.out.println("0. Exit");

                    int choice3 = sc.nextInt();

                    if (choice3 == 0) {
                        break;
                    }

                    switch (choice3) {
                        case 1:
                            System.out.println("\nC A E S A R    C I P H E R\n");

                            Caesar caesar = new Caesar();
                            Random random = new Random();

                            cipheredMessage = caesar.cipher(message, random.nextInt(25));
                            System.out.println("Cipher Text : " + cipheredMessage);

                            int offset = caesar.breakCipher(cipheredMessage);
                            System.out.println("Offset : " + offset);

                            decipheredMessage = caesar.decipher(cipheredMessage, offset);
                            System.out.println("Decipher Text : " + decipheredMessage);

                            break;

                        case 2:
                            System.out.println("\nA T B A S H    C I P H E R\n");

                            Atbash atbash = new Atbash();

                            cipheredMessage = atbash.cipher(message);
                            System.out.println("Cipher Text : " + cipheredMessage);

                            decipheredMessage = atbash.decipher(cipheredMessage);
                            System.out.println("Decipher Text : " + decipheredMessage);

                            break;

                        case 3:
                            System.out.println("\nR O T 1 3    C I P H E R");

                            Rot13 rot13 = new Rot13();

                            cipheredMessage = rot13.cipher(message);
                            System.out.println("Cipher Text : " + cipheredMessage);

                            decipheredMessage = rot13.decipher(cipheredMessage);
                            System.out.println("Decipher Text : " + decipheredMessage);

                            break;

                        case 4:
                            System.out.println("\nR O T 4 7    C I P H E R");

                            Rot47 rot47 = new Rot47();

                            cipheredMessage = rot47.cipher(message);
                            System.out.println("Cipher Text : " + cipheredMessage);

                            decipheredMessage = rot47.decipher(cipheredMessage);
                            System.out.println("Decipher Text : " + decipheredMessage);

                        default:
                            System.out.println("Invalid, try again.");
                    }

                    break;
                default:
                    System.out.println("Invalid, try again.");
            }
        }
    }
}
