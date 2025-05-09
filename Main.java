
public class Main {
    public static void main(String[] args){
            System.out.println("*****Welcome to Smart Wealth Allocator*****\n");
            System.out.print("""
                    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀
                    ⠀⠀⠀⠀⠀⠀⡤⡄⠒⠊⠉⢀⣀⢨⠷⡄⠀⠀⠀⠀⠀⠀
                    ⠀⠀⠀⠀⠀⢀⡇⠈⢹⣩⢟⣜⣐⡵⡿⢇⠀⠀⠀⠀⠀⠀
                    ⠀⠀⡠⠖⠊⠉⠀⠀⠈⠻⢅⠀⠀⠀⠀⠀⠈⠒⠠⢀⠀⠀
                    ⠀⡜⠁⠀⠀⠀⠀⠀⠀⠀⠀⠙⠢⣄⠀⠀⠀⠀⣀⣀⣼⠂
                    ⢰⠃⠀⠀⠀⡀⡀⠀⠀⠀⠀⠀⠀⠈⢷⡲⡺⣩⡤⢊⠌⡇
                    ⠸⡆⠀⠀⡞⠀⡇⠀⢰⣓⢢⣄⠀⠀⢸⣞⡞⢉⠔⡡⢊⣷
                    ⠀⢣⠀⠀⠹⡄⡇⠀⢸⣂⡡⢖⠳⣄⢸⢋⠔⡡⢊⣰⠠⠋
                    ⠀⠀⢣⡀⠀⠈⠁⠀⠸⣗⠾⣙⣭⡾⢿⡶⢏⠁⠀⠀⠀⠀
                    ⠀⠀⠀⠳⡀⠀⠀⠀⠀⠻⣽⠊⣡⠞⢉⢔⠝⣑⢄⠀⠀⠀
                    ⠀⠀⠀⢀⣹⣆⠀⠀⠀⠀⠈⠳⣤⢊⠔⡡⠊⢁⡤⠓⠄⠀
                    ⠀⡶⡿⣋⣵⢟⣧⠀⠀⠀⠀⠀⠈⢧⡊⣀⠔⡩⠐⣀⠙⡄
                    ⠸⡇⢹⣋⠕⡫⠘⡇⠀⣄⠀⠀⠀⠀⢻⡕⢁⠤⠊⢁⡀⡇
                    ⠀⡇⠀⠳⣵⢊⢽⡇⠀⡏⢳⡀⠀⠀⠀⣟⣡⠴⠚⡉⠠⡇
                    ⠀⠘⢆⡀⠈⠉⠉⠀⠀⣧⣼⡗⠀⠀⠀⣹⠐⣈⠠⠤⣰⠀
                    ⠀⠀⠀⠙⠦⡀⠀⠀⠀⠉⠉⠀⠀⠀⢀⡯⠥⣒⣂⡱⠃⠀
                    ⠀⠀⠀⠀⠀⠈⢧⠀⠀⠀⠀⠀⠀⢀⣞⣉⠭⠴⠋⠀⠀⠀
                    ⠀⠀⠀⠀⠀⠀⠘⡆⠀⡶⣶⠶⠒⠉⠁⠀⠀⠀⠀⠀⠀⠀
                    ⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                    """);

            String riskTolerance = ConsoleGUI.getRiskTolerance();
            int riskScore = calcRiskScore(riskTolerance);

            long annualIncome = ConsoleGUI.getAnnualIncome();

            String filingStatus = ConsoleGUI.getFilingStatus();
            calcTaxBracket(annualIncome, filingStatus);

            double timeHorizon = ConsoleGUI.getTimeHorizon();
            int timeScore = calcTimeScore(timeHorizon);

            double monthlyExpenses = ConsoleGUI.getMonthlyExpenses();

            String allocationType = calcAllocation(riskScore, timeScore);
            String result = printResult(annualIncome, monthlyExpenses, allocationType);
            System.out.print(result);

            System.out.println("Disclaimer: This tool is for informational purposes only and does not constitute financial, investment, or tax advice.");

    }

