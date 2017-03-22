package by.training.nc.dev3.service;

import by.training.nc.dev3.beans.Customer;
import by.training.nc.dev3.beans.Good;
import by.training.nc.dev3.beans.OnlineShop;
import by.training.nc.dev3.beans.Order;
import by.training.nc.dev3.exceptions.MyException;
import by.training.nc.dev3.tools.FileWorker;
import by.training.nc.dev3.tools.Operations;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AdminActs {
    public void addGood() throws MyException {
        OnlineShop.good = (List<Good>) FileWorker.readObject(FileWorker.filePath + "OnlineShop.txt");
        Good good = new Good(Operations.inputString(), Operations.inputNumber(), Operations.inputNumber());
        checkGood(good);
        writeGoods();
    }

    public List<Good> checkGood(Good product) throws MyException {
        int flag = 0;
        for (int i = 0; i < OnlineShop.good.size(); i++)
            if (product.getName().equals(OnlineShop.good.get(i).getName())) {
                if (product.getUnitPrice() == OnlineShop.good.get(i).getUnitPrice()) {
                    OnlineShop.good.get(i).setNumber(OnlineShop.good.get(i).getNumber() + product.getNumber());
                    flag++;
                } else {
                    flag++;
                    throw new MyException("Невозможно добавить такой товар");
                }
            }
        if (flag == 0)
            OnlineShop.good.add(product);
        return OnlineShop.good;
    }

    public void writeGoods() {
        FileWorker.writeObject(OnlineShop.good, new File(FileWorker.filePath + "OnlineShop.txt"));
        OnlineShop.good.removeAll(OnlineShop.good);
    }

    public void removeGood() throws MyException {
        int flag = 0;
        OnlineShop.good = (List<Good>) FileWorker.readObject(FileWorker.filePath + "OnlineShop.txt");
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
                    throw new MyException("Проблемка с размером");
            }
            FileWorker.writeObject(OnlineShop.good, new File(FileWorker.filePath + "OnlineShop.txt"));
        }
        if (flag == 0)
            throw new MyException("Нет товара с таким названием");
    }


    public void viewGoods() {
        List<Good> list = (List<Good>) FileWorker.readObject(FileWorker.filePath + "OnlineShop.txt");
        for (Good ob : list)
            System.out.println(ob);
    }

    public void removeAllGoods() {
        OnlineShop.good.removeAll(OnlineShop.good);
        FileWorker.writeObject(OnlineShop.good, new File(FileWorker.filePath + "OnlineShop.txt"));
    }

    public void checkOrder() {
        FileWorker sz = new FileWorker();
        String customers = FileWorker.filePath + "non-payers.txt";
        boolean in;
        List<Customer> res = (List<Customer>) sz.readObject(customers);
        blackList(res);
        System.out.println("Все неплательщики занесены в чс");
    }

    public void blackList(List<Customer> res) {
        FileWorker sz = new FileWorker();
        sz.writeObject(res, new File(FileWorker.filePath + "blackList.txt"));
    }

    public void viewBlackList() {
        FileWorker sz = new FileWorker();
        List<Customer> res = (List<Customer>) sz.readObject(FileWorker.filePath + "blackList.txt");
        if (res.size() == 0)
            System.out.println("В черном списке никого нет.");
        else {
            System.out.println("Черный список магазина:");
            for (Customer cus : res)
                System.out.println(cus);
        }
    }

    public void viewArchive() {
        System.out.println(FileWorker.readByteFile(new File(FileWorker.filePath + "InfoOrder.txt")));
        System.out.println("\nПрибыль магазина: " + FileWorker.readFile(new File(FileWorker.filePath + "ProfitOnlineShop.txt")));
    }

    public void viewOrder() {
        Order.map = FileWorker.readOrder(FileWorker.filePath + "Order.txt");
        for (Map.Entry<Customer, List<Good>> entry : Order.map.entrySet()) {
            System.out.println("===========================");
            System.out.println("Клиент " + entry.getKey());
            System.out.println("Заказ " + entry.getValue());
            System.out.println("===========================");
        }
    }
}
