import java.util.Scanner;

public class ConsoleGUI {
    public static final Scanner scan = new Scanner(System.in);

    /**
     * Asks user for risk tolerance using scanner
     * @return
     */
    public static String getRiskTolerance() {
        while (true) {
            System.out.print("Enter your risk tolerance (high, medium, low): ");
            String input = scan.nextLine().trim().toLowerCase();
            if (input.equals("high") || input.equals("medium") || input.equals("low")) {
                return input;
            }
            System.out.println("Invalid input.");
        }
    }

    /**
     * Asks user for risk tolerance using scanner
     * @return
     */
    public static long getAnnualIncome() {
        while (true) {
            System.out.print("Enter your annual income: ");
            try {
                long income = Long.parseLong(scan.nextLine());
                if (income > 0) return income;
            } catch (NumberFormatException _) {
            }
            System.out.println("Please enter a valid number.");
        }
    }

    /**
     * Asks user for filing status using scanner
     * @return
     */
    public static String getFilingStatus() {
        while (true) {
            System.out.print("Filing status (single or married): ");
            String input = scan.nextLine().trim().toLowerCase();
            if (input.equals("single") || input.equals("married")) return input;
            System.out.println("Invalid filing status.");
        }
    }

    /**
     * Asks user for time horizon using scanner
     * @return
     */
    public static double getTimeHorizon() {
        while (true) {
            System.out.print("Time horizon in years: ");
            try {
                double years = Double.parseDouble(scan.nextLine());
                if (years > 0) return years;
            } catch (NumberFormatException _) {
            }
            System.out.println("Invalid input. Enter a number.");
        }
    }

    /**
     * Asks user for monthly expenses using scanner
     * @return
     */
    public static double getMonthlyExpenses() {
        while (true) {
            System.out.print("Enter your monthly expenses: ");
            try {
                double expenses = Double.parseDouble(scan.nextLine());
                if (expenses >= 0) return expenses;
            } catch (NumberFormatException _) {
            }
            System.out.println("Please enter a valid number.");
        }
    }


}
