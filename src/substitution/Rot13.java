package substitution;

import java.util.HashMap;
import java.util.Map;

public class Rot13 {
    static Map<Character, Integer> dict1 = new HashMap<>();
    static Map<Integer, Character> dict2 = new HashMap<>();

    public Rot13() {
        for (int i = 1; i < 27; i++) {
            dict1.put((char) (96 + i), i);
        }

        dict2.put(0, 'z');

        for (int i = 1; i < 26; i++) {
            dict2.put(i, (char) (96 + i));
        }
    }

    public String cipher(String message) {
        StringBuilder cipher = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != ' ') {
                int num = (dict1.get(message.charAt(i)) + 13) % 26;
                cipher.append(dict2.get(num));
            } else {
                cipher.append(' ');
            }
        }
        return cipher.toString();
    }

    public String decipher(String message) {
        return cipher(message);
    }
}
