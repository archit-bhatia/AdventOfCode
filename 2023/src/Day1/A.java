package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class A {

    static int calculateScore(List<String> input) {

        int score = 0;



        for (String line : input) {
            // find first and last digit and then sum them
            int firstDigit = 0 , lastDigit = 0;

            for (int i=0; i<line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    firstDigit = Character.getNumericValue(line.charAt(i));
                    break;
                }
            }

            for (int i=line.length()-1; i>=0; i--) {
                if (Character.isDigit(line.charAt(i))) {
                    lastDigit = Character.getNumericValue(line.charAt(i));
                    break;
                }
            }

            score += (firstDigit*10) + lastDigit;
        }

        return score;
    }

    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/2023/src/Day1/input.txt";

        List<String> input = Files.readAllLines(Paths.get(filePath));

        System.out.println(calculateScore(input));
    }
}