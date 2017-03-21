package by.training.nc.dev3.service;

import by.training.nc.dev3.beans.Customer;
import by.training.nc.dev3.beans.Good;
import by.training.nc.dev3.beans.OnlineShop;
import by.training.nc.dev3.beans.Order;
import by.training.nc.dev3.exceptions.MyException;
import by.training.nc.dev3.tools.FileWorker;
import by.training.nc.dev3.tools.Operations;

import java.io.File;
import java.io.Serializable;
import java.util.*;

public class CustomerActs implements Serializable {
    public static Customer customer;

    public CustomerActs() {
    }

    public CustomerActs(Customer customer) {
        this.customer = customer;
    }

    public void addGoodOrder() throws MyException {
        FileWorker sz = new FileWorker();
        List<Customer> res = sz.readListCustomers(FileWorker.filePath + "blackList.txt");
        for(Customer cus : res)
        if(cus.equals(customer) == false) {
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
        else
            System.out.println("Вы в черном списке");
    }

    public List<Good> checkMapOrder(List<Good> list) {
        for (Good g : list)
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

    public void payOrder() throws MyException {
        FileWorker sz = new FileWorker();
        Order.map = FileWorker.readOrder(FileWorker.filePath + "Order.txt");
        System.out.println("Бюджет покупателя: " + customer.getBudget());
        System.out.println("Корзина покупателя: " + Order.getOrderCost());
        Order.setPayment(true);
        if (Order.map.isEmpty() == false)
            if (Order.getOrderCost() != 0)
                if (customer.getBudget() >= Order.getOrderCost()) {
                    double x = customer.getBudget() - Order.getOrderCost();
                    customer.setBudget(x);
                    sz.serialization(customer, FileWorker.filePath + "customers.txt");
                    OnlineShop.setProfit(Order.getOrderCost());
                    writeProfitOnlineShop(OnlineShop.getProfit());
                    Order.map.clear();
                    FileWorker.writeOrder(Order.map, new File(FileWorker.filePath + "Order.txt"));
                    String str = "Покупатель: " + customer.getName() + " " + customer.getSurname() + " " + ", Стоимость заказа = " + Order.getOrderCost() + ", Оставшийся бюджет: " + customer.getBudget();
                    FileWorker.writeByteFile(str, new File(FileWorker.filePath + "InfoOrder.txt"));
                } else {
                    List<Customer> list = sz.readListCustomers(FileWorker.filePath + "non-payers.txt");
                    list.add(customer);
                    sz.writeListCustomers(list, new File(FileWorker.filePath + "non-payers.txt"));
                }
    }

    public void writeProfitOnlineShop(double profit) {
        double str = FileWorker.readFile(new File(FileWorker.filePath + "ProfitOnlineShop.txt"));
        str += profit;
        FileWorker.write(str, new File(FileWorker.filePath + "ProfitOnlineShop.txt"));

    }

    public void viewGoodsOrder() {
        double cost = 0;
        for (Map.Entry<Customer, List<Good>> entry : FileWorker.readOrder(FileWorker.filePath + "Order.txt").entrySet()) {
            if (customer.equals(entry.getKey())) {
                System.out.println("===========================");
                System.out.println("Клиент " + entry.getKey());
                System.out.println("Заказ " + entry.getValue());
                System.out.println("===========================");
                for (Good good : entry.getValue()) {
                    cost += good.getNumber() * good.getUnitPrice();
                }
            }
        }
        Order.setOrderCost(cost);
        System.out.println("Стоимость корзины: " + Order.getOrderCost());
        viewDate();
    }

    public void viewDate() {
        String months[] = {"Января", "Феввраля", "Марта", "Апреля", "Мая", "Июня", "Июля", "Августа", "Сентября",
                "Октября", "Ноября", "Декабря"};
        GregorianCalendar gcalendar = new GregorianCalendar();
        System.out.print("Дата: ");
        System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
        System.out.print(months[gcalendar.get(Calendar.MONTH)]);
        System.out.println(" " + gcalendar.get(Calendar.YEAR));
        System.out.print("Время: ");
        System.out.print(gcalendar.get(Calendar.HOUR) + ":");
        System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
        System.out.println(gcalendar.get(Calendar.SECOND));
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
