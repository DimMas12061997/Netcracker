package by.training.nc.dev3.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order implements Serializable {
    private static List<Goods> good = new ArrayList<>();
    private static Map<Customer, List<Goods>> map = new HashMap<>();
    private static double orderCost;
    private static Boolean payment = false;

    public Order() {
    }

    public static List<Goods> getGood() {
        return good;
    }

    public static void setGood(List<Goods> good) {
        Order.good = good;
    }

    public static Map<Customer, List<Goods>> getMap() {
        return map;
    }

    public static void setMap(Map<Customer, List<Goods>> map) {
        Order.map = map;
    }

    public static double getOrderCost() {
        return orderCost;
    }

    public static void setOrderCost(double orderCost) {
        Order.orderCost = orderCost;
    }

    public static Boolean getPayment() {
        return payment;
    }

    public static void setPayment(Boolean payment) {
        Order.payment = payment;
    }
}
