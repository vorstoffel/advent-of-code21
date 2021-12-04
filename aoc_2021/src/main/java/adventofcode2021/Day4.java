package adventofcode2021;

import adventofcode2021.models.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {
    public FileReader reader = new FileReader();
    static String filename = "aoc_2021\\src\\main\\data\\day4_testdata.txt";

    ArrayList<Integer> numbers;
    ArrayList<BingoField[][]> boards;

    public void PlayBingo() {
        numbers = GetNumbers();
        boards = GetBoards();
        PrintBoards(boards);
    }

    private int GetRandomNumber() {
        // TODO: pick a random number out of "numbers"
        return 1;
    }

    private void PrintBoards(ArrayList<BingoField[][]> boards) {
        for (BingoField[][] bingoFields : boards) {
            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < 5; i++) {
                    System.out.print(" " + bingoFields[j][i].getNumber());
                }
                System.out.println();
            }
            System.out.println("end of board");
        }
    }

    private ArrayList<BingoField[][]> GetBoards() {
        try {
            File myObj = new File(filename);
            Scanner sc = new Scanner(myObj);

            boards = new ArrayList<BingoField[][]>();
            BingoField[][] tmpBoard = new BingoField[5][5];
            BingoField tmpField = new BingoField();

            int ignoreLine = 1;
            while (sc.hasNextLine() && ignoreLine < 8) {
                ignoreLine++;
                sc.nextLine();

                if (ignoreLine >= 3) {
                    for (int j = 0; j < 5; j++) {
                        for (int i = 0; i < 5; i++) {
                            int number = sc.nextInt();
                            tmpField.setNumber(number);
                            tmpField.setMarked(false);
                            tmpBoard[j][i] = tmpField;
                            // System.out.print(" " + tmpBoard[j][i].getNumber());
                        }
                        System.out.println();
                        if (sc.hasNextLine())
                            sc.nextLine();
                        else
                            break;
                    }
                    // System.out.println("end of board");
                    boards.add(tmpBoard);
                }
            }
            sc.close();
            return boards;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return boards;
        }
    }

    private ArrayList<Integer> GetNumbers() {
        ArrayList<Integer> nums = new ArrayList<>();
        try {
            File myObj = new File(filename);
            Scanner sc = new Scanner(myObj);

            String line = sc.nextLine();
            String[] stringNums = line.split(",");
            for (String s : stringNums) {
                nums.add(Integer.parseInt(s));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return nums;
    }
}
