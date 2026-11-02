package substitution;

import org.apache.commons.math3.stat.inference.ChiSquareTest;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Caesar {
    public String cipher(String message, int offset) {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (character != ' ') {
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

    public String decipher(String message, int offset) {
        return cipher(message, 26 - (offset % 26));
    }

    public int breakCipher(String message) {
        double[] englishLettersProbabilities = {0.073, 0.009, 0.030, 0.044, 0.130, 0.028, 0.016, 0.035, 0.074, 0.002, 0.003, 0.035, 0.025, 0.078, 0.074, 0.027, 0.003, 0.077, 0.063, 0.093, 0.027, 0.013, 0.016, 0.005, 0.019, 0.001};

        double[] expectedLettersFrequencies = Arrays.stream(englishLettersProbabilities)
                .map(probability -> probability * message.length())
                .toArray();

        double[] chiSquares = new double[26];

        for (int offset = 0; offset < chiSquares.length; offset++) {
            String decipheredMessage = decipher(message, offset);

            long[] lettersFrequencies = observedLettersFrequencies(decipheredMessage);

            double chiSquare = new ChiSquareTest().chiSquare(expectedLettersFrequencies, lettersFrequencies);
            chiSquares[offset] = chiSquare;
        }

//        return chiSquares;

        int probableOffset = 0;
        for (int offset = 0; offset < chiSquares.length; offset++) {
            String.format("Chi-Square for offset %d: %.2f", offset, chiSquares[offset]);
            if (chiSquares[offset] < chiSquares[probableOffset]) {
                probableOffset = offset;
            }
        }

        return probableOffset;
    }

    long[] observedLettersFrequencies(String message) {
        return IntStream.rangeClosed('a', 'z')
                .mapToLong(letter -> countLetter((char) letter, message))
                .toArray();
    }

    long countLetter(char letter, String message) {
        return message.chars()
                .filter(character -> character == letter)
                .count();
    }

}
