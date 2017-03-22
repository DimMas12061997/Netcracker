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

    public int checkBlackList() {
        int k = 0;
        FileWorker sz = new FileWorker();
        List<Customer> res = (List<Customer>) sz.readObject(FileWorker.filePath + "blackList.txt");
        if (res.size() != 0)
            for (Customer cus : res)
                if (cus.equals(customer))
                    k++;
        return k;
    }

    public void addGoodOrder() throws MyException {
        int k = checkBlackList();
        if (k == 0) {
            int flag = 0;
            OnlineShop.good = (List<Good>) FileWorker.readObject(FileWorker.filePath + "OnlineShop.txt");
            String name = Operations.inputString();
            Order.map = FileWorker.readOrder(FileWorker.filePath + "Order.txt");
            for (Iterator<Good> it = OnlineShop.good.iterator(); it.hasNext(); ) {
                Good product = it.next();
                if (name.equals(product.getName())) {
                    flag++;
                    int number = Operations.inputNumber();
                    if (number <= product.getNumber()) {
                        product.setNumber(product.getNumber() - number);
                        if (product.getNumber() == 0)
                            it.remove();
                        checkCustomer(name, number, product);
                        FileWorker.writeObject(OnlineShop.good, new File(FileWorker.filePath + "OnlineShop.txt"));
                        break;
                    } else
                        throw new MyException("Товара в таком количестве нет");
                }
            }
            if (flag == 0)
                throw new MyException("Товара с таким названием нет");
        } else
            throw new MyException("Вы в черном списке");
    }

    public List<Good> checkMapOrder(List<Good> list, Good good) {
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(good.getName())) {
                list.get(i).setNumber(good.getNumber() + list.get(i).getNumber());
                flag++;
                break;
            }
        }
        if (flag == 0)
            list.add(good);
        return list;
    }

    public void checkCustomer(String name, int number, Good product) {
        int g = 0;
        List<Good> list = new ArrayList<>();
        for (Map.Entry<Customer, List<Good>> entry : Order.map.entrySet()) {
            if (customer.equals(entry.getKey())) {
                list = entry.getValue();
                Order.map.put(customer, checkMapOrder(list, new Good(name, number, product.getUnitPrice())));
                g++;
            }
        }
        if (g == 0) {
            Order.good.removeAll(Order.good);
            Order.map.put(customer, checkMapOrder(list, new Good(name, number, product.getUnitPrice())));
        }
        FileWorker.writeOrder(Order.map, new File(FileWorker.filePath + "Order.txt"));
    }

    public void delGood(String name, Good basket) {
        OnlineShop.good = (List<Good>) FileWorker.readObject(FileWorker.filePath + "OnlineShop.txt");
        for (Iterator<Good> it = OnlineShop.good.iterator(); it.hasNext(); ) {
            Good good = it.next();
            if (name.equals(good.getName())) {
                good.setNumber(good.getNumber() + basket.getNumber());
                FileWorker.writeObject(OnlineShop.good, new File(FileWorker.filePath + "OnlineShop.txt"));
            }
        }
    }

    public void removeGoodOrder() throws MyException {
        int flag = 0;
        Order.map = FileWorker.readOrder(FileWorker.filePath + "Order.txt");
        for (Map.Entry<Customer, List<Good>> entry : Order.map.entrySet()) {
            if (customer.equals(entry.getKey())) {
                String name = Operations.inputString();
                for (Good basket : entry.getValue()) {
                    if (name.equals(basket.getName())) {
                        flag++;
                        int number = Operations.inputNumber();
                        if (number == basket.getNumber()) {
                            entry.getValue().remove(basket);
                            Order.map.put(entry.getKey(), entry.getValue());
                            FileWorker.writeOrder(Order.map, new File(FileWorker.filePath + "Order.txt"));
                            delGood(name, basket);
                        } else if (number < basket.getNumber()) {
                            basket.setNumber(basket.getNumber() - number);
                            FileWorker.writeOrder(Order.map, new File(FileWorker.filePath + "Order.txt"));
                            delGood(name, basket);
                        } else
                            throw new MyException("В заказе нет столько товара");
                        break;
                    }
                }
            }
        }
        if (flag == 0)
            throw new MyException("Товара с таким названием в вашей корзине нет");
    }

    public void payOrder() throws MyException {
        int flag = 0;
        FileWorker sz = new FileWorker();
        Order.map = FileWorker.readOrder(FileWorker.filePath + "Order.txt");
        System.out.println("Бюджет покупателя: " + customer.getBudget());
        System.out.println("Корзина покупателя: " + Order.getOrderCost());
        Order.setPayment(true);
        List<Customer> list = (List<Customer>) sz.readObject(FileWorker.filePath + "non-payers.txt");
        if (Order.map.isEmpty() == false)
            if (Order.getOrderCost() != 0)
                if (customer.getBudget() >= Order.getOrderCost()) {
                    for (int i = 0; i < list.size(); i++)
                        if (customer.equals(list.get(i)))
                            list.remove(list.get(i));
                    sz.writeObject(list, new File(FileWorker.filePath + "non-payers.txt"));
                    double x = customer.getBudget() - Order.getOrderCost();
                    customer.setBudget(x);
                    sz.serialization(customer, FileWorker.filePath + "customers.txt");
                    OnlineShop.setProfit(Order.getOrderCost());
                    writeProfitOnlineShop(OnlineShop.getProfit());
                    Order.map.clear();
                    FileWorker.writeOrder(Order.map, new File(FileWorker.filePath + "Order.txt"));
                    String str = "Покупатель: " + customer.getName() + " " + customer.getSurname() + " " + ", Стоимость заказа = " + Order.getOrderCost() + ", Оставшийся бюджет: " + customer.getBudget() + "\n";
                    FileWorker.writeByteFile(str, new File(FileWorker.filePath + "InfoOrder.txt"));
                } else {
                    for (Customer man : list)
                        if (customer.equals(man))
                            flag++;
                    if (flag == 0) {
                        list.add(customer);
                        sz.writeObject(list, new File(FileWorker.filePath + "non-payers.txt"));
                    }
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
        System.out.println("Если ваш заказ превышает ваш бюджет и вы попытаетесь оплатить заказ, вы будете считаться неплательщиком");
        System.out.println("Стоимость корзины: " + Order.getOrderCost());
        System.out.println("Ваш бюдджет: " + customer.getBudget());
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

    public void addGoodsFromOrder(List<Good> list) {
        OnlineShop.good = (List<Good>) FileWorker.readObject(FileWorker.filePath + "OnlineShop.txt");
        for (int i = 0; i < OnlineShop.good.size(); i++) {
            for (Good product : list) {
                if (product.getName().equals(OnlineShop.good.get(i).getName())) {
                    OnlineShop.good.get(i).setNumber(OnlineShop.good.get(i).getNumber() + product.getNumber());
                }
            }
        }
        FileWorker.writeObject(OnlineShop.good, new File(FileWorker.filePath + "OnlineShop.txt"));
    }

    public void removeAllGoodsOrder() {
        Order.map = FileWorker.readOrder(FileWorker.filePath + "Order.txt");
        for (Map.Entry<Customer, List<Good>> entry : Order.map.entrySet()) {
            if (customer.equals(entry.getKey())) {
                if (entry.getValue().size() != 0)
                    addGoodsFromOrder(entry.getValue());
                Order.good.removeAll(Order.good);
                Order.map.put(entry.getKey(), Order.good);
                FileWorker.writeOrder(Order.map, new File(FileWorker.filePath + "Order.txt"));
                break;
            }
        }
    }

    public void viewGoods() {
        OnlineShop.good = (List<Good>) FileWorker.readObject(FileWorker.filePath + "OnlineShop.txt");
        for (Good ob : OnlineShop.good)
            System.out.println(ob);
    }
}
