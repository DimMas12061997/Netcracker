package by.training.nc.dev3.interfaces;

import by.training.nc.dev3.exceptions.MyException;

public interface CustomerActions {

    /**
     * Adds goods to the order
     *
     * @throws MyException
     */
    void addGoodOrder() throws MyException;

    /**
     * Removes the goods from the order
     *
     * @throws MyException
     */
    void removeGoodOrder() throws MyException;

    /**
     * Pays the order
     *
     * @throws MyException
     */
    void payOrder() throws MyException;

    /**
     * Displays the goods in the order
     */
    void viewGoodsOrder();

    /**
     * Removes all goods from the order
     */
    void removeAllGoodsOrder();

    /**
     * Displays a list of products
     */
    void viewGoods();

    /**
     * Changes the budget of the customer
     */
    void rechargeBudget();
}
