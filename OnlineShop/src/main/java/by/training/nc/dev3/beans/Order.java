package by.training.nc.dev3.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Дмитрий on 18.03.2017.
 */
public class Order {
    public static List<Good> good = new ArrayList<>();
    private double orderCost;
    //    private Date date;
    public static Boolean payment = false;

    Order() {
    }
}
