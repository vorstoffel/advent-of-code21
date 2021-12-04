package adventofcode2021;

import adventofcode2021.models.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {
    public FileReader reader = new FileReader();
    static String filename = "aoc_2021\\src\\main\\data\\day4_testdata.txt";

    ArrayList<Integer> numbers = new ArrayList<>();
    ArrayList<BingoBoard> boards = new ArrayList<BingoBoard>();

    public void PlayBingo() {
        GetNumbers();
    }

    private int GetRandomNumber() {
        // TODO: pick a random number out of "numbers"
        return 1;
    }

    private void GetBoards() {

    }

    private void GetNumbers() {
        try {
            File myObj = new File(filename);
            Scanner sc = new Scanner(myObj);
            String line = sc.nextLine();
            String[] stringNums = line.split(",");
            for (String s : stringNums) {
                numbers.add(Integer.parseInt(s));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
