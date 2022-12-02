package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Main {

    static List<Integer> getCaloriesList(List<String> input) {
        List<Integer> caloriesPerElf = new ArrayList<>();
        int currentCalorieCount = 0;

        for (String item : input) {
            if (Objects.equals(item, "")) {
                caloriesPerElf.add(currentCalorieCount);
                currentCalorieCount = 0;
                continue;
            }
            currentCalorieCount += Integer.parseInt(item);
        }

        return caloriesPerElf;
    }

    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/2022/src/Day1/input.txt";

        List<String> input = Files.readAllLines(Paths.get(filePath));
        List<Integer> caloriesList = getCaloriesList(input);
        caloriesList.sort(Collections.reverseOrder());

        System.out.println(caloriesList.get(0));
        System.out.println(caloriesList.get(0) + caloriesList.get(1) + caloriesList.get(2));

    }
}