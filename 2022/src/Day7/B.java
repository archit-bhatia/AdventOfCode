package Day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B {

    static int calculateScore(List<String> input) {

        String message = input.get(0);

        for (int i=13; i<message.length(); i++) {
            Set<Character> letters = new HashSet<>();
            for (int j=i;j>(i-14);j--) {
                letters.add(message.charAt(j));
            }

            if (letters.size() == 14) {
                return i+1;
            }
        }



        return message.length()-1;
    }

    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/2022/src/Day6/input.txt";

        List<String> input = Files.readAllLines(Paths.get(filePath));

        System.out.println(calculateScore(input));

    }
}