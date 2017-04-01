package by.training.nc.dev3.interfaces;

import by.training.nc.dev3.exceptions.MyException;

public interface AdminActions {

    void addGood() throws MyException;

    void removeGood() throws MyException;

    void viewGoods();

    void removeAllGoods();

    void checkOrder();

    void viewBlackList();

    void viewOrder();

    void viewAdmins();

    void editAdmin();

    void removeAdmin();

    void viewCustomers();

    void editCustomer();

    void removeCustomer();
}
