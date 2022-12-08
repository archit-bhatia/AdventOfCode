package Day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class B {


    static class Item {
        String name;
        Item parent;
        List<Item> children;
        Integer size;

        public Item(String name, Item parent, List<Item> children, Integer size) {
            this.name = name;
            this.parent = parent;
            this.children = children;
            this.size = size;
        }
    }

    static int fillSizeMap(Item item) {
        // base case
        if (item.children.isEmpty()) {
            return item.size;
        }

        // recursive case
        int sum = 0;
        for (var children : item.children) {
            sum += fillSizeMap(children);
        }
        item.size = sum;

        return sum;
    }

    static int calculateScore(List<String> input) {

        List<Item> items = new ArrayList<>();

        items.add(new Item("/", null, new ArrayList<>(), 0));

        var currDir = items.get(0);
        var arg = "";

        for (var line : input) {
            if (line.isBlank()) break;

            if (line.charAt(0) == '$' && line.charAt(2) == 'c') {
                arg = line.substring(5);
                if (arg.equals("..")) {
                    currDir = currDir.parent;
                } else {
                    for (var item : currDir.children) {
                        if (item.name.equals(arg)) {
                            currDir = item;
                            break;
                        }
                    }
                }
            } else if (line.charAt(0) != '$') {
                var tokens = line.split(" ");
                var newItem = new Item(tokens[1], currDir, new ArrayList<>(), 0);

                if (!tokens[0].equals("dir")) {
                    newItem.size = Integer.parseInt(tokens[0]);
                }
                currDir.children.add(newItem);
                items.add(newItem);
            }
        }

        fillSizeMap(items.get(0));
        int ans = Integer.MAX_VALUE;

        int totalSpace = 70000000;
        int spaceRequiredForUpdate = 30000000;
        int currentFreeSpace = totalSpace - items.get(0).size;
        int spaceNeeded = spaceRequiredForUpdate - currentFreeSpace;

        for (var item : items) {
            // Not a dir
            if (item.children.isEmpty()) continue;


            if (item.size >= spaceNeeded) {
                ans = Integer.min(item.size, ans);
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/2022/src/Day7/input.txt";

        List<String> input = Files.readAllLines(Paths.get(filePath));

        System.out.println(calculateScore(input));

    }
}