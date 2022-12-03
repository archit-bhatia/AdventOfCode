package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class B {

    static String findCommonLetters(String one, String two) {
        String commonLetters = "";

        for (int i=0; i < one.length(); i++) {
            if (two.indexOf(one.charAt(i)) != -1) {
                commonLetters += one.charAt(i);
            }
        }
        return commonLetters;
    }

    static int calculateScore(List<String> input) {

        int score = 0;
        String firstLine = "", secondLine = "", thirdLine = "";
        int k=0;

        for (String line : input) {
            if (line.isBlank()) break;

            if (k==0) {
                firstLine = line;
                k++;
                continue;
            }
            if (k==1) {
                secondLine = line;
                k++;
                continue;
            }
            if (k==2) {
                thirdLine = line;
                k=0;
            }

            String firstTwoCommon = findCommonLetters(firstLine, secondLine);
            String lastTwoCommon = findCommonLetters(secondLine, thirdLine);
            String commonLetterString = findCommonLetters(firstTwoCommon, lastTwoCommon);
            char commonLetter = commonLetterString.charAt(0);

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