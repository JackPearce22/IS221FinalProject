import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
            System.out.println("Welcome to the Wealth Allocator\n");
            System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⡤⡄⠒⠊⠉⢀⣀⢨⠷⡄⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⢀⡇⠈⢹⣩⢟⣜⣐⡵⡿⢇⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⡠⠖⠊⠉⠀⠀⠈⠻⢅⠀⠀⠀⠀⠀⠈⠒⠠⢀⠀⠀\n" +
                    "⠀⡜⠁⠀⠀⠀⠀⠀⠀⠀⠀⠙⠢⣄⠀⠀⠀⠀⣀⣀⣼⠂\n" +
                    "⢰⠃⠀⠀⠀⡀⡀⠀⠀⠀⠀⠀⠀⠈⢷⡲⡺⣩⡤⢊⠌⡇\n" +
                    "⠸⡆⠀⠀⡞⠀⡇⠀⢰⣓⢢⣄⠀⠀⢸⣞⡞⢉⠔⡡⢊⣷\n" +
                    "⠀⢣⠀⠀⠹⡄⡇⠀⢸⣂⡡⢖⠳⣄⢸⢋⠔⡡⢊⣰⠠⠋\n" +
                    "⠀⠀⢣⡀⠀⠈⠁⠀⠸⣗⠾⣙⣭⡾⢿⡶⢏⠁⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠳⡀⠀⠀⠀⠀⠻⣽⠊⣡⠞⢉⢔⠝⣑⢄⠀⠀⠀\n" +
                    "⠀⠀⠀⢀⣹⣆⠀⠀⠀⠀⠈⠳⣤⢊⠔⡡⠊⢁⡤⠓⠄⠀\n" +
                    "⠀⡶⡿⣋⣵⢟⣧⠀⠀⠀⠀⠀⠈⢧⡊⣀⠔⡩⠐⣀⠙⡄\n" +
                    "⠸⡇⢹⣋⠕⡫⠘⡇⠀⣄⠀⠀⠀⠀⢻⡕⢁⠤⠊⢁⡀⡇\n" +
                    "⠀⡇⠀⠳⣵⢊⢽⡇⠀⡏⢳⡀⠀⠀⠀⣟⣡⠴⠚⡉⠠⡇\n" +
                    "⠀⠘⢆⡀⠈⠉⠉⠀⠀⣧⣼⡗⠀⠀⠀⣹⠐⣈⠠⠤⣰⠀\n" +
                    "⠀⠀⠀⠙⠦⡀⠀⠀⠀⠉⠉⠀⠀⠀⢀⡯⠥⣒⣂⡱⠃⠀\n" +
                    "⠀⠀⠀⠀⠀⠈⢧⠀⠀⠀⠀⠀⠀⢀⣞⣉⠭⠴⠋⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠘⡆⠀⡶⣶⠶⠒⠉⠁⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n");

            System.out.print("***Welcome to Smart Wealth Allocator***");
            scan.nextLine();

            System.out.print("Please provide your risk tolerance(high, medium, low): ");
            String riskTolerance = scan.nextLine();

            int riskScore = calcRiskScore(riskTolerance);
            System.out.println("Your risk score is: " + riskScore);


            System.out.print("Please provide your annual income: ");
            long annualIncome = scan.nextLong();
            scan.nextLine();

            System.out.print("Please provide your filing status (single or married): ");
            String filingStatus = scan.nextLine();

            calcTaxBracket(annualIncome, filingStatus);

            System.out.print("Please provide your time horizon (years): ");
            double timeHorizon = scan.nextInt();

            int timeScore = calcTimeScore(timeHorizon);
            System.out.println("Your time score is: " + timeScore);
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
            String[] args = {};
            main(args);
            return 0;
        }
    }

        private static int calcTimeScore (double years) {
            System.out.println("Calculating Time Score...");
            if (years < 2) {
                return 25;
            } else if (years <= 5) {
                return 50;
            } else if (years <= 10) {
                return 75;
            } else if (years > 10) {
                return 100;
            } else {
                System.out.println("Invalid input. Please enter a valid number of years.");
                String[] args = {};
                main(args);
                return 0;
            }
        }
        private static void calcTaxBracket (long annualIncome, String filingStatus) {
            System.out.println("Calculating Tax Bracket...");

            double taxRate;

            if (filingStatus.equalsIgnoreCase("single")) {
                if (annualIncome <= 11925 && annualIncome > 0) {
                    taxRate = 10;
                } else if (annualIncome <= 48475 && annualIncome > 0) {
                    taxRate = 12;
                } else if (annualIncome <= 103350 && annualIncome > 0) {
                    taxRate = 22;
                } else if (annualIncome <= 250525 && annualIncome > 0) {
                    taxRate = 32;
                } else if (annualIncome <= 626350 && annualIncome > 0) {
                    taxRate = 35;
                } else {
                    taxRate = 37;
                }
            } else if (filingStatus.equalsIgnoreCase("married")) {
                if (annualIncome <= 23850 && annualIncome > 0) {
                    taxRate = 10;
                } else if (annualIncome <= 96950 && annualIncome > 0) {
                    taxRate = 12;
                } else if (annualIncome <= 206700 && annualIncome > 0) {
                    taxRate = 22;
                } else if (annualIncome <= 394600 && annualIncome > 0) {
                    taxRate = 24;
                } else if (annualIncome <= 501050 && annualIncome > 0) {
                    taxRate = 32;
                } else if (annualIncome <= 751600 && annualIncome > 0) {
                    taxRate = 35;
                } else {
                    taxRate = 37;
                }
            } else {
                System.out.println("Invalid filing status.");
                String[] args = {};
                main(args);
                return;
            }

            System.out.println("Your annual income is $" + annualIncome);
            System.out.println("Your estimated tax bracket is: " + (int)taxRate + "%");
        }
        private static void calcAllocation () {
            System.out.println("Calculating Allocation...");
        }
    }