public class main {
    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher();

        String cipheredMessage = cipher.cipher("he told me i could never teach a llama to drive", 10);

        System.out.println(cipheredMessage);
    }
}
