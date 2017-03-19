package by.training.nc.dev3.beans.Customer;

import by.training.nc.dev3.beans.Good;
import by.training.nc.dev3.beans.OnlineShop;
import by.training.nc.dev3.beans.Order;
import by.training.nc.dev3.tools.Operations;

import java.util.Iterator;

/**
 * Created by Дмитрий on 20.03.2017.
 */
public class CustomerActs {
    public void addGoodOrder() {
        int flag = 0;
        if (checkSize() == false) {
            String name = Operations.inputString();
            for (Good product : OnlineShop.good)
                if (name.equals(product.getName())) {
                    flag++;
                    int number = Operations.inputNumber();
                    if (number <= product.getNumber()) {
                        product.setNumber(product.getNumber() - number);
                        Order.good.add(new Good(name,number,product.getUnitPrice()));
                    }
                    else
                        System.out.println("Сгенерить exception2");
                }
            if (flag == 0)
                System.out.println("Такого имени нет");
        } else
            System.out.println("Товара нет");
    }

    public void removeGoodOrder() {
        int flag = 0;
        if (checkSizeOrder() == false) {
            String name = Operations.inputString();
            for (Iterator<Good> it = Order.good.iterator(); it.hasNext(); ) {
                Good basket = it.next();
                if (name.equals(basket.getName())) {
                    int number = Operations.inputNumber();
                    if (number == basket.getNumber())
                        it.remove();
                    else if (number <= basket.getNumber())
                        basket.setNumber(basket.getNumber() - number);
                    else
                        System.out.println("Проблемка с размером");
                }
            }
            if (flag == 0)
                System.out.println("Такого имени нет");
        } else
            System.out.println("Товара нет");
    }

    public boolean checkSizeOrder() {
        if (Order.good.size() == 0)
            return true;
        else
            return false;
    }

    public void payOrder() {

    }

    public void viewGoodsOrder() {
        if (checkSizeOrder() == false)
            for (Good good : Order.good)
                System.out.println(good);
        else
            System.out.println("Товара нет");
    }

    public void removeAllGoodsOrder() {
        Order.good.removeAll(Order.good);
    }

    public boolean checkSize() {
        if (OnlineShop.good.size() == 0)
            return true;
        else
            return false;
    }

    public void viewGoods() {
        if (checkSize() == false)
            for (Good good : OnlineShop.good)
                System.out.println(good);
        else
            System.out.println("Товара нет");
    }
}
