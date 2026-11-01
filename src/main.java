public class main {
    public static void main(String[] args) {
        System.out.println("C A E S A R    C I P H E R\n");
        CaesarCipher cipher = new CaesarCipher();

        String cipheredMessage = cipher.cipher("he told me i could never teach a llama to drive", 10);
        System.out.println("Cipher Text : " + cipheredMessage);

        int offset = cipher.breakCipher(cipheredMessage);
        System.out.println("Offset : " + offset);

        String decipheredMessage = cipher.decipher(cipheredMessage, offset);
        System.out.println("Decipher Text : " + decipheredMessage);



    }
}
