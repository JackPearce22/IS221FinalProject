import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
//test
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
            double timeHorizon = scan.nextDouble();

            int timeScore = calcTimeScore(timeHorizon);
        System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "        _____\n" +
                "     _.'_____`._\n" +
                "   .'.-'  12 `-.`.\n" +
                "  /,' 11      1 `.\\\n" +
                " // 10      /   2 \\\\\n" +
                ";;         /       ::\n" +
                "|| 9  ----O      3 ||\n" +
                "::                 ;;\n" +
                " \\\\ 8           4 //\n" +
                "  \\`. 7       5 ,'/\n" +
                "   '.`-.__6__.-'.'\n" +
                "    ((-._____.-))\n" +
                "    _))       ((_\n" +
                "   '--'       '--'\n");
            System.out.println("Your time score is: " + timeScore);
            scan.nextLine();

            System.out.print("Please provide your monthly expenses: ");
            double monthlyExpenses = scan.nextDouble();

            String allocationType = calcAllocation(riskScore, timeScore);

            String result = printResult(annualIncome,monthlyExpenses, allocationType);
            System.out.print(result);
            System.out.print("Disclaimer: This tool is for informational purposes only and does not constitute financial, investment, or tax advice. Please consult a licensed financial advisor or tax professional before making any financial decisions. ");

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
            String[] args = {};
            main(args);
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
                String[] args = {};
                main(args);
                return 0;
            }
        }

    /**
     * This method estimates a tax bracket percentage based on income and filing status
     * @param annualIncome
     * @param filingStatus
     */

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
                String[] args = {};
                main(args);
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
                System.out.println("Recommended Allocation:\n" +
                        "   /$$$$$$                                                                           /$$     /$$                     \n" +
                        " /$$__  $$                                                                         | $$                         \n" +
                        "| $$  \\__/  /$$$$$$  /$$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$  /$$    /$$  /$$$$$$  /$$$$$$   /$$ /$$    /$$  /$$$$$$ \n" +
                        "| $$       /$$__  $$| $$__  $$ /$$_____/ /$$__  $$ /$$__  $$|  $$  /$$/ |____  $$|_  $$_/  | $$|  $$  /$$/ /$$__  $$\n" +
                        "| $$      | $$  \\ $$| $$  \\ $$|  $$$$$$ | $$$$$$$$| $$  \\__/ \\  $$/$$/   /$$$$$$$  | $$    | $$ \\  $$/$$/ | $$$$$$$$\n" +
                        "| $$    $$| $$  | $$| $$  | $$ \\____  $$| $$_____/| $$        \\  $$$/   /$$__  $$  | $$ /$$| $$  \\  $$$/  | $$_____/\n" +
                        "|  $$$$$$/|  $$$$$$/| $$  | $$ /$$$$$$$/|  $$$$$$$| $$         \\  $/   |  $$$$$$$  |  $$$$/| $$   \\  $/   |  $$$$$$$\n" +
                        " \\______/  \\______/ |__/  |__/|_______/  \\_______/|__/          \\_/     \\_______/   \\___/  |__/    \\_/     \\_______/\n" +
                        "                                                                                                                    ");
                return "Conservative";
            } else if (allocationScore >= 2475 && allocationScore <= 2500) {
                System.out.println("Recommended Allocation:\n" +
                        "  /$$      /$$                 /$$                                 /$$               /$$                  /$$$$$$                                                                           /$$     /$$                     \n" +
                        "| $$$    /$$$                | $$                                | $$              | $$                 /$$__  $$                                                                         | $$                         \n" +
                        "| $$$$  /$$$$  /$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$    /$$$$$$ | $$ /$$   /$$      | $$  \\__/  /$$$$$$  /$$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$  /$$    /$$  /$$$$$$  /$$$$$$   /$$ /$$    /$$  /$$$$$$ \n" +
                        "| $$ $$/$$ $$ /$$__  $$ /$$__  $$ /$$__  $$ /$$__  $$ |____  $$|_  $$_/   /$$__  $$| $$| $$  | $$      | $$       /$$__  $$| $$__  $$ /$$_____/ /$$__  $$ /$$__  $$|  $$  /$$/ |____  $$|_  $$_/  | $$|  $$  /$$/ /$$__  $$\n" +
                        "| $$  $$$| $$| $$  \\ $$| $$  | $$| $$$$$$$$| $$  \\__/  /$$$$$$$  | $$    | $$$$$$$$| $$| $$  | $$      | $$      | $$  \\ $$| $$  \\ $$|  $$$$$$ | $$$$$$$$| $$  \\__/ \\  $$/$$/   /$$$$$$$  | $$    | $$ \\  $$/$$/ | $$$$$$$$\n" +
                        "| $$\\  $ | $$| $$  | $$| $$  | $$| $$_____/| $$       /$$__  $$  | $$ /$$| $$_____/| $$| $$  | $$      | $$    $$| $$  | $$| $$  | $$ \\____  $$| $$_____/| $$        \\  $$$/   /$$__  $$  | $$ /$$| $$  \\  $$$/  | $$_____/\n" +
                        "| $$ \\/  | $$|  $$$$$$/|  $$$$$$$|  $$$$$$$| $$      |  $$$$$$$  |  $$$$/|  $$$$$$$| $$|  $$$$$$$      |  $$$$$$/|  $$$$$$/| $$  | $$ /$$$$$$$/|  $$$$$$$| $$         \\  $/   |  $$$$$$$  |  $$$$/| $$   \\  $/   |  $$$$$$$\n" +
                        "|__/     |__/ \\______/  \\_______/ \\_______/|__/       \\_______/   \\___/   \\_______/|__/ \\____  $$       \\______/  \\______/ |__/  |__/|_______/  \\_______/|__/          \\_/     \\_______/   \\___/  |__/    \\_/     \\_______/\n" +
                        "                                                                                        /$$  | $$                                                                                                                          \n" +
                        "                                                                                       |  $$$$$$/                                                                                                                          \n" +
                        "                                                                                        \\______/                                                                                                                           \n" +
                        "                                                                                                                                                                                                                           ");
                return "Moderately Conservative";
            } else if (allocationScore >= 3300 && allocationScore <= 5000) {
                System.out.println("Recommended Allocation:\n" +
                        " /$$      /$$                 /$$                                 /$$                      /$$$$$$  /$$ /$$                                 /$$     /$$                    \n" +
                        "| $$$    /$$$                | $$                                | $$                     /$$__  $$| $$| $$                                | $$                        \n" +
                        "| $$$$  /$$$$  /$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$    /$$$$$$       | $$  \\ $$| $$| $$  /$$$$$$   /$$$$$$$  /$$$$$$  /$$$$$$   /$$  /$$$$$$  /$$$$$$$ \n" +
                        "| $$ $$/$$ $$ /$$__  $$ /$$__  $$ /$$__  $$ /$$__  $$ |____  $$|_  $$_/   /$$__  $$      | $$$$$$$$| $$| $$ /$$__  $$ /$$_____/ |____  $$|_  $$_/  | $$ /$$__  $$| $$__  $$\n" +
                        "| $$  $$$| $$| $$  \\ $$| $$  | $$| $$$$$$$$| $$  \\__/  /$$$$$$$  | $$    | $$$$$$$$      | $$__  $$| $$| $$| $$  \\ $$| $$        /$$$$$$$  | $$    | $$| $$  \\ $$| $$  \\ $$\n" +
                        "| $$\\  $ | $$| $$  | $$| $$  | $$| $$_____/| $$       /$$__  $$  | $$ /$$| $$_____/      | $$  | $$| $$| $$| $$  | $$| $$       /$$__  $$  | $$ /$$| $$| $$  | $$| $$  | $$\n" +
                        "| $$ \\/  | $$|  $$$$$$/|  $$$$$$$|  $$$$$$$| $$      |  $$$$$$$  |  $$$$/|  $$$$$$$      | $$  | $$| $$| $$|  $$$$$$/|  $$$$$$$|  $$$$$$$  |  $$$$/| $$|  $$$$$$/| $$  | $$\n" +
                        "|__/     |__/ \\______/  \\_______/ \\_______/|__/       \\_______/   \\___/   \\_______/      |__/  |__/|__/|__/ \\______/  \\_______/ \\_______/   \\___/  |__/ \\______/ |__/  |__/\n" +
                        "                                                                                                                                                                           \n" +
                        "                                                                                                                                                                           ");
                return "Moderate Allocation";
            } else if (allocationScore >= 6600 && allocationScore <= 7500) {
                System.out.println("Recommended Allocation:\n" +
                        " /$$      /$$                 /$$                                 /$$               /$$                  /$$$$$$                                                              /$$                     \n" +
                        "| $$$    /$$$                | $$                                | $$              | $$                 /$$__  $$                                                                                 \n" +
                        "| $$$$  /$$$$  /$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$    /$$$$$$ | $$ /$$   /$$      | $$  \\ $$  /$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$$  /$$$$$$$ /$$ /$$    /$$  /$$$$$$ \n" +
                        "| $$ $$/$$ $$ /$$__  $$ /$$__  $$ /$$__  $$ /$$__  $$ |____  $$|_  $$_/   /$$__  $$| $$| $$  | $$      | $$$$$$$$ /$$__  $$ /$$__  $$ /$$__  $$ /$$__  $$ /$$_____/ /$$_____/| $$|  $$  /$$/ /$$__  $$\n" +
                        "| $$  $$$| $$| $$  \\ $$| $$  | $$| $$$$$$$$| $$  \\__/  /$$$$$$$  | $$    | $$$$$$$$| $$| $$  | $$      | $$__  $$| $$  \\ $$| $$  \\ $$| $$  \\__/| $$$$$$$$|  $$$$$$ |  $$$$$$ | $$ \\  $$/$$/ | $$$$$$$$\n" +
                        "| $$\\  $ | $$| $$  | $$| $$  | $$| $$_____/| $$       /$$__  $$  | $$ /$$| $$_____/| $$| $$  | $$      | $$  | $$| $$  | $$| $$  | $$| $$      | $$_____/ \\____  $$ \\____  $$| $$  \\  $$$/  | $$_____/\n" +
                        "| $$ \\/  | $$|  $$$$$$/|  $$$$$$$|  $$$$$$$| $$      |  $$$$$$$  |  $$$$/|  $$$$$$$| $$|  $$$$$$$      | $$  | $$|  $$$$$$$|  $$$$$$$| $$      |  $$$$$$$ /$$$$$$$/ /$$$$$$$/| $$   \\  $/   |  $$$$$$$\n" +
                        "|__/     |__/ \\______/  \\_______/ \\_______/|__/       \\_______/   \\___/   \\_______/|__/ \\____  $$      |__/  |__/ \\____  $$ \\____  $$|__/       \\_______/|_______/ |_______/ |__/    \\_/     \\_______/\n" +
                        "                                                                                        /$$  | $$                 /$$  \\ $$ /$$  \\ $$                                                                 \n" +
                        "                                                                                       |  $$$$$$/                |  $$$$$$/|  $$$$$$/                                                                 \n" +
                        "                                                                                        \\______/                  \\______/  \\______/                                                                  ");
                return "Moderately Aggressive";
            } else if (allocationScore == 10000) {
                System.out.println("Recommended Allocation:\n" +
                        "   /$$$$$$                                                              /$$                     \n" +
                        " /$$__  $$                                                                                 \n" +
                        "| $$  \\ $$  /$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$$  /$$$$$$$ /$$ /$$    /$$  /$$$$$$ \n" +
                        "| $$$$$$$$ /$$__  $$ /$$__  $$ /$$__  $$ /$$__  $$ /$$_____/ /$$_____/| $$|  $$  /$$/ /$$__  $$\n" +
                        "| $$__  $$| $$  \\ $$| $$  \\ $$| $$  \\__/| $$$$$$$$|  $$$$$$ |  $$$$$$ | $$ \\  $$/$$/ | $$$$$$$$\n" +
                        "| $$  | $$| $$  | $$| $$  | $$| $$      | $$_____/ \\____  $$ \\____  $$| $$  \\  $$$/  | $$_____/\n" +
                        "| $$  | $$|  $$$$$$$|  $$$$$$$| $$      |  $$$$$$$ /$$$$$$$/ /$$$$$$$/| $$   \\  $/   |  $$$$$$$\n" +
                        "|__/  |__/ \\____  $$ \\____  $$|__/       \\_______/|_______/ |_______/ |__/    \\_/     \\_______/\n" +
                        "           /$$  \\ $$ /$$  \\ $$                                                                 \n" +
                        "          |  $$$$$$/|  $$$$$$/                                                                 \n" +
                        "           \\______/  \\______/                                                                  ");
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

            if (allocationType == "Conservative"){
                rothFunds += "conservative growth (WBALX, VWINX, FXNAX )";
                portfolioBreakdown += "\t\t10% Large cap stocks\n" +
                        "\t\t15 % Small Cap\n" +
                        "\t\t15% International\n" +
                        "\t\t50% Fixed Income\n" +
                        "\t\t10% Cash\n";
            } else if (allocationType == "Moderately Conservative") {
                rothFunds += "moderately conservative growth (VWINX, FXNAX, VFSTX )";
                portfolioBreakdown += "\t\t15% Large cap stocks\n" +
                        "\t\t20 % Small Cap\n" +
                        "\t\t20% International\n" +
                        "\t\t35% Fixed Income\n" +
                        "\t\t10% Cash\n";

            } else if (allocationType == "Moderate Allocation") {
                rothFunds += "moderate allocation growth (FSKAX, VBIAX, FXNAX, VOO)";
                portfolioBreakdown += "\t\t10% Large cap stocks\n" +
                        "\t\t15 % Small Cap\n" +
                        "\t\t15% International\n" +
                        "\t\t50% Fixed Income\n" +
                        "\t\t10% Cash\n";

            } else if (allocationType == "Moderately Aggressive") {
                rothFunds += "moderately aggressive growth (VTI, FTIHX, VOO, QQQ)";
                portfolioBreakdown += "\t\t50% Large cap stocks\n" +
                        "\t\t20% Small Cap\n" +
                        "\t\t25% International\n" +
                        "\t\t5% Cash\n";

            } else if (allocationType == "Aggressive") {
                rothFunds += "aggressive growth (VOO, QQQ, QQQM )";
                portfolioBreakdown += "\t\t50% Large cap stocks\n" +
                        "\t\t20 % Small Cap\n" +
                        "\t\t25% International\n" +
                        "\t\t5% Cash\n";

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