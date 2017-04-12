package by.training.nc.dev3.service;

import by.training.nc.dev3.beans.*;
import by.training.nc.dev3.exceptions.MyException;
import by.training.nc.dev3.interfaces.AdminActions;
import by.training.nc.dev3.tools.FileWorker;
import by.training.nc.dev3.tools.Operations;

import java.io.File;
import java.util.*;

public class AdminActs implements AdminActions {
    @Override
    public void addGood() throws MyException {
        OnlineShop.setGoodList((List<Goods>) FileWorker.readObject(FileWorker.getFilePath() + "OnlineShop.txt"));
        System.out.println("Введите информацию о товаре: наименование, количество, цена за единицу, производитель и описание");
        Goods good = new Goods(Operations.inputString(), Operations.inputNumber(), Operations.inputPrice(), Operations.inputString(), Operations.inputString());
        checkGood(good);
        writeGoods();
    }

    public List<Goods> checkGood(Goods product) throws MyException {
        if (OnlineShop.getGoodList().size() == 0)
            OnlineShop.getGoodList().add(product);
        else {
            int flag = 0;
            for (int i = 0; i < OnlineShop.getGoodList().size(); i++)
                if (product.getName().equals(OnlineShop.getGoodList().get(i).getName()))
                    if (product.getProducer().equals(OnlineShop.getGoodList().get(i).getProducer())) {
                        if (product.getUnitPrice() == OnlineShop.getGoodList().get(i).getUnitPrice() && product.getDescription().equals(OnlineShop.getGoodList().get(i).getDescription())) {
                            flag++;
                            OnlineShop.getGoodList().get(i).setNumber(OnlineShop.getGoodList().get(i).getNumber() + product.getNumber());
                        } else {
                            flag++;
                            throw new MyException("Невозможно добавить такой же товар, но с другой ценой или описанием!");
                        }
                    } else {
                        if (product.getUnitPrice() == OnlineShop.getGoodList().get(i).getUnitPrice()) {
                            flag++;
                            throw new MyException("Невозможно добавить товар c такой ценой, т.к. другой производитель использует ее!");
                        }
                    }
            if (flag == 0)
                OnlineShop.getGoodList().add(product);
        }
        return OnlineShop.getGoodList();
    }

    public void writeGoods() {
        FileWorker.writeObject(OnlineShop.getGoodList(), new File(FileWorker.getFilePath() + "OnlineShop.txt"));
        OnlineShop.getGoodList().removeAll(OnlineShop.getGoodList());
    }

    @Override
    public void removeGood() throws MyException {
        int flag = 0;
        OnlineShop.setGoodList((List<Goods>) FileWorker.readObject(FileWorker.getFilePath() + "OnlineShop.txt"));
        System.out.println("Введите наименование товара:");
        String name = Operations.inputString();
        System.out.println("Введите производителя товара:");
        String producer = Operations.inputString();
        for (Iterator<Goods> it = OnlineShop.getGoodList().iterator(); it.hasNext(); ) {
            Goods good = it.next();
            if (name.equals(good.getName()) && producer.equals(good.getProducer())) {
                flag++;
                System.out.println("Введите количество товара:");
                int number = Operations.inputNumber();
                if (number == good.getNumber())
                    it.remove();
                else if (number <= good.getNumber())
                    good.setNumber(good.getNumber() - number);
                else
                    throw new MyException("Проблемка с размером");
            }
            FileWorker.writeObject(OnlineShop.getGoodList(), new File(FileWorker.getFilePath() + "OnlineShop.txt"));
        }
        if (flag == 0)
            throw new MyException("Нет такого товара");
    }

    @Override
    public void viewGoods() {
        List<Goods> list = (List<Goods>) FileWorker.readObject(FileWorker.getFilePath() + "OnlineShop.txt");
        ListIterator<Goods> listIter = list.listIterator();
        while (listIter.hasNext())
            System.out.println((listIter.next()));
    }

    @Override
    public void removeAllGoods() {
        OnlineShop.getGoodList().removeAll(OnlineShop.getGoodList());
        FileWorker.writeObject(OnlineShop.getGoodList(), new File(FileWorker.getFilePath() + "OnlineShop.txt"));
    }

    @Override
    public void checkOrder() {
        FileWorker sz = new FileWorker();
        String customers = FileWorker.getFilePath() + "non-payers.txt";
        boolean in;
        List<Customer> res = (List<Customer>) sz.readObject(customers);
        blackList(res);
        if (res.size() != 0)
            System.out.println("Все неплательщики занесены в чс");
    }

    public void blackList(List<Customer> res) {
        FileWorker sz = new FileWorker();
        sz.writeObject(res, new File(FileWorker.getFilePath() + "blackList.txt"));
    }

    public void viewBlackList() {
        FileWorker sz = new FileWorker();
        List<Customer> res = (List<Customer>) sz.readObject(FileWorker.getFilePath() + "blackList.txt");
        if (res.size() == 0)
            System.out.println("В черном списке никого нет.");
        else {
            System.out.println("Черный список магазина:");
            for (Customer cus : res)
                System.out.println(cus);
        }
    }

