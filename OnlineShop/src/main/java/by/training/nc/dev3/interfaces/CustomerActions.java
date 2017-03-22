package by.training.nc.dev3.interfaces;

import by.training.nc.dev3.beans.Goods;
import by.training.nc.dev3.exceptions.MyException;

public interface CustomerActions {

    void addGoodOrder() throws MyException;

    void delGood(String name, Goods basket);

    void removeGoodOrder() throws MyException;

    void payOrder() throws MyException;

    void viewGoodsOrder();

    void removeAllGoodsOrder();

    void viewGoods();
}
