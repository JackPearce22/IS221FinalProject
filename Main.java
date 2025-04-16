import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
            System.out.println("*****Welcome to Smart Wealth Allocator*****\n");
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

            System.out.print("Please provide your monthly expenses: ");
            double monthlyExpenses = scan.nextDouble();

            String allocationType = calcAllocation(riskScore, timeScore);

            String result = printResult(annualIncome,monthlyExpenses, allocationType);
            System.out.print(result);
            System.out.print("Disclaimer: This tool is for informational purposes only and does not constitute financial, investment, or tax advice. Please consult a licensed financial advisor or tax professional before making any financial decisions. ");

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
        private static String calcAllocation (int riskScore, int timeScore){
            System.out.println("Calculating Allocation...");

            int allocationScore = riskScore * timeScore;

            System.out.println("Your allocation score is: " + allocationScore);

            if (allocationScore >= 825 && allocationScore <= 1650) {
                System.out.println("Recommended Allocation: Conservative");
                return "Conservative";
            } else if (allocationScore >= 2475 && allocationScore <= 2500) {
                System.out.println("Recommended Allocation: Moderately Conservative");
                return "Moderately Conservative";
            } else if (allocationScore >= 3300 && allocationScore <= 5000) {
                System.out.println("Recommended Allocation: Moderate Allocation");
                return "Moderate Allocation";
            } else if (allocationScore >= 6600 && allocationScore <= 7500) {
                System.out.println("Recommended Allocation: Moderately Aggressive");
                return "Moderately Aggressive";
            } else if (allocationScore == 10000) {
                System.out.println("Recommended Allocation: Aggressive");
                return "Aggressive";
            } else {
                System.out.println("Unable to determine a precise allocation. Please review your inputs.");
                return "Unable to determine a precise allocation. Please review your inputs.";
            }



        }

        private static String printResult(long annualIncome, double monthlyExpenses, String allocationType){
            double minEmergencyFund = monthlyExpenses * 3;
            double maxEmergencyFund = monthlyExpenses * 6;

            double retirementPlan = annualIncome * .05;
            double brokerageAccount = annualIncome * .1;

            String rothFunds = "";
            String portfolioBreakdown = "";

            if (allocationType == "Conservative"){
                rothFunds += "conservative growth (WBALX, VWINX, FXNAX )";
                portfolioBreakdown += "10% Large cap stocks\n" +
                        "15 % Small Cap\n" +
                        "15% International\n" +
                        "50% Fixed Income\n" +
                        "10% Cash\n";
            } else if (allocationType == "Moderately Conservative") {
                rothFunds += "moderately conservative growth (VWINX, FXNAX, VFSTX )";
                portfolioBreakdown += "15% Large cap stocks\n" +
                        "20 % Small Cap\n" +
                        "20% International\n" +
                        "35% Fixed Income\n" +
                        "10% Cash\n";

            } else if (allocationType == "Moderate Allocation") {
                rothFunds += "moderate allocation growth (FSKAX, VBIAX, FXNAX)";
                portfolioBreakdown += "10% Large cap stocks\n" +
                        "15 % Small Cap\n" +
                        "15% International\n" +
                        "50% Fixed Income\n" +
                        "10% Cash\n";

            } else if (allocationType == "Moderately Aggressive") {
                rothFunds += "moderately aggressive growth (VTI, FTIHX, VWELX)";
                portfolioBreakdown += "50% Large cap stocks\n" +
                        "20% Small Cap\n" +
                        "25% International\n" +
                        "5% Cash\n";

            } else if (allocationType == "Aggressive") {
                rothFunds += "aggressive growth (VOOG, SMH, QQQM )";
                portfolioBreakdown += "50% Large cap stocks\n" +
                        "20 % Small Cap\n" +
                        "25% International\n" +
                        "5% Cash\n";

            } else{
                System.out.println("Error");
            }

            return "Emergency Fund (3 - 6 months of expenses) in High Yield Savings Account\n" +
                    "This would equal ~"+minEmergencyFund+"-"+maxEmergencyFund+"\n" +
                    "CIT bank offers a High-Yield Savings Account offering variable 4.10% Annual Percentage Yield with a minimum $5,000 balance, but interest may change at any time\n" +
                    "Retirement Plan (5%)\n" +
                    "Choose Roth 401k if given the option for company plan\n" +
                    "5% of income to match company benefits = "+retirementPlan+" per year\n" +
                    "Funds to consider in Roth IRA for "+rothFunds+"\n" +
                    "Brokerage Account (10% of income)\n" +
                    "10% of income = "+brokerageAccount+" per year\n" +
                    "Portfolio Breakdown\n" + portfolioBreakdown;

        }
    }