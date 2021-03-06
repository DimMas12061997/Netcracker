package by.training.nc.dev3.beans;

import java.util.ArrayList;
import java.util.List;

public final class OnlineShop {
    private final static String name = "SPORTIX";
    private static List<Goods> goodList = new ArrayList<>();
    private static double profit;

    private OnlineShop() {
    }

    public static String getName() {
        return name;
    }

    public static List<Goods> getGoodList() {
        return goodList;
    }

    public static void setGoodList(List<Goods> good) {
        OnlineShop.goodList = good;
    }

    public static double getProfit() {
        return profit;
    }

    public static void setProfit(double profit) {
        OnlineShop.profit = profit;
    }
}
