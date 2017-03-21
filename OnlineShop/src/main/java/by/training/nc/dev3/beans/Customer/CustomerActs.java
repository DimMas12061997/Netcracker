package by.training.nc.dev3.beans.Customer;

import by.training.nc.dev3.beans.Good;
import by.training.nc.dev3.beans.OnlineShop;
import by.training.nc.dev3.beans.Order;
import by.training.nc.dev3.exceptions.MyException;
import by.training.nc.dev3.tools.FileWorker;
import by.training.nc.dev3.tools.Operations;

import java.io.File;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CustomerActs implements Serializable {
    //private Order order = new Order();
    public static Customer customer;

    public CustomerActs() {
    }

    public CustomerActs(Customer customer) {
        this.customer = customer;
    }

    public void addGoodOrder() throws MyException {
        int flag = 0;
        OnlineShop.good = FileWorker.readObject(FileWorker.filePath + "OnlineShop.txt");
        String name = Operations.inputString();
        for (Iterator<Good> it = OnlineShop.good.iterator(); it.hasNext(); ) {
            Good product = it.next();
            if (name.equals(product.getName())) {
                flag++;
                int number = Operations.inputNumber();
                if (number <= product.getNumber()) {
                    product.setNumber(product.getNumber() - number);
                    if (product.getNumber() == 0)
                        it.remove();
                    Order.good.add(new Good(name, number, product.getUnitPrice()));
                    Order.map.put(customer, Order.good);
                    FileWorker.writeOrder(Order.map, new File(FileWorker.filePath + "Order.txt"));
                    FileWorker.writeObject(OnlineShop.good, new File(FileWorker.filePath + "OnlineShop.txt"));
                } else
                throw new MyException("Товара в таком количестве нет");
            }
        }
        if (flag == 0)
            throw new MyException("Товара с таким названием нет");
    }

    public List<Good> checkMapOrder(List<Good> list) {
        for(Good g : list)
            System.out.println(list);
        for (Map.Entry<Customer, List<Good>> entry : FileWorker.readOrder(FileWorker.filePath + "Order.txt").entrySet())
            for (int i = 0; i < list.size(); i++) {
                for (Good product : entry.getValue())
                    if (product.getName().equals(list.get(i).getName())) {
                        list.get(i).setNumber(list.get(i).getNumber() + product.getNumber());
                    }
            }
        return list;
    }

    public void delGood(String name, Good basket) {
        for (Iterator<Good> it = OnlineShop.good.iterator(); it.hasNext(); ) {
            Good good = it.next();
            if (name.equals(good.getName())) {
                good.setNumber(good.getNumber() + basket.getNumber());
                FileWorker.writeObject(OnlineShop.good, new File(FileWorker.filePath + "OnlineShop.txt"));
            }
        }
    }

    public void removeGoodOrder() throws MyException {    //работает
        int flag = 0;
        Order.map = FileWorker.readOrder(FileWorker.filePath + "Order.txt");
        for (Map.Entry<Customer, List<Good>> entry : Order.map.entrySet()) {
            System.out.println("===========================");
            System.out.println("Клиент " + entry.getKey());
            System.out.println("Заказ " + entry.getValue());
            System.out.println("===========================");
        }
        String name = Operations.inputString();
        for (Map.Entry<Customer, List<Good>> entry : Order.map.entrySet()) {
            for (Good basket : entry.getValue()) {
                if (name.equals(basket.getName())) {
                    flag++;
                    int number = Operations.inputNumber();
                    if (number == basket.getNumber()) {
                        Order.good.remove(Order.good);
                        Order.map.put(entry.getKey(), Order.good);
                        FileWorker.writeOrder(Order.map, new File(FileWorker.filePath + "Order.txt"));
                        delGood(name, basket);
                    } else if (number < basket.getNumber()) {
                        basket.setNumber(basket.getNumber() - number);
                        FileWorker.writeOrder(Order.map, new File(FileWorker.filePath + "Order.txt"));
                        delGood(name, basket);
                    } else
                        throw new MyException("В заказе нет столько товара");
                }
            }
        }
        if (flag == 0)
            throw new MyException("Товара с таким названием нет");
    }

    public void payOrder() {
        System.out.println("Бюджет покупателя: " + customer.getBudget());
        System.out.println("Корхина покупателя: " + Order.getOrderCost());
        Order.setPayment(true);
        if (customer.getBudget() >= Order.getOrderCost()) {
            System.out.println("бюджета хватает");
            double x = customer.getBudget() - Order.getOrderCost();
            customer.setBudget(x);
            OnlineShop.setProfit(Order.getOrderCost());
            System.out.println("Оствшийся бюджет: " + customer.getBudget());
        } else
            System.out.println("бюджета не хватает");
    }

    public void viewGoodsOrder() {
        double cost = 0;
        for (Map.Entry<Customer, List<Good>> entry : FileWorker.readOrder(FileWorker.filePath + "Order.txt").entrySet()) {
            System.out.println("===========================");
            System.out.println("Клиент " + entry.getKey());
            System.out.println("Заказ " + entry.getValue());
            System.out.println("===========================");
            for (Good good : entry.getValue()) {
                cost += good.getNumber() * good.getUnitPrice();
            }
        }
        Order.setOrderCost(cost);
        System.out.println("Стоимость корзины: " + Order.getOrderCost());
    }

    public void removeAllGoodsOrder() {   //исправить
        Order.map = FileWorker.readOrder(FileWorker.filePath + "Order.txt");
        for (Map.Entry<Customer, List<Good>> entry : Order.map.entrySet())
            for (Good basket : entry.getValue()) {
                Order.good.removeAll(Order.good);
                Order.map.put(entry.getKey(), Order.good);
                FileWorker.writeOrder(Order.map, new File(FileWorker.filePath + "Order.txt"));
                for (Iterator<Good> it = OnlineShop.good.iterator(); it.hasNext(); ) {
                    Good good = it.next();
                    good.setNumber(good.getNumber() + basket.getNumber());
                    FileWorker.writeObject(OnlineShop.good, new File(FileWorker.filePath + "OnlineShop.txt"));
                }
            }
    }

    public void viewGoods() {
        OnlineShop.good = FileWorker.readObject(FileWorker.filePath + "OnlineShop.txt");
        for (Good ob : OnlineShop.good)
            System.out.println(ob);
    }
}
