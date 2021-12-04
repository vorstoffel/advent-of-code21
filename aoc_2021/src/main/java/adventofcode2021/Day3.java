package adventofcode2021;

import java.util.ArrayList;

public class Day3 {
    public FileReader reader = new FileReader();
    static String filename = "aoc_2021\\src\\main\\day3_testdata.txt";
    ArrayList<String> commands = reader.getValuesAsStrings(filename);
    int cmdLength = commands.get(0).length();

    public void BinaryDiagnostic() {
        // most common bits
        String gamma = "";
        // least common bits
        String epsilon = "";
        // Power consumption -> multiplying the gamma rate by the epsilon rate
        int powerConsumption = 0;
        for (int i = 0; i < cmdLength; i++) {
            int zeros = 0;
            int ones = 0;
            for (String command : commands) {
                if (command.charAt(i) == '0') {
                    zeros++;
                } else if (command.charAt(i) == '1') {
                    ones++;
                }
            }
            // System.out.println("zeros: " + zeros + ", ones: " + ones);
            if (zeros > ones) {
                gamma += "0";
                epsilon += "1";
                // System.out.println("zeros > ones: gamma: " + gamma + ", epsilon: " +
                // epsilon);
            } else if (zeros < ones) {
                gamma += "1";
                epsilon += "0";
                // System.out.println("zeros < ones: gamma: " + gamma + ", epsilon: " +
                // epsilon);
            } else {
                System.out.println("What just happened? Equal zeros and ones??... >:(");
            }
        }
        System.out.println("-----------------------");
        System.out.println("gamma rate: " + gamma); // 10110 testdata solution
        System.out.println("epsilon rate: " + epsilon); // 01001 testdata solution
        System.out.println("-----------------------");
        int gammaDecimal = Integer.parseInt(gamma, 2);
        int epsilonDecimal = Integer.parseInt(epsilon, 2);

        System.out.println("gamma rate: " + gammaDecimal);
        System.out.println("epsilon rate: " + epsilonDecimal);
        powerConsumption = gammaDecimal * epsilonDecimal;
        System.out.println("-----------------------");
        System.out.println("Diagnostic says " + powerConsumption + " power consumption!");
        // Testlösung: 198
    }
    /*
     * public String GetRate(char equalNum, boolean searchCommon) {
     * ArrayList<String> tmpCommands = commands;
     * 
     * int test = 1;
     * while (test > 0 && tmpCommands.size() > 1) {
     * System.out.println("------------------------");
     * for (String s : tmpCommands) {
     * System.out.println(s);
     * }
     * System.out.println("------------------------");
     * test--;
     * for (int position = 0; position < cmdLength; position++) {
     * 
     * int zeros = 0;
     * int ones = 0;
     * // find un/common values
     * for (String command : tmpCommands) {
     * if (command.charAt(position) == '0')
     * zeros++;
     * else if (command.charAt(position) == '1')
     * ones++;
     * }
     * System.out.println("zeros: " + zeros + ", ones: " + ones);
     * 
     * // delete entries with un/common values
     * for (int j = 0; j < cmdLength; j++) {
     * System.out.println("round " + j);
     * if (tmpCommands.size() <= 1)
     * return tmpCommands.get(0);
     * 
     * if (zeros > ones) {
     * if (searchCommon && tmpCommands.get(j).charAt(position) == '0') {
     * System.out.println("remove " + tmpCommands.get(j));
     * tmpCommands.remove(j);
     * }
     * } else if (zeros < ones) {
     * if (searchCommon && tmpCommands.get(j).charAt(position) == '1') {
     * System.out.println("remove " + tmpCommands.get(j));
     * tmpCommands.remove(j);
     * }
     * } else {
     * if (equalNum == tmpCommands.get(j).charAt(position)) {
     * System.out.println("remove " + tmpCommands.get(j));
     * tmpCommands.remove(j);
     * }
     * }
     * }
     * 
     * }
     * }
     * 
     * String lastValue = tmpCommands.get(0);
     * System.out.println("Last Remaining Value found: " + lastValue);
     * return lastValue;
     * }
     */

    public void CalculateLifeSupportRating() {
        final char OXYGEN_DELETE_IF = '0';
        final char CO2_DELETE_IF = '1';

        // String mostCommonValueOxygen = GetRate(OXYGEN_DELETE_IF, true);
        // String leastCommonValueCo2 = GetOxygenRateWithMostCommon(CO2_DELETE_IF,
        // false);

        // System.out.println("oxygen rate: " + mostCommonValueOxygen);
        // System.out.println("co2 rate: " + leastCommonValueCo2);

    }

    // the most common line, if equal 0s deleted
    public void OxygenRatings() {
        ArrayList<String> oxygenCmds = commands;
        int commonNum = FindCommonNum(oxygenCmds, 0);
        System.out.println("common num on pos 0: " + commonNum);

        for (int i = 0; i < oxygenCmds.size(); i++) {
            if (oxygenCmds.get(i).charAt(0) != (char) commonNum) {
                System.out.println("remove " + oxygenCmds.get(i));
                oxygenCmds.remove(i);
                i--;
            }
        }

    }

    public int FindCommonNum(ArrayList<String> cmds, int position) {
        int zeros = 0;
        int ones = 0;
        // find un/common values
        for (String command : cmds) {
            if (command.charAt(position) == '0')
                zeros++;
            else if (command.charAt(position) == '1')
                ones++;
        }
        System.out.println("zeros: " + zeros + ", ones: " + ones);
        if (zeros > ones)
            return 0;
        else
            return 1;
    }
}
