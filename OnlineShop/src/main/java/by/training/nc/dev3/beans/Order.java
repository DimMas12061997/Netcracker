package by.training.nc.dev3.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Дмитрий on 18.03.2017.
 */
public class Order {
    public static List<Good> good = new ArrayList<>();
    private static double orderCost;
    //    private Date date;
    public static Boolean payment = false;

    public Order() {
    }

    public static List<Good> getGood() {
        return good;
    }

    public static void setGood(List<Good> good) {
        Order.good = good;
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
