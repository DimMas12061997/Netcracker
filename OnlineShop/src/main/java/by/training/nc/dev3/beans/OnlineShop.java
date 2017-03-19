package by.training.nc.dev3.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Дмитрий on 17.03.2017.
 */
public abstract class OnlineShop {
    private final static String name = "SPORTIX";
    public static List<Good> good = new ArrayList<>();
    private static double profit;

    public OnlineShop() {
    }

    public static String getName() {
        return name;
    }

    public static List<Good> getGood() {
        return good;
    }

    public static void setGood(List<Good> good) {
        OnlineShop.good = good;
    }

    public static double getProfit() {
        return profit;
    }

    public static void setProfit(double profit) {
        OnlineShop.profit = profit;
    }
}
