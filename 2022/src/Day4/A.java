package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class A {

    static int calculateScore(List<String> input) {

        int score = 0;
        int startOne ,endOne, startTwo, endTwo = 0;

        for (String line : input) {
            if (line.isBlank()) break;

            startOne = Integer.parseInt(line.substring(0, line.indexOf('-')));

            endOne = Integer.parseInt(line.substring(line.indexOf('-') + 1, line.indexOf(',')));

            startTwo = Integer.parseInt(line.substring(line.indexOf(',') + 1, line.lastIndexOf('-')));

            endTwo = Integer.parseInt(line.substring(line.lastIndexOf('-') + 1));

            if (startTwo >= startOne && endTwo <= endOne) {
                score++;
                continue;
            }

            if (startTwo <= startOne && endTwo >= endOne) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/2022/src/Day4/input.txt";

        List<String> input = Files.readAllLines(Paths.get(filePath));

        System.out.println(calculateScore(input));

    }
}