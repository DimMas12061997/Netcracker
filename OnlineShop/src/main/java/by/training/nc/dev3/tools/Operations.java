package by.training.nc.dev3.tools;

import by.training.nc.dev3.beans.*;
import by.training.nc.dev3.command.admin.*;
import by.training.nc.dev3.command.customer.*;
import by.training.nc.dev3.enums.AdminAct;
import by.training.nc.dev3.enums.CustomerAct;
import by.training.nc.dev3.enums.Role;
import by.training.nc.dev3.enums.SortingIndex;
import by.training.nc.dev3.exceptions.MyException;
import by.training.nc.dev3.service.CustomerActs;

import java.io.File;
import java.util.*;


public final class Operations {
    private static FileWorker sz = new FileWorker();
    private static Scanner input = new Scanner(System.in);
    private static Map<AdminAct, ActAdmin> acts = new HashMap<>();
    private static Map<CustomerAct, ActCustomer> actsCustomer = new HashMap<>();

    private Operations() {
    }

    public static Map<AdminAct, ActAdmin> getActs() {
        return acts;
    }

    /**
     * Fills in the administrator's map
     */
    public static void fillMap() {
        acts.put(AdminAct.ADD, new AddGoodsAdmin());
        acts.put(AdminAct.VIEW, new ViewGoodsAdmin());
        acts.put(AdminAct.REMOVE, new RemoveGoodsAdmin());
        acts.put(AdminAct.REMOVEALL, new RemoveAllGoodsAdmin());
        acts.put(AdminAct.VIEWORDER, new ViewOrderAdmin());
        acts.put(AdminAct.CHECK, new CheckOrderAdmin());
        acts.put(AdminAct.VIEWBLACKLIST, new ViewBlackListAdmin());
        acts.put(AdminAct.VIEWARCHIVE, new ViewArchiveAdmin());
        acts.put(AdminAct.VIEWADMINS, new ViewAdmins());
        acts.put(AdminAct.REMOVEADMIN, new RemoveAdmin());
        acts.put(AdminAct.EDITADMIN, new EditAdmin());
        acts.put(AdminAct.VIEWCUSTOMERS, new ViewCustomers());
        acts.put(AdminAct.REMOVECUSTOMER, new RemoveCustomer());
        acts.put(AdminAct.EDITCUSTOMER, new EditCustomer());
    }

    /**
     * Fills in the customer's map
     */
    public static void fillMapCustomer() {
        actsCustomer.put(CustomerAct.ADD, new AddOrderCustomer());
        actsCustomer.put(CustomerAct.VIEW, new ViewGoodsCustomer());
        actsCustomer.put(CustomerAct.REMOVE, new RemoveOrderCustomer());
        actsCustomer.put(CustomerAct.REMOVEALL, new RemoveAllOrdersCustomer());
        actsCustomer.put(CustomerAct.VIEWORDER, new ViewOrderCustomer());
        actsCustomer.put(CustomerAct.PAYORDER, new PaymentOrderCustomer());
        actsCustomer.put(CustomerAct.RECHARGEBUDGET, new RechargeBudgetCustomer());
    }

    /**
     * Calls a method by type of map value
     *
     * @param act      - Action from the enum (CustomerAct)
     * @param customer
     */
    public static void doAction(CustomerAct act, Customer customer) {
        String customers = FileWorker.getFilePath() + "customers.txt";
        new CustomerActs(customer);
        try {
            actsCustomer.get(act).execute();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * String input
     *
     * @return string
     */
    public static String inputString() {
        input = new Scanner(System.in);
        return input.next();
    }

    /**
     * Sorts and displays list of services
     *
     * @param index - sorting index
     */
    public static void sortServices(SortingIndex index) {
        OnlineShop.setGoodList((List<Goods>) FileWorker.readObject(FileWorker.getFilePath() + "OnlineShop.txt"));
        Collections.sort(OnlineShop.getGoodList(), new ServiceComparator(index));
        for (Goods product : OnlineShop.getGoodList())
            System.out.println(product);
    }

    /**
     * Factory method for creating a child of the class human by role
     *
     * @param role - human role
     */
    public static Human getHuman(Role role) {
        Human human = null;
        switch (role) {
            case ADMINISTRATOR:
                System.out.println("Введите имя, фамилию, e-mail:");
                human = new Administrator(Operations.inputString(), Operations.inputString(), Operations.inputString());
                break;
            case CUSTOMER:
                System.out.println("Введите имя, фамилию, номер кредитной карточки, адрес, бюджет:");
                human = new Customer(Operations.inputString(), Operations.inputString(), Operations.inputString(), Operations.inputString(), Operations.inputNumber());
                break;
        }
        return human;
    }

    /**
     * Writes a person to a file by role
     *
     * @param role - human role
     */
    public static Human registrationHuman(Role role) {
        String fileName = "";
        Human human = getHuman(role);
        if (human instanceof Customer)
            fileName = FileWorker.getFilePath() + "customers.txt";
        else
            fileName = FileWorker.getFilePath() + "admins.txt";
        System.out.println(human);
        List<Human> humanList = (List<Human>) sz.readObject(fileName);
        humanList.add(human);
        sz.writeObject(humanList, new File(fileName));
        return human;
    }

    /**
     * Authorization
     *
     * @param role - human role
     * @return	- human, if successful authorization, otherwise null
     */
    public static Human checkHuman(Role role) {
        int flag = 0;
        String fileName = "";
        Human human = getHuman(role);
        if (human instanceof Customer)
            fileName = FileWorker.getFilePath() + "customers.txt";
        else
            fileName = FileWorker.getFilePath() + "admins.txt";
        List<Human> humanList = (List<Human>) sz.readObject(fileName);
        for (Human user : humanList) {
            if (user.equals(human))
                flag++;
        }
        if (flag > 0)
            return human;
        else
            return null;
    }

    /**
     * Checks the right input of numbers
     *
     * @return integer number above zero
     */
    public static int inputNumber() {
        int number = -1;
        while (number < 0) {
            try {
                input = new Scanner(System.in);
                number = input.nextInt();
                if (number >= 0) {
                    return number;
                } else {
                    System.out.println("Параметр не может быть отрицательным. Повторите ввод...");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Неверный формат. Повторите ввод...");
                continue;
            }
        }
        return 0;
    }

    /**
     * Checks the right input of numbers
     *
     * @return double number above zero
     */
    public static double inputPrice() {
        double number = -1.0;
        while (number < 0) {
            try {
                input = new Scanner(System.in);
                number = input.nextDouble();
                if (number >= 0) {
                    return number;
                } else {
                    System.out.println("Цена не может быть отрицательной. Повторите ввод...");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Неверный формат. Повторите ввод...");
                continue;
            }
        }
        return 0;
    }
}
