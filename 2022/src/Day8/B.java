package Day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class B {

    static int calculateScore(List<String> input) {

        final int rows = input.size();
        final int cols = input.get(0).length();

        int[][] matrix = new int[rows][cols];
        int[][] top = new int[rows][cols];
        int[][] bottom = new int[rows][cols];
        int[][] left = new int[rows][cols];
        int[][] right = new int[rows][cols];

        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                matrix[i][j] = Character.getNumericValue(input.get(i).charAt(j));
                top[i][j] = matrix[i][j];
                bottom[i][j] = matrix[i][j];
                left[i][j] = matrix[i][j];
                right[i][j] = matrix[i][j];
            }
        }

        for (int i=1;i<rows-1;i++) {
            for (int j=1;j<cols-1;j++) {
                top[i][j] = Integer.max(top[i][j], top[i-1][j]);
                left[i][j] = Integer.max(left[i][j], left[i][j-1]);
            }
        }

        for (int i=rows-2;i>0;i--) {
            for (int j=cols-2;j>0;j--) {
                bottom[i][j] = Integer.max(bottom[i][j], bottom[i+1][j]);
                right[i][j] = Integer.max(right[i][j], right[i][j+1]);
            }
        }

        int ans = 0;

        for (int i=1;i<rows-1;i++) {
            for (int j=1;j<cols-1;j++) {
                if (matrix[i][j] > top[i-1][j] || matrix[i][j] > bottom[i+1][j] || matrix[i][j] > left[i][j-1] || matrix[i][j] > right[i][j+1]) {
                    ans++;
                }
            }
        }
        ans += ( (rows*cols) - ((rows-2)*(cols-2))) ;
        return ans;
    }

    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/2022/src/Day8/input.txt";

        List<String> input = Files.readAllLines(Paths.get(filePath));

        System.out.println(calculateScore(input));

    }
}