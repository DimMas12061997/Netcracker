package by.training.nc.dev3.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order implements Serializable {
    public static List<Good> good = new ArrayList<>();
    public static Map<Customer, List<Good>> map = new HashMap<>();
    private static double orderCost;
    public static Boolean payment = false;

    public Order() {
    }

    public static Map<Customer, List<Good>> getMap() {
        return map;
    }

    public static void setMap(Map<Customer, List<Good>> map) {
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
