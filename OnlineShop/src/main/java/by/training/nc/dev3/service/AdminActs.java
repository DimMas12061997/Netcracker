package by.training.nc.dev3.service;

import by.training.nc.dev3.beans.Customer;
import by.training.nc.dev3.beans.Goods;
import by.training.nc.dev3.beans.OnlineShop;
import by.training.nc.dev3.beans.Order;
import by.training.nc.dev3.exceptions.MyException;
import by.training.nc.dev3.interfaces.AdminActions;
import by.training.nc.dev3.tools.FileWorker;
import by.training.nc.dev3.tools.Operations;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AdminActs implements AdminActions {
    @Override
    public void addGood() throws MyException {
        OnlineShop.setGoodList((List<Goods>) FileWorker.readObject(FileWorker.getFilePath() + "OnlineShop.txt"));
        Goods good = new Goods(Operations.inputString(), Operations.inputNumber(), Operations.inputNumber());
        checkGood(good);
        writeGoods();
    }

    public List<Goods> checkGood(Goods product) throws MyException {
        int flag = 0;
        for (int i = 0; i < OnlineShop.getGoodList().size(); i++)
            if (product.getName().equals(OnlineShop.getGoodList().get(i).getName())) {
                if (product.getUnitPrice() == OnlineShop.getGoodList().get(i).getUnitPrice()) {
                    OnlineShop.getGoodList().get(i).setNumber(OnlineShop.getGoodList().get(i).getNumber() + product.getNumber());
                    flag++;
                } else {
                    flag++;
                    throw new MyException("Невозможно добавить такой товар");
                }
            }
        if (flag == 0)
            OnlineShop.getGoodList().add(product);
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
        String name = Operations.inputString();
        for (Iterator<Goods> it = OnlineShop.getGoodList().iterator(); it.hasNext(); ) {
            Goods good = it.next();
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
            FileWorker.writeObject(OnlineShop.getGoodList(), new File(FileWorker.getFilePath() + "OnlineShop.txt"));
        }
        if (flag == 0)
            throw new MyException("Нет товара с таким названием");
    }

    @Override
    public void viewGoods() {
        List<Goods> list = (List<Goods>) FileWorker.readObject(FileWorker.getFilePath() + "OnlineShop.txt");
        for (Goods ob : list)
            System.out.println(ob);
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
}
