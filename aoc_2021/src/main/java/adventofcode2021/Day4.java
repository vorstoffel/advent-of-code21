package adventofcode2021;

import adventofcode2021.models.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {
    public FileReader reader = new FileReader();
    static String filename = "aoc_2021\\src\\main\\data\\day4.txt";

    ArrayList<Integer> numbers;
    int currentMarkingNumber;
    ArrayList<BingoField[][]> boards;
    int indexOfWinner = 0;
    BingoField[][] winnerBoard = new BingoField[5][5];

    public void LoseBingo() {
        numbers = GetNumbers();
        boards = GetBoards();

        while (boards.size() >= 1) {
            PlayOneRoundWith(DrawNumber());
            // PrintNumbers();
            // PrintBoards(boards);

            if (boards.size() <= 1 && IsBingo()) {
                int sumOfUnmarkedNums = GetSumOfUnmarkedNumbersOf(boards.get(0));
                int worstBoard = sumOfUnmarkedNums * currentMarkingNumber;
                System.out.println("Oh no I lost with " + worstBoard + " !");
            }

            while (IsBingo()) {
                boards.remove(indexOfWinner);
            }
        }
    }

    public void PlayBingo() {
        numbers = GetNumbers();
        boards = GetBoards();

        while (!IsBingo()) {
            PlayOneRoundWith(DrawNumber());
            PrintNumbers();
            PrintBoards(boards);

            /*
             * System.out.println("Press any key to play next round... ");
             * try {
             * System.in.read();
             * } catch (Exception e) {
             * e.printStackTrace();
             * }
             */

            if (IsBingo()) {
                int solution = GetSumOfUnmarkedNumbersOf(winnerBoard) * currentMarkingNumber;
                System.out.println("Bingo  " + solution + " !");
            }
        }
    }

    private int GetSumOfUnmarkedNumbersOf(BingoField[][] winnerBoard) {
        int unmarkedSum = 0;
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                if (!winnerBoard[i][j].isMarked())
                    unmarkedSum += winnerBoard[i][j].getNumber();
            }
        }
        return unmarkedSum;
    }

    private boolean IsBingo() {
        int indexOfWin = 0;
        for (BingoField[][] bingoFields : boards) {
            for (int j = 0; j < 5; j++) {
                int markedRow = 0;
                int markedColumn = 0;
                for (int i = 0; i < 5; i++) {
                    if (bingoFields[j][i].isMarked())
                        markedRow++;
                    if (bingoFields[i][j].isMarked())
                        markedColumn++;
                    if (markedRow >= 5 || markedColumn >= 5) {
                        winnerBoard = bingoFields;
                        indexOfWinner = indexOfWin;
                        return true;
                    }
                }
            }
            indexOfWin++;
        }
        return false;
    }

    private void PlayOneRoundWith(int drawnNumber) {
        for (BingoField[][] bingoFields : boards) {
            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < 5; i++) {
                    int bingoNumber = bingoFields[j][i].getNumber();
                    if (bingoNumber == drawnNumber)
                        bingoFields[j][i].setMarked(true);
                }
            }
        }
    }

    private int DrawNumber() {
        currentMarkingNumber = numbers.get(0);
        numbers.remove(0);
        // System.out.println("Number " + currentMarkingNumber + " is chosen.");
        return currentMarkingNumber;
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
                    if (bingoFields[j][i].isMarked())
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
