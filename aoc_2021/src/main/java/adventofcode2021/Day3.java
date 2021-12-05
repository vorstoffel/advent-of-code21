package adventofcode2021;

import java.util.ArrayList;

public class Day3 {
    public FileReader reader = new FileReader();
    static String filename = "aoc_2021\\src\\main\\data\\day3.txt";
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

    // the least common line, if equal 1s deleted
    public String Co2Ratings() {
        ArrayList<String> co2Cmds = commands;

        for (int j = 0; j < co2Cmds.get(0).length(); j++) {
            char commonNum = FindUncommonNum(co2Cmds, j);
            ArrayList<String> tmpCmds = new ArrayList<String>();
            for (int i = 0; i < co2Cmds.size(); i++) {
                commonNum = FindUncommonNum(co2Cmds, j);

                if (co2Cmds.size() <= 1) {
                    return co2Cmds.get(0);
                }
                if (co2Cmds.get(i).charAt(j) == commonNum) {
                    tmpCmds.add(co2Cmds.get(i));
                }
            }
            co2Cmds = tmpCmds;
        }
        return co2Cmds.get(0);
    }

    // the most common line, if equal 0s deleted
    public String OxygenRatings() {
        ArrayList<String> oxygenCmds = commands;

        for (int j = 0; j < oxygenCmds.get(0).length(); j++) {
            char commonNum = FindCommonNum(oxygenCmds, j);

            ArrayList<String> tmpCmds = new ArrayList<String>();
            for (int i = 0; i < oxygenCmds.size(); i++) {
                commonNum = FindCommonNum(oxygenCmds, j);

                if (oxygenCmds.size() <= 1) {
                    return oxygenCmds.get(0);
                }
                if (oxygenCmds.get(i).charAt(j) == commonNum) {
                    tmpCmds.add(oxygenCmds.get(i));
                }
            }
            oxygenCmds = tmpCmds;
        }
        return oxygenCmds.get(0);
    }

    public void GetRatings() {
        String oxy = OxygenRatings();
        String co2 = Co2Ratings();
        int solution = Integer.parseInt(oxy, 2) * Integer.parseInt(co2, 2);

        System.out.println("oxygen rating: binary: " + oxy);
        System.out.println("co2 rating: " + co2);
        System.out.println("solution: " + solution);
    }

    public char FindUncommonNum(ArrayList<String> cmds, int position) {
        char commonNum = FindCommonNum(cmds, position);
        if (commonNum == '0')
            return '1';
        else
            return '0';

    }

    public char FindCommonNum(ArrayList<String> cmds, int position) {
        int ones = 0;
        for (String command : cmds) {
            if (command.charAt(position) == '1')
                ones++;
        }
        if (cmds.size() / 2.0 > ones) {
            // System.out.println("returned 0. counted ones: " + ones);
            return '0';
        } else {
            // System.out.println("returned 1. counted ones: " + ones);
            return '1';
        }
    }
}
