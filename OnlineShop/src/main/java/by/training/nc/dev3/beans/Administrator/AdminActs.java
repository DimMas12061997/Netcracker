package by.training.nc.dev3.beans.Administrator;

import by.training.nc.dev3.beans.Good;
import by.training.nc.dev3.beans.OnlineShop;
import by.training.nc.dev3.beans.Order;
import by.training.nc.dev3.tools.Operations;

import java.util.Iterator;

/**
 * Created by Дмитрий on 20.03.2017.
 */
public class AdminActs {

    public void addGood() {
        OnlineShop.good.add(new Good(Operations.inputString(), Operations.inputNumber(), Operations.inputNumber()));   //параметризация
    }

    public void removeGood() {
        int flag = 0;
        if (checkSise() == false) {
            String name = Operations.inputString();
            for (Iterator<Good> it = OnlineShop.good.iterator(); it.hasNext(); ) {
                Good good = it.next();
                if (name.equals(good.getName())) {
                    flag++;
                    int number = Operations.inputNumber();
                    if (number == good.getNumber())
                        it.remove();
                    else if (number <= good.getNumber())
                        good.setNumber(good.getNumber() - number);
                    else
                        System.out.println("Проблемка с размером");
                }
            }
            if (flag == 0)
                System.out.println("Такого имени нет");
        } else
            System.out.println("Товара нет");
    }

    public boolean checkSise() {
        if (OnlineShop.good.size() == 0)
            return true;
        else
            return false;
    }


    public void viewGoods() {
        if (checkSise() == false)
            for (Good good : OnlineShop.good)
                System.out.println(good);
        else
            System.out.println("Товара нет");
    }

    public void removeAllGoods() {
        OnlineShop.good.removeAll(OnlineShop.good);
    }

    public void checkOrder() {
    }


    public boolean checkSiseOrder() {
        if (Order.good.size() == 0)
            return true;
        else
            return false;
    }


    public void viewOrder() {
        if (checkSiseOrder() == false)
            for (Good good : Order.good)
                System.out.println(good);
        else
            System.out.println("Товара нет");
    }
}
