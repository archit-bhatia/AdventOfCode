package Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B {

    static char gameOn(char playerOneMove, char outcome) {
        if (outcome == 'D') return playerOneMove;

        if(playerOneMove == 'R' && outcome == 'W') return 'P';
        if(playerOneMove == 'P' && outcome == 'W') return 'S';
        if(playerOneMove == 'S' && outcome == 'W') return 'R';
        if(playerOneMove == 'R' && outcome == 'L') return 'S';
        if(playerOneMove == 'P' && outcome == 'L') return 'R';
        if(playerOneMove == 'S' && outcome == 'L') return 'P';

        return 'L';
    }

    static int calculateScore(List<String> input) {

        Map<Character, Character> moveMap = new HashMap<>();
        moveMap.put('A', 'R'); // Rock
        moveMap.put('X', 'L');
        moveMap.put('B', 'P'); // paper
        moveMap.put('Y', 'D');
        moveMap.put('C', 'S'); // scissor
        moveMap.put('Z', 'W');

        Map<Character, Integer> pointMap = new HashMap<>();
        pointMap.put('R', 1);
        pointMap.put('P', 2);
        pointMap.put('S', 3);
        pointMap.put('W', 6);
        pointMap.put('D', 3);
        pointMap.put('L', 0);

        int score = 0;

        for (String line : input) {
            if (line.isBlank()) break;

            char playerOneMove = moveMap.get(line.charAt(0));
            char outcome = moveMap.get(line.charAt(2));
            char playerTwoMove = gameOn(playerOneMove, outcome);

            score += pointMap.get(playerTwoMove);
            score += pointMap.get(outcome);
        }

        return score;
    }

    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/2022/src/Day2/input.txt";

        List<String> input = Files.readAllLines(Paths.get(filePath));

        System.out.println(calculateScore(input));

    }
}