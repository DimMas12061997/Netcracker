package by.training.nc.dev3.service;

import by.training.nc.dev3.beans.*;
import by.training.nc.dev3.exceptions.MyException;
import by.training.nc.dev3.interfaces.CustomerActions;
import by.training.nc.dev3.tools.FileWorker;
import by.training.nc.dev3.tools.Operations;

import java.io.File;
import java.io.Serializable;
import java.util.*;

public class CustomerActs implements Serializable, CustomerActions {
    public static Customer customer;

    public CustomerActs() {
    }

    public CustomerActs(Customer customer) {
        this.customer = customer;
    }

    public int checkBlackList() {
        int k = 0;
        FileWorker sz = new FileWorker();
        List<Customer> res = (List<Customer>) sz.readObject(FileWorker.getFilePath() + "blackList.txt");
        if (res.size() != 0)
            for (Customer cus : res)
                if (cus.equals(customer))
                    k++;
        return k;
    }

    @Override
    public void addGoodOrder() throws MyException {
        int k = checkBlackList();
        if (k == 0) {
            int flag = 0;
            OnlineShop.setGoodList((List<Goods>) FileWorker.readObject(FileWorker.getFilePath() + "OnlineShop.txt"));
            System.out.println("Введите название товара");
            String name = Operations.inputString();
            System.out.println("Введите производителя товара");
            String producer = Operations.inputString();
            Order.setMap(FileWorker.readOrder(FileWorker.getFilePath() + "Order.txt"));
            for (Iterator<Goods> it = OnlineShop.getGoodList().iterator(); it.hasNext(); ) {
                Goods product = it.next();
                if (name.equals(product.getName()) && producer.equals(product.getProducer())) {
                    flag++;
                    System.out.println("Введите количество товара");
                    int number = Operations.inputNumber();
                    if (number <= product.getNumber()) {
                        product.setNumber(product.getNumber() - number);
                        if (product.getNumber() == 0)
                            it.remove();
                        checkCustomer(product, number, producer);
                        FileWorker.writeObject(OnlineShop.getGoodList(), new File(FileWorker.getFilePath() + "OnlineShop.txt"));
                        break;
                    } else
                        throw new MyException("Товара в таком количестве нет");
                }
            }
            if (flag == 0)
                throw new MyException("Такого товара нет");
        } else
            throw new MyException("Вы в черном списке");
    }

    public List<Goods> checkMapOrder(List<Goods> list, Goods good) {
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(good.getName()) && list.get(i).getProducer().equals(good.getProducer())) {
                list.get(i).setNumber(good.getNumber() + list.get(i).getNumber());
                flag++;
                break;
            }
        }
        if (flag == 0)
            list.add(good);
        return list;
    }

    public void checkCustomer(Goods product, int number, String producer) {
        int g = 0;
        List<Goods> list = new ArrayList<>();
        for (Map.Entry<Customer, List<Goods>> entry : Order.getMap().entrySet()) {
            if (customer.equals(entry.getKey())) {
                list = entry.getValue();
                Order.getMap().put(customer, checkMapOrder(list, new Goods(product.getName(), number, product.getUnitPrice(), product.getProducer(), product.getDescription())));
                g++;
            }
        }
        if (g == 0) {
            Order.getGood().removeAll(Order.getGood());
            Order.getMap().put(customer, checkMapOrder(list, new Goods(product.getName(), number, product.getUnitPrice(), product.getProducer(), product.getDescription())));
        }
        FileWorker.writeOrder(Order.getMap(), new File(FileWorker.getFilePath() + "Order.txt"));
    }

    public void delGood(String name, int number, String producer) {
        OnlineShop.setGoodList((List<Goods>) FileWorker.readObject(FileWorker.getFilePath() + "OnlineShop.txt"));
        for (Iterator<Goods> it = OnlineShop.getGoodList().iterator(); it.hasNext(); ) {
            Goods good = it.next();
            if (name.equals(good.getName()) && producer.equals(good.getProducer())) {
                good.setNumber(good.getNumber() + number);
                FileWorker.writeObject(OnlineShop.getGoodList(), new File(FileWorker.getFilePath() + "OnlineShop.txt"));
            }
        }
    }

    @Override
    public void removeGoodOrder() throws MyException {
        int flag = 0;
        Order.setMap(FileWorker.readOrder(FileWorker.getFilePath() + "Order.txt"));
        for (Map.Entry<Customer, List<Goods>> entry : Order.getMap().entrySet()) {
            if (customer.equals(entry.getKey())) {
                System.out.println("Введите наименование товара:");
                String name = Operations.inputString();
                System.out.println("Введите производителя товара:");
                String producer = Operations.inputString();
                for (Goods basket : entry.getValue()) {
                    if (name.equals(basket.getName()) && producer.equals(basket.getProducer())) {
                        flag++;
                        System.out.println("Введите количество товара:");
                        int number = Operations.inputNumber();
                        if (number == basket.getNumber()) {
                            entry.getValue().remove(basket);
                            Order.getMap().put(entry.getKey(), entry.getValue());
                            FileWorker.writeOrder(Order.getMap(), new File(FileWorker.getFilePath() + "Order.txt"));
                            delGood(name, number, producer);
                        } else if (number < basket.getNumber()) {
                            basket.setNumber(basket.getNumber() - number);
                            FileWorker.writeOrder(Order.getMap(), new File(FileWorker.getFilePath() + "Order.txt"));
                            delGood(name, number, producer);
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

    public void editBudget(double budget, FileWorker sz) {
        List<Customer> humanList = (List<Customer>) sz.readObject(FileWorker.getFilePath() + "customers.txt");
        for (int i = 0; i < humanList.size(); i++) {
            if (humanList.get(i).equals(customer))
                humanList.get(i).setBudget(budget);
        }
        sz.writeObject(humanList, new File(FileWorker.getFilePath() + "customers.txt"));
    }

    public void pay(List<Customer> list) {
        int flag = 0;
        FileWorker sz = new FileWorker();
        if (Order.getOrderCost() != 0)
            if (customer.getBudget() >= Order.getOrderCost()) {
                for (int i = 0; i < list.size(); i++)
                    if (customer.equals(list.get(i)))
                        list.remove(list.get(i));
                sz.writeObject(list, new File(FileWorker.getFilePath() + "non-payers.txt"));
                double budget = customer.getBudget() - Order.getOrderCost();
                editBudget(budget, sz);
                Order.getMap().remove(customer);
                customer.setBudget(budget);
                OnlineShop.setProfit(Order.getOrderCost());
                writeProfitOnlineShop(OnlineShop.getProfit());
//                Order.getMap().clear();
//                Order.getMap().remove(customer);

                FileWorker.writeOrder(Order.getMap(), new File(FileWorker.getFilePath() + "Order.txt"));
                String str = "Покупатель: " + customer.getName() + " " + customer.getSurname() + " " + ", Стоимость заказа = " + Order.getOrderCost() + "\n";
                FileWorker.writeByteFile(str, new File(FileWorker.getFilePath() + "InfoOrder.txt"));
            } else {
                for (Customer man : list)
                    if (customer.equals(man)) {
                        System.out.println("Вы уже находитесь в списке неплательщиков!");
                        flag++;
                    }
                if (flag == 0) {
                    list.add(customer);
                    System.out.println("Вы занесены в список неплательщиков!");
                    sz.writeObject(list, new File(FileWorker.getFilePath() + "non-payers.txt"));
                }
            }
    }

    @Override
    public void payOrder() throws MyException {
        FileWorker sz = new FileWorker();
        Order.setMap(FileWorker.readOrder(FileWorker.getFilePath() + "Order.txt"));
        System.out.println("Бюджет покупателя: " + customer.getBudget());
        System.out.println("Корзина покупателя: " + Order.getOrderCost());
        Order.setPayment(true);
        List<Customer> list = (List<Customer>) sz.readObject(FileWorker.getFilePath() + "non-payers.txt");
        if (Order.getMap().isEmpty() == false)
            pay(list);
    }


    public void writeProfitOnlineShop(double profit) {
        double str = FileWorker.readFile(new File(FileWorker.getFilePath() + "ProfitOnlineShop.txt"));
        str += profit;
        FileWorker.write(str, new File(FileWorker.getFilePath() + "ProfitOnlineShop.txt"));

    }

    @Override
    public void viewGoodsOrder() {
        double cost = 0;
        for (Map.Entry<Customer, List<Goods>> entry : FileWorker.readOrder(FileWorker.getFilePath() + "Order.txt").entrySet()) {
            if (customer.equals(entry.getKey())) {
                System.out.println("===========================");
                System.out.println("Клиент " + entry.getKey());
                System.out.println("Заказ " + entry.getValue());
                System.out.println("===========================");
                for (Goods good : entry.getValue()) {
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

    public void addGoodsFromOrder(List<Goods> list) {
        OnlineShop.setGoodList((List<Goods>) FileWorker.readObject(FileWorker.getFilePath() + "OnlineShop.txt"));
        for (int i = 0; i < OnlineShop.getGoodList().size(); i++) {
            for (Goods product : list) {
                if (product.getName().equals(OnlineShop.getGoodList().get(i).getName())) {
                    OnlineShop.getGoodList().get(i).setNumber(OnlineShop.getGoodList().get(i).getNumber() + product.getNumber());
                }
            }
        }
        FileWorker.writeObject(OnlineShop.getGoodList(), new File(FileWorker.getFilePath() + "OnlineShop.txt"));
    }

    @Override
    public void removeAllGoodsOrder() {
        Order.setMap(FileWorker.readOrder(FileWorker.getFilePath() + "Order.txt"));
        for (Map.Entry<Customer, List<Goods>> entry : Order.getMap().entrySet()) {
            if (customer.equals(entry.getKey())) {
                if (entry.getValue().size() != 0)
                    addGoodsFromOrder(entry.getValue());
                Order.getGood().removeAll(Order.getGood());
                Order.getMap().put(entry.getKey(), Order.getGood());
                FileWorker.writeOrder(Order.getMap(), new File(FileWorker.getFilePath() + "Order.txt"));
                break;
            }
        }
    }

    @Override
    public void viewGoods() {
        OnlineShop.setGoodList((List<Goods>) FileWorker.readObject(FileWorker.getFilePath() + "OnlineShop.txt"));
        ListIterator<Goods> listIter = OnlineShop.getGoodList().listIterator();
        while(listIter.hasNext())
            System.out.println((listIter.next()));
    }

    @Override
    public void rechargeBudget() {
        String fileName = FileWorker.getFilePath() + "customers.txt";
        List<Customer> customerList = (List<Customer>) FileWorker.readObject(fileName);
        for (int i = 0; i < customerList.size(); i++)
            if (customerList.get(i).equals(customer)) {
                System.out.println("Введите новый бюджет:");
                double newBudget = Operations.inputNumber();
                if (newBudget == customer.getBudget())
                    System.out.println("Введите другой бюджет");
                else {
                    customer.setBudget(newBudget);
                    customerList.get(i).setBudget(newBudget);
                    System.out.println("бюджет успешно изменен");
                    FileWorker.writeObject(customerList, new File(fileName));
                }
            }
    }
}
