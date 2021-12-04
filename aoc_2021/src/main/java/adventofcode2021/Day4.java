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
        PrintNumbers();
        boards = GetBoards();
        PrintBoards(boards);
        DrawNumber();
        PrintNumbers();
    }

    private void DrawNumber() {
        int number = numbers.get(0);
        numbers.remove(0);

    }

    private void PrintNumbers() {
        System.out.print("Remaining numbers: ");
        for (int i : numbers) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    private void PrintBoards(ArrayList<BingoField[][]> boards) {
        for (BingoField[][] bingoFields : boards) {
            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < 5; i++) {
                    int num = bingoFields[j][i].getNumber();
                    if (bingoFields[j][i].getMarked())
                        System.out.print(" {" + num + "} ");
                    else
                        System.out.print(" " + num + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private ArrayList<BingoField[][]> GetBoards() {
        try {
            File myObj = new File(filename);
            Scanner sc = new Scanner(myObj);
            boards = new ArrayList<BingoField[][]>();

            int ignoreLine = 1;
            while (sc.hasNextLine()) {
                ignoreLine++;
                sc.nextLine();
                BingoField[][] tmpBoard = new BingoField[5][5];

                if (ignoreLine >= 3) {
                    for (int j = 0; j < 5; j++) {
                        for (int i = 0; i < 5; i++) {
                            int number = sc.nextInt();
                            BingoField tmpField = new BingoField();
                            tmpField.setNumber(number);
                            tmpField.setMarked(false);
                            tmpBoard[j][i] = tmpField;
                        }
                        System.out.println();
                        if (sc.hasNextLine())
                            sc.nextLine();
                        else
                            break;
                    }
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
