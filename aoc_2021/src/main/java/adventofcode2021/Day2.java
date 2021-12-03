package adventofcode2021;

import java.util.ArrayList;

public class Day2 {

    public FileReader reader = new FileReader();
    static String filename = "aoc_2021\\src\\main\\day2.txt";
    ArrayList<String> commands = reader.getValuesAsStrings(filename);

    /**
     * down X increases your aim by X units.
     * up X decreases your aim by X units.
     * forward X does two things:
     * - It increases your horizontal position by X units.
     * - It increases your depth by your aim multiplied by X.
     */
    public void Position() {
        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        for (int i = 0; i < commands.size(); i++) {

            if (commands.get(i).charAt(0) == 'f') {
                int number = Integer.parseInt(String.valueOf(commands.get(i).charAt(8)));

                int tmp = horizontal + number;
                int aimcrease = aim * number;
                System.out.println("- - - " + commands.get(i) + " - - -");
                System.out.println("horizontal: " + horizontal + " + " + number + " = " + tmp);
                System.out.println("depth: " + depth + " + " + aim + " * " + number + " = " + aimcrease);

                horizontal = horizontal + number;
                depth = depth + aimcrease;
            } else if (commands.get(i).charAt(0) == 'd') {
                int number = Integer.parseInt(String.valueOf(commands.get(i).charAt(5)));

                int newAim = aim + number;
                System.out.println("- - - " + commands.get(i) + " - - -");
                System.out.println("aim: " + aim + " + " + number + " = " + newAim);

                aim = newAim;
            } else if (commands.get(i).charAt(0) == 'u') {
                int number = Integer.parseInt(String.valueOf(commands.get(i).charAt(3)));

                int newAim = aim - number;
                System.out.println("- - - " + commands.get(i) + " - - -");
                System.out.println("aim: " + aim + " - " + number + " = " + newAim);

                aim = newAim;
            }

        }
        System.out.println("------------------------");
        System.out.println("Horizontal: " + horizontal);
        System.out.println("Depth: " + depth);
        System.out.println("------------------------");
        System.out.println("Multiply " + horizontal + " with " + depth + " = " + (horizontal * depth));
        System.out.println("------------------------");

        // 1880593125 right solution
    }
}