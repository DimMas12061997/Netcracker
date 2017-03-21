package by.training.nc.dev3.shop;


import by.training.nc.dev3.exceptions.MyException;
import by.training.nc.dev3.tools.Menu;

public class OnlineShopRunner {
    public static void main(String[] args) {
        try {
            Menu.menu();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
