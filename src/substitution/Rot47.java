package substitution;

public class Rot47 {
    public String cipher(String message) {
        StringBuilder cipher = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (ch >= 33 && ch <= 126) {
                ch = (char) ((ch - 33 + 47) % 94 + 33);
            }
            cipher.append(ch);
        }
        return cipher.toString();
    }

    public String decipher(String message) {
        return cipher(message);
    }
}
