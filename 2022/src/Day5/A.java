package Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class A {

    static String calculateScore(List<String> input) {

        Map<Integer, List<Character>> stacks = new HashMap<>();

        // Build stack
        for (String line : input) {
            if (line.isEmpty()) break;

            for (int i=0; i<line.length(); i++) {
                if (Character.isAlphabetic(line.charAt(i))) {
                    int stackNo = (i+4)/4;
                    stacks.computeIfAbsent(stackNo, k -> new ArrayList<>());
                    stacks.get(stackNo).add(line.charAt(i));
                }
            }
        }

        for (var stack : stacks.values()) {
            Collections.reverse(stack);
        }

        // Do moves
        for (String line : input) {
            if (line.isBlank() || line.charAt(0) != 'm') continue;

            var tokens = line.split(" ");
            var sourceStack = stacks.get(Integer.parseInt(tokens[3]));
            var destStack = stacks.get(Integer.parseInt(tokens[5]));
            var count = Integer.parseInt(tokens[1]);

            while (count > 0) {
                if (sourceStack.isEmpty()) break;

                destStack.add(sourceStack.remove(sourceStack.size()-1));
                count--;
            }
        }

        String answer = "";

        for (int i=1; i<=stacks.keySet().size(); i++) {
            var stack = stacks.get(i);
            answer += stack.get(stack.size()-1);
        }



        return answer;
    }

    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/2022/src/Day5/input.txt";

        List<String> input = Files.readAllLines(Paths.get(filePath));

        System.out.println(calculateScore(input));

    }
}