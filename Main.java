import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        System.out.print("Please provide your risk tolerance(high, medium, low): ");
        String riskTolerance = scan.nextLine();

        int riskScore = calcRiskScore(riskTolerance);
        System.out.println("Your risk score is: " + riskScore);


        System.out.print("Please provide your monthly income: ");
        long monthlyIncome = scan.nextLong();
        scan.nextLine();

        System.out.print("Please provide your time horizon (years): ");
        double timeHorizon = scan.nextDouble();
        scan.nextLine();

    }

    private static int calcRiskScore(String riskTolerance) {
        System.out.println("Calculating Risk Score...");
        if (riskTolerance.equalsIgnoreCase("low")) {
            return 33;
        } else if (riskTolerance.equalsIgnoreCase("medium")) {
            return 66;
        } else if (riskTolerance.equalsIgnoreCase("high")) {
            return 100;
        } else {
            System.out.println("Invalid input. Please select low, medium or high.");
        }
    }

        private static void calcTimeScore () {
            System.out.println("Calculating Time Score...");
        }
        private static void calcTaxBracket () {
            System.out.println("Calculating Tax Bracket...");
        }
        private static void calcAllocation () {
            System.out.println("Calculating Allocation...");
        }
    }