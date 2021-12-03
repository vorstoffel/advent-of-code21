package adventofcode2021;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public ArrayList<Integer> getValuesAsIntegers(String filename) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        try {
            File myObj = new File(filename);
            Scanner scanner = new Scanner(myObj);

            while (scanner.hasNextLine()) {
                values.add(Integer.valueOf(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return values;
    }

    public ArrayList<String> getValuesAsStrings(String filename) {
        ArrayList<String> values = new ArrayList<String>();
        try {
            File myObj = new File(filename);
            Scanner scanner = new Scanner(myObj);

            while (scanner.hasNextLine()) {
                values.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return values;
    }
}