    /**
     * This method assigns a numeric risk score based on the user's risk tolerance input
     * @param riskTolerance
     * @return
     */
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
            return 0;
        }
    }

    /**
     * This method assigns a numeric time score based on the user's time horizon.
     * Time horizon is a value that measures how long the user plans to keep their investments
     * If the time horizon input < 2 years: score = 25
     * <= 5 years: score = 50
     * <= 10 years: score = 75
     * > 10 years: score = 100
     * @param years
     * @return
     */
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
                return 0;
            }
        }

    /**
     * Uses income and filing status to estimate the user's federal tax bracket.
     * Uses 2024 tax brackets for single filers and married filers.
     * @param annualIncome
     * @param filingStatus
     */
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
                return;
            }

            System.out.println("Your annual income is $" + annualIncome);
            System.out.println("Your estimated tax bracket is: " + (int)taxRate + "%");
        }

    /**
     * Calculates an overall investment allocation recommendation based on combined risk and time score.
     * The different ranges of allocation will determine the recommended portfolio type:
     * Conservative, Moderately Conservative, Moderate, Moderately Aggressive, and Aggressive.
     * @param riskScore
     * @param timeScore
     * @return
     */
    private static String calcAllocation (int riskScore, int timeScore){
            System.out.println("Calculating Allocation...");

            int allocationScore = riskScore * timeScore;

            System.out.println("Your allocation score is: " + allocationScore);

            if (allocationScore >= 825 && allocationScore <= 1650) {
                System.out.println("""
                        Recommended Allocation:
                           /$$$$$$                                                                           /$$     /$$                    \s
                         /$$__  $$                                                                         | $$                        \s
                        | $$  \\__/  /$$$$$$  /$$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$  /$$    /$$  /$$$$$$  /$$$$$$   /$$ /$$    /$$  /$$$$$$\s
                        | $$       /$$__  $$| $$__  $$ /$$_____/ /$$__  $$ /$$__  $$|  $$  /$$/ |____  $$|_  $$_/  | $$|  $$  /$$/ /$$__  $$
                        | $$      | $$  \\ $$| $$  \\ $$|  $$$$$$ | $$$$$$$$| $$  \\__/ \\  $$/$$/   /$$$$$$$  | $$    | $$ \\  $$/$$/ | $$$$$$$$
                        | $$    $$| $$  | $$| $$  | $$ \\____  $$| $$_____/| $$        \\  $$$/   /$$__  $$  | $$ /$$| $$  \\  $$$/  | $$_____/
                        |  $$$$$$/|  $$$$$$/| $$  | $$ /$$$$$$$/|  $$$$$$$| $$         \\  $/   |  $$$$$$$  |  $$$$/| $$   \\  $/   |  $$$$$$$
                         \\______/  \\______/ |__/  |__/|_______/  \\_______/|__/          \\_/     \\_______/   \\___/  |__/    \\_/     \\_______/
                                                                                                                                           \s""");
                return "Conservative";
            } else if (allocationScore >= 2475 && allocationScore <= 2500) {
                System.out.println("""
                        Recommended Allocation:
                          /$$      /$$                 /$$                                 /$$               /$$                  /$$$$$$                                                                           /$$     /$$                    \s
                        | $$$    /$$$                | $$                                | $$              | $$                 /$$__  $$                                                                         | $$                        \s
                        | $$$$  /$$$$  /$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$    /$$$$$$ | $$ /$$   /$$      | $$  \\__/  /$$$$$$  /$$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$  /$$    /$$  /$$$$$$  /$$$$$$   /$$ /$$    /$$  /$$$$$$\s
                        | $$ $$/$$ $$ /$$__  $$ /$$__  $$ /$$__  $$ /$$__  $$ |____  $$|_  $$_/   /$$__  $$| $$| $$  | $$      | $$       /$$__  $$| $$__  $$ /$$_____/ /$$__  $$ /$$__  $$|  $$  /$$/ |____  $$|_  $$_/  | $$|  $$  /$$/ /$$__  $$
                        | $$  $$$| $$| $$  \\ $$| $$  | $$| $$$$$$$$| $$  \\__/  /$$$$$$$  | $$    | $$$$$$$$| $$| $$  | $$      | $$      | $$  \\ $$| $$  \\ $$|  $$$$$$ | $$$$$$$$| $$  \\__/ \\  $$/$$/   /$$$$$$$  | $$    | $$ \\  $$/$$/ | $$$$$$$$
                        | $$\\  $ | $$| $$  | $$| $$  | $$| $$_____/| $$       /$$__  $$  | $$ /$$| $$_____/| $$| $$  | $$      | $$    $$| $$  | $$| $$  | $$ \\____  $$| $$_____/| $$        \\  $$$/   /$$__  $$  | $$ /$$| $$  \\  $$$/  | $$_____/
                        | $$ \\/  | $$|  $$$$$$/|  $$$$$$$|  $$$$$$$| $$      |  $$$$$$$  |  $$$$/|  $$$$$$$| $$|  $$$$$$$      |  $$$$$$/|  $$$$$$/| $$  | $$ /$$$$$$$/|  $$$$$$$| $$         \\  $/   |  $$$$$$$  |  $$$$/| $$   \\  $/   |  $$$$$$$
                        |__/     |__/ \\______/  \\_______/ \\_______/|__/       \\_______/   \\___/   \\_______/|__/ \\____  $$       \\______/  \\______/ |__/  |__/|_______/  \\_______/|__/          \\_/     \\_______/   \\___/  |__/    \\_/     \\_______/
                                                                                                                /$$  | $$                                                                                                                         \s
                                                                                                               |  $$$$$$/                                                                                                                         \s
                                                                                                                \\______/                                                                                                                          \s
                                                                                                                                                                                                                                                  \s""");
                return "Moderately Conservative";
            } else if (allocationScore >= 3300 && allocationScore <= 5000) {
                System.out.println("""
                        Recommended Allocation:
                         /$$      /$$                 /$$                                 /$$                      /$$$$$$  /$$ /$$                                 /$$     /$$                   \s
                        | $$$    /$$$                | $$                                | $$                     /$$__  $$| $$| $$                                | $$                       \s
                        | $$$$  /$$$$  /$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$    /$$$$$$       | $$  \\ $$| $$| $$  /$$$$$$   /$$$$$$$  /$$$$$$  /$$$$$$   /$$  /$$$$$$  /$$$$$$$\s
                        | $$ $$/$$ $$ /$$__  $$ /$$__  $$ /$$__  $$ /$$__  $$ |____  $$|_  $$_/   /$$__  $$      | $$$$$$$$| $$| $$ /$$__  $$ /$$_____/ |____  $$|_  $$_/  | $$ /$$__  $$| $$__  $$
                        | $$  $$$| $$| $$  \\ $$| $$  | $$| $$$$$$$$| $$  \\__/  /$$$$$$$  | $$    | $$$$$$$$      | $$__  $$| $$| $$| $$  \\ $$| $$        /$$$$$$$  | $$    | $$| $$  \\ $$| $$  \\ $$
                        | $$\\  $ | $$| $$  | $$| $$  | $$| $$_____/| $$       /$$__  $$  | $$ /$$| $$_____/      | $$  | $$| $$| $$| $$  | $$| $$       /$$__  $$  | $$ /$$| $$| $$  | $$| $$  | $$
                        | $$ \\/  | $$|  $$$$$$/|  $$$$$$$|  $$$$$$$| $$      |  $$$$$$$  |  $$$$/|  $$$$$$$      | $$  | $$| $$| $$|  $$$$$$/|  $$$$$$$|  $$$$$$$  |  $$$$/| $$|  $$$$$$/| $$  | $$
                        |__/     |__/ \\______/  \\_______/ \\_______/|__/       \\_______/   \\___/   \\_______/      |__/  |__/|__/|__/ \\______/  \\_______/ \\_______/   \\___/  |__/ \\______/ |__/  |__/
                                                                                                                                                                                                  \s
                                                                                                                                                                                                  \s""");
                return "Moderate Allocation";
            } else if (allocationScore >= 6600 && allocationScore <= 7500) {
                System.out.println("""
                        Recommended Allocation:
                         /$$      /$$                 /$$                                 /$$               /$$                  /$$$$$$                                                              /$$                    \s
                        | $$$    /$$$                | $$                                | $$              | $$                 /$$__  $$                                                                                \s
                        | $$$$  /$$$$  /$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$    /$$$$$$ | $$ /$$   /$$      | $$  \\ $$  /$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$$  /$$$$$$$ /$$ /$$    /$$  /$$$$$$\s
                        | $$ $$/$$ $$ /$$__  $$ /$$__  $$ /$$__  $$ /$$__  $$ |____  $$|_  $$_/   /$$__  $$| $$| $$  | $$      | $$$$$$$$ /$$__  $$ /$$__  $$ /$$__  $$ /$$__  $$ /$$_____/ /$$_____/| $$|  $$  /$$/ /$$__  $$
                        | $$  $$$| $$| $$  \\ $$| $$  | $$| $$$$$$$$| $$  \\__/  /$$$$$$$  | $$    | $$$$$$$$| $$| $$  | $$      | $$__  $$| $$  \\ $$| $$  \\ $$| $$  \\__/| $$$$$$$$|  $$$$$$ |  $$$$$$ | $$ \\  $$/$$/ | $$$$$$$$
                        | $$\\  $ | $$| $$  | $$| $$  | $$| $$_____/| $$       /$$__  $$  | $$ /$$| $$_____/| $$| $$  | $$      | $$  | $$| $$  | $$| $$  | $$| $$      | $$_____/ \\____  $$ \\____  $$| $$  \\  $$$/  | $$_____/
                        | $$ \\/  | $$|  $$$$$$/|  $$$$$$$|  $$$$$$$| $$      |  $$$$$$$  |  $$$$/|  $$$$$$$| $$|  $$$$$$$      | $$  | $$|  $$$$$$$|  $$$$$$$| $$      |  $$$$$$$ /$$$$$$$/ /$$$$$$$/| $$   \\  $/   |  $$$$$$$
                        |__/     |__/ \\______/  \\_______/ \\_______/|__/       \\_______/   \\___/   \\_______/|__/ \\____  $$      |__/  |__/ \\____  $$ \\____  $$|__/       \\_______/|_______/ |_______/ |__/    \\_/     \\_______/
                                                                                                                /$$  | $$                 /$$  \\ $$ /$$  \\ $$                                                                \s
                                                                                                               |  $$$$$$/                |  $$$$$$/|  $$$$$$/                                                                \s
                                                                                                                \\______/                  \\______/  \\______/                                                                 \s""");
                return "Moderately Aggressive";
            } else if (allocationScore == 10000) {
                System.out.println("""
                        Recommended Allocation:
                           /$$$$$$                                                              /$$                    \s
                         /$$__  $$                                                                                \s
                        | $$  \\ $$  /$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$$  /$$$$$$$ /$$ /$$    /$$  /$$$$$$\s
                        | $$$$$$$$ /$$__  $$ /$$__  $$ /$$__  $$ /$$__  $$ /$$_____/ /$$_____/| $$|  $$  /$$/ /$$__  $$
                        | $$__  $$| $$  \\ $$| $$  \\ $$| $$  \\__/| $$$$$$$$|  $$$$$$ |  $$$$$$ | $$ \\  $$/$$/ | $$$$$$$$
                        | $$  | $$| $$  | $$| $$  | $$| $$      | $$_____/ \\____  $$ \\____  $$| $$  \\  $$$/  | $$_____/
                        | $$  | $$|  $$$$$$$|  $$$$$$$| $$      |  $$$$$$$ /$$$$$$$/ /$$$$$$$/| $$   \\  $/   |  $$$$$$$
                        |__/  |__/ \\____  $$ \\____  $$|__/       \\_______/|_______/ |_______/ |__/    \\_/     \\_______/
                                   /$$  \\ $$ /$$  \\ $$                                                                \s
                                  |  $$$$$$/|  $$$$$$/                                                                \s
                                   \\______/  \\______/                                                                 \s""");
                return "Aggressive";
            } else {
                System.out.println("Unable to determine a precise allocation. Please review your inputs.");
                return "Unable to determine a precise allocation. Please review your inputs.";
            }



        }

    /**
     * Returns a summary message with financial information and suggested allocation based on user inputs.
     * @param annualIncome
     * @param monthlyExpenses
     * @param allocationType
     * @return
     */
        private static String printResult(long annualIncome, double monthlyExpenses, String allocationType){
            double minEmergencyFund = monthlyExpenses * 3;
            double maxEmergencyFund = monthlyExpenses * 6;

            double retirementPlan = annualIncome * .05;
            double brokerageAccount = annualIncome * .1;

            String rothFunds = "";
            String portfolioBreakdown = "";

            if (allocationType.equals("Conservative")){
                rothFunds += "conservative growth (WBALX, VWINX, FXNAX )";
                portfolioBreakdown += """
                        \t\t10% Large cap stocks
                        \t\t15 % Small Cap
                        \t\t15% International
                        \t\t50% Fixed Income
                        \t\t10% Cash
                        """;
            } else if (allocationType.equals("Moderately Conservative")) {
                rothFunds += "moderately conservative growth (VWINX, FXNAX, VFSTX )";
                portfolioBreakdown += """
                        \t\t15% Large cap stocks
                        \t\t20 % Small Cap
                        \t\t20% International
                        \t\t35% Fixed Income
                        \t\t10% Cash
                        """;

            } else if (allocationType.equals("Moderate Allocation")) {
                rothFunds += "moderate allocation growth (FSKAX, VBIAX, FXNAX, VOO)";
                portfolioBreakdown += """
                        \t\t10% Large cap stocks
                        \t\t15 % Small Cap
                        \t\t15% International
                        \t\t50% Fixed Income
                        \t\t10% Cash
                        """;

            } else if (allocationType.equals("Moderately Aggressive")) {
                rothFunds += "moderately aggressive growth (VTI, FTIHX, VOO, QQQ)";
                portfolioBreakdown += """
                        \t\t50% Large cap stocks
                        \t\t20% Small Cap
                        \t\t25% International
                        \t\t5% Cash
                        """;

            } else if (allocationType.equals("Aggressive")) {
                rothFunds += "aggressive growth (VOO, QQQ, QQQM )";
                portfolioBreakdown += """
                        \t\t50% Large cap stocks
                        \t\t20 % Small Cap
                        \t\t25% International
                        \t\t5% Cash
                        """;

            } else{
                System.out.println("Error");
            }

            return "Emergency Fund (3 - 6 months of expenses) in High Yield Savings Account\n" +
                    "\tThis would equal ~ $"+minEmergencyFund+"- $"+maxEmergencyFund+"\n" +
                    "\tCIT bank offers a High-Yield Savings Account offering variable 4.10% Annual Percentage Yield with a minimum $5,000 balance, but interest may change at any time\n" +
                    "Retirement Plan (5%)\n" +
                    "\tChoose Roth 401k if given the option for company plan\n" +
                    "\t5% of income to match company benefits = "+retirementPlan+" per year\n" +
                    "\tFunds to consider in Roth IRA for "+rothFunds+"\n" +
                    "Brokerage Account (10% of income)\n" +
                    "\t10% of income = "+brokerageAccount+" per year\n" +
                    "\tPortfolio Breakdown\n" + portfolioBreakdown;

        }
    }