package Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class A {

    static char gameOn(char playerOneMove, char playerTwoMove) {
        if (playerOneMove == playerTwoMove) return 'D';

        if(playerOneMove == 'R' && playerTwoMove == 'P') return 'W';
        if(playerOneMove == 'P' && playerTwoMove == 'S') return 'W';
        if(playerOneMove == 'S' && playerTwoMove == 'R') return 'W';

        return 'L';
    }

    static int calculateScore(List<String> input) {

        Map<Character, Character> moveMap = new HashMap<>();
        moveMap.put('A', 'R'); // Rock
        moveMap.put('X', 'R');
        moveMap.put('B', 'P'); // paper
        moveMap.put('Y', 'P');
        moveMap.put('C', 'S'); // scissor
        moveMap.put('Z', 'S');

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
            char playerTwoMove = moveMap.get(line.charAt(2));

            score += pointMap.get(gameOn(playerOneMove, playerTwoMove));
            score += pointMap.get(playerTwoMove);
        }

        return score;
    }

    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/2022/src/Day2/input.txt";

        List<String> input = Files.readAllLines(Paths.get(filePath));

        System.out.println(calculateScore(input));

    }
}