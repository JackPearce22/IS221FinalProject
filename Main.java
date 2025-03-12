import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        System.out.print("Please provide your risk tolerance(high, medium, low): ");
        String riskTolerance = scan.nextLine();
        scan.nextLine();

        System.out.print("Please provide your monthly income: ");
        long monthlyIncome = scan.nextLong();
        scan.nextLine();

        System.out.print("Please provide your time horizon: ");
        double timeHorizon = scan.nextDouble();
        scan.nextLine();

    }

    private static void calcRiskScore(){
        System.out.println("Calculating Risk Score...");
    }
    private static void calcTimeScore(){
        System.out.println("Calculating Time Score...");
    }
    private static void calcTaxBracket(){
        System.out.println("Calculating Tax Bracket...");
    }
    private static void calcAllocation(){
        System.out.println("Calculating Allocation...");
    }

}