    public void viewArchive() {
        System.out.println(FileWorker.readByteFile(new File(FileWorker.getFilePath() + "InfoOrder.txt")));
        System.out.println("\nПрибыль магазина: " + FileWorker.readFile(new File(FileWorker.getFilePath() + "ProfitOnlineShop.txt")));
    }

    @Override
    public void viewOrder() {
        Order.setMap(FileWorker.readOrder(FileWorker.getFilePath() + "Order.txt"));
        for (Map.Entry<Customer, List<Goods>> entry : Order.getMap().entrySet()) {
            System.out.println("===========================");
            System.out.println("Клиент " + entry.getKey());
            System.out.println("Заказ " + entry.getValue());
            System.out.println("===========================");
        }
    }

    @Override
    public void viewAdmins() {
        String fileName = FileWorker.getFilePath() + "admins.txt";
        List<Human> humanList = (List<Human>) FileWorker.readObject(fileName);
        Collections.sort(humanList);
        System.out.println("===========================");
        for (Human user : humanList)
            System.out.println(user);
        System.out.println("===========================");

    }

    @Override
    public void editAdmin() {
        int flag = 0;
        String fileName = FileWorker.getFilePath() + "admins.txt";
        List<Administrator> adminList = (List<Administrator>) FileWorker.readObject(fileName);
        System.out.println("Введите имя, фамилию, e-mail:");
        Administrator admin = new Administrator(Operations.inputString(), Operations.inputString(), Operations.inputString());
        for (int i = 0; i < adminList.size(); i++) {
            if (adminList.get(i).equals(admin)) {
                flag++;
                System.out.println("Введите новый e-mail:");
                String newEmail = Operations.inputString();
                if (newEmail.equals(admin.getEmail()))
                    System.out.println("Введите другой e-mail");
                else {
                    adminList.get(i).setEmail(newEmail);
                    System.out.println("e-mail успешно изменен");
                    FileWorker.writeObject(adminList, new File(fileName));
                }
            }
        }
        if (flag == 0)
            System.out.println("Такого администратора не существует");
    }

    @Override
    public void removeAdmin() {
        int flag = 0;
        String fileName = FileWorker.getFilePath() + "admins.txt";
        List<Administrator> adminList = (List<Administrator>) FileWorker.readObject(fileName);
        if (adminList.size() != 0) {
            System.out.println("Введите имя, фамилию, e-mail:");
            Administrator admin = new Administrator(Operations.inputString(), Operations.inputString(), Operations.inputString());
            for (int i = 0; i < adminList.size(); i++) {
                if (adminList.get(i).equals(admin)) {
                    flag++;
                    adminList.remove(adminList.get(i));
                    System.out.println("Администратор успешно удален");
                    FileWorker.writeObject(adminList, new File(fileName));
                }
            }
            if (flag == 0)
                System.out.println("Такого администратора не существует");
        } else
            System.out.println("Нет ни одного администратора!");

    }

    @Override
    public void viewCustomers() {
        String fileName = FileWorker.getFilePath() + "customers.txt";
        List<Human> humanList = (List<Human>) FileWorker.readObject(fileName);
        Collections.sort(humanList);
        System.out.println("===========================");
        for (Human user : humanList)
            System.out.println(user);
        System.out.println("===========================");

    }

    @Override
    public void editCustomer() {
        int flag = 0;
        String fileName = FileWorker.getFilePath() + "customers.txt";
        List<Customer> customerList = (List<Customer>) FileWorker.readObject(fileName);
        if (customerList.size() != 0) {
            System.out.println("Введите имя, фамилию, номер кредитной карточки, адрес, бюджет:");
            Customer customer = new Customer(Operations.inputString(), Operations.inputString(), Operations.inputString(), Operations.inputString(), Operations.inputNumber());
            for (int i = 0; i < customerList.size(); i++) {
                if (customerList.get(i).equals(customer)) {
                    flag++;
                    System.out.println("Введите новый бюджет:");
                    double newBudget = Operations.inputNumber();
                    if (newBudget == customer.getBudget())
                        System.out.println("Введите другой бюджет");
                    else {
                        customerList.get(i).setBudget(newBudget);
                        System.out.println("бюджет успешно изменен");
                        FileWorker.writeObject(customerList, new File(fileName));
                    }
                }
            }
            if (flag == 0)
                System.out.println("Такого покупателя не существует");
        } else
            System.out.println("Нет ни одного покупателя");
    }

    @Override
    public void removeCustomer() {
        int flag = 0;
        String fileName = FileWorker.getFilePath() + "customers.txt";
        List<Customer> customerList = (List<Customer>) FileWorker.readObject(fileName);
        if (customerList.size() != 0) {
            System.out.println("Введите имя, фамилию, номер кредитной карточки, адрес, бюджет:");
            Customer customer = new Customer(Operations.inputString(), Operations.inputString(), Operations.inputString(), Operations.inputString(), Operations.inputNumber());
            for (int i = 0; i < customerList.size(); i++) {
                if (customerList.get(i).equals(customer)) {
                    flag++;
                    customerList.remove(customerList.get(i));
                    System.out.println("Покупатель успешно удален");
                    FileWorker.writeObject(customerList, new File(fileName));
                }
            }
            if (flag == 0)
                System.out.println("Такого покупателя не существует");
        } else
            System.out.println("Нет ни одного покупателя");
    }
}
