package by.training.nc.dev3.beans;

public final class OnlineShop {
    private final static String name = "sportix";
    private static double profit;

    private OnlineShop() {
    }

    public static String getName() {
        return name;
    }

    public static double getProfit() {
        return profit;
    }

    public static void setProfit(double profit) {
        OnlineShop.profit = profit;
    }
}
