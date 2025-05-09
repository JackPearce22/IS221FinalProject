import java.util.HashMap;
import java.util.Map;


public class AllocationData {
    String rothFunds;
    String portfolioBreakdown;

    /**
     * Splits up different allocation types into a map to print the result in Main
     * @param rothFunds
     * @param portfolioBreakdown
     */
    AllocationData(String rothFunds, String portfolioBreakdown) {
        this.rothFunds = rothFunds;
        this.portfolioBreakdown = portfolioBreakdown;
    }


    private static final Map<String, AllocationData> allocationMap = new HashMap<>();

    static {
        allocationMap.put("Conservative", new AllocationData(
                "conservative growth (WBALX, VWINX, FXNAX)",
                "\t\t10% Large cap stocks\n" +
                        "\t\t15% Small Cap\n" +
                        "\t\t15% International\n" +
                        "\t\t50% Fixed Income\n" +
                        "\t\t10% Cash\n"
        ));
        allocationMap.put("Moderately Conservative", new AllocationData(
                "moderately conservative growth (VWINX, FXNAX, VFSTX)",
                "\t\t15% Large cap stocks\n" +
                        "\t\t20% Small Cap\n" +
                        "\t\t20% International\n" +
                        "\t\t35% Fixed Income\n" +
                        "\t\t10% Cash\n"
        ));
        allocationMap.put("Moderate Allocation", new AllocationData(
                "moderate allocation growth (FSKAX, VBIAX, FXNAX, VOO)",
                "\t\t10% Large cap stocks\n" +
                        "\t\t15% Small Cap\n" +
                        "\t\t15% International\n" +
                        "\t\t50% Fixed Income\n" +
                        "\t\t10% Cash\n"
        ));
        allocationMap.put("Moderately Aggressive", new AllocationData(
                "moderately aggressive growth (VTI, FTIHX, VOO, QQQ)",
                "\t\t50% Large cap stocks\n" +
                        "\t\t20% Small Cap\n" +
                        "\t\t25% International\n" +
                        "\t\t5% Cash\n"
        ));
        allocationMap.put("Aggressive", new AllocationData(
                "aggressive growth (VOO, QQQ, QQQM)",
                "\t\t50% Large cap stocks\n" +
                        "\t\t20% Small Cap\n" +
                        "\t\t25% International\n" +
                        "\t\t5% Cash\n"
        ));
    }

    public static String printResult(long annualIncome, double monthlyExpenses, String allocationType) {
        double minEmergencyFund = monthlyExpenses * 3;
        double maxEmergencyFund = monthlyExpenses * 6;

        double retirementPlan = annualIncome * 0.05;
        double brokerageAccount = annualIncome * 0.10;

        AllocationData data = allocationMap.get(allocationType);
        if (data == null) {
            return "Error: Invalid allocation type.";
        }

        return "Emergency Fund (3 - 6 months of expenses) in High Yield Savings Account\n" +
                "\tThis would equal ~ $" + minEmergencyFund + " - $" + maxEmergencyFund + "\n" +
                "\tCIT bank offers a High-Yield Savings Account offering variable 4.10% APY with a minimum $5,000 balance, but interest may change at any time\n" +
                "Retirement Plan (5%)\n" +
                "\tChoose Roth 401k if given the option for company plan\n" +
                "\t5% of income to match company benefits = $" + retirementPlan + " per year\n" +
                "\tFunds to consider in Roth IRA for " + data.rothFunds + "\n" +
                "Brokerage Account (10% of income)\n" +
                "\t10% of income = $" + brokerageAccount + " per year\n" +
                "\tPortfolio Breakdown\n" + data.portfolioBreakdown;
    }
}

