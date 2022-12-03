package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class A {

    static int calculateScore(List<String> input) {

        int score = 0;

        for (String line : input) {
            if (line.isBlank()) break;

            int midPoint = line.length()/2;

            var firstRack = line.substring(0, midPoint);
            var secondRack = line.substring(midPoint);

            char commonLetter = 'a';

            for (int i=0; i < firstRack.length(); i++) {
                if (secondRack.indexOf(firstRack.charAt(i)) != -1) {
                    commonLetter = firstRack.charAt(i);
                    break;
                }
            }
            if (Character.isUpperCase(commonLetter)) score += (commonLetter-38);
            if (Character.isLowerCase(commonLetter)) score += (commonLetter-96);
        }

        return score;
    }

    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/2022/src/Day3/input.txt";

        List<String> input = Files.readAllLines(Paths.get(filePath));

        System.out.println(calculateScore(input));

    }
}