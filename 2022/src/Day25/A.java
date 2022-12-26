package Day25;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A {

    static final Map<Character, Integer> valueMap = new HashMap<>();

    static long encoder(String number) {
        long answer = 0;
        long length = number.length();

        for (int i=0;i<number.length();i++) {
            answer += (valueMap.get(number.charAt(i))*Math.pow(5,length-i-1));
        }
        return answer;
    }

    static String decoder(long number) {
        if (number == 0) {
            return "";
        }
        long remainder = number%5;

        if (remainder == 0) {
            return decoder(number/5) + "0";
        } else if (remainder == 1) {
            return decoder((number-1)/5) + "1";
        } else if (remainder == 2) {
            return decoder((number-2)/5) + "2";
        } else if (remainder == 3) {
            return decoder((number+2)/5) + "=";
        } else {
            return decoder((number+1)/5) + "-";
        }
    }

    static String calculateScore(List<String> input) {
        long sumDecimal = 0;

        valueMap.put('0',0);
        valueMap.put('1',1);
        valueMap.put('2',2);
        valueMap.put('-',-1);
        valueMap.put('=',-2);

        for (String number : input) {
            sumDecimal += encoder(number);

            System.out.println(number + " " + encoder(number));
        }

        System.out.println(sumDecimal);


        return decoder(sumDecimal);
    }

    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/2022/src/Day25/input.txt";

        List<String> input = Files.readAllLines(Paths.get(filePath));

        System.out.println(calculateScore(input));

    }
}