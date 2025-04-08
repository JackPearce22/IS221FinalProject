import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        System.out.print("Please provide your risk tolerance(high, medium, low): ");
        String riskTolerance = scan.nextLine();

        int riskScore = calcRiskScore(riskTolerance);

        System.out.print("Please provide your monthly income: ");
        long monthlyIncome = scan.nextLong();
        scan.nextLine();

        System.out.print("Please provide your time horizon (years): ");
        double timeHorizon = scan.nextDouble();
        scan.nextLine();

    }

    private static int calcRiskScore(String riskTolerance) {
        System.out.println("Calculating Risk Score...");
        int riskScore;
        if (riskTolerance.equalsIgnoreCase("low")) {
            riskScore = 33;
        } else if (riskTolerance.equalsIgnoreCase("medium")) {
            riskScore = 66;
        } else if (riskTolerance.equalsIgnoreCase("high")) {
            riskScore = 100;
        } else {
            System.out.println("Invalid input. Setting risk score to 0.");
            riskScore = 0;
        }
        System.out.println("Your risk score is: " + riskScore);
        return riskScore;
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