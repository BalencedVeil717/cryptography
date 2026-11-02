package substitution;

import java.util.HashMap;

public class Atbash {

    static HashMap<Character, Character> lookup_table = new HashMap<Character, Character>() {{
        put('A', 'Z');
        put('B', 'Y');
        put('C', 'X');
        put('D', 'W');
        put('E', 'V');
        put('F', 'U');
        put('G', 'T');
        put('H', 'S');
        put('I', 'R');
        put('J', 'Q');
        put('K', 'P');
        put('L', 'O');
        put('M', 'N');
        put('N', 'M');
        put('O', 'L');
        put('P', 'K');
        put('Q', 'J');
        put('R', 'I');
        put('S', 'H');
        put('T', 'G');
        put('U', 'F');
        put('V', 'E');
        put('W', 'D');
        put('X', 'C');
        put('Y', 'B');
        put('Z', 'A');
    }};

    public String cipher(String message) {
        StringBuilder cipher = new StringBuilder();

        for (char letter : message.toCharArray()) {
            if (letter != ' ') {
                cipher.append(Character.toLowerCase(lookup_table.get(Character.toUpperCase(letter))));
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
