package adventofcode2021;

import java.util.ArrayList;

public class Day1 {

    public FileReader reader = new FileReader();
    static String sonarDepthsFileName = "aoc_2021\\src\\main\\day1.txt";
    ArrayList<Integer> measurements = reader.getValuesAsIntegers(sonarDepthsFileName);

    // Part 1
    public void Increases() {
        int counter = 0;

        for (int i = 0; i < measurements.size(); i++) {
            if (i + 1 < measurements.size() && measurements.get(i) < measurements.get(i + 1)) {
                counter++;
                System.out.println(measurements.get(i) + " increased");
            } else {
                System.out.println(measurements.get(i));
            }
        }
        System.out.println("* * * Increased " + counter + " times. * * *");
    }

    // Part 2
    public void SlidingWindowIncreases() {
        int counter = 0;

        for (int i = 0; i < measurements.size(); i++) {
            if (i + 3 < measurements.size()) {
                int firstWindow = measurements.get(i) + measurements.get(i + 1) + measurements.get(i + 2);
                int secondWindow = measurements.get(i + 1) + measurements.get(i + 2) + measurements.get(i + 3);

                if (firstWindow < secondWindow) {
                    counter++;
                }
                if (i == 0) {
                    System.out.println(measurements.get(i) + "+" + measurements.get(i + 1) + "+"
                            + measurements.get(i + 2) + " = " + firstWindow);

                    System.out.println(measurements.get(i + 1) + "+" + measurements.get(i + 2) + "+"
                            + measurements.get(i + 3) + " = " + secondWindow);

                    System.out.println(firstWindow + " < " + secondWindow);
                }
            }
        }
        System.out.println("* * * Sliding Window Increased " + counter + " times. * * *");
    }
}