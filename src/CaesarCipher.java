import javax.swing.*;

public class CaesarCipher {
    String cipher(String message, int offset) {
        StringBuilder result = new StringBuilder();
        for(char character : message.toCharArray()) {
            if(character != ' ') {
                int originalPos = character - 'a';
                int newPos = (originalPos + offset) % 26;
                char newCharacter = (char) ('a' + newPos);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}
