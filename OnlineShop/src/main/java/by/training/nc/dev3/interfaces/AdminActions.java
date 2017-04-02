package by.training.nc.dev3.interfaces;

import by.training.nc.dev3.exceptions.MyException;

public interface AdminActions {
    /**
     * Adds product
     */
    void addGood() throws MyException;

    /**
     * Removes the goods
     *
     * @throws MyException
     */
    void removeGood() throws MyException;

    /**
     * Displays a list of products
     */
    void viewGoods();

    /**
     * Removes all goods
     */
    void removeAllGoods();

    /**
     * Checks the order of customers
     */
    void checkOrder();

    /**
     * Displays a black list of customers
     */
    void viewBlackList();

    /**
     * Displays orders of potential customers
     */
    void viewOrder();

    /**
     * Displays a list of all administrators
     */
    void viewAdmins();

    /**
     * Changes administrator
     */
    void editAdmin();

    /**
     * Removes the administrator
     */
    void removeAdmin();

    /**
     * Displays a list of all customers
     */
    void viewCustomers();

    /**
     * Changes customer
     */
    void editCustomer();

    /**
     * Removes the customer
     */
    void removeCustomer();
}
