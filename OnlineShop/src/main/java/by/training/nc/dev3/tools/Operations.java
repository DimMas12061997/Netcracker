package by.training.nc.dev3.tools;

import by.training.nc.dev3.beans.*;
import by.training.nc.dev3.command.*;
import by.training.nc.dev3.enums.AdminAct;
import by.training.nc.dev3.enums.CustomerAct;
import by.training.nc.dev3.enums.Role;
import by.training.nc.dev3.enums.SortingIndex;
import by.training.nc.dev3.exceptions.InvalidSerializationException;
import by.training.nc.dev3.exceptions.MyException;
import by.training.nc.dev3.service.CustomerActs;

import java.util.*;


public final class Operations {
    private static FileWorker sz = new FileWorker();
    private static Scanner input = new Scanner(System.in);
    private static Map<AdminAct, ActCommand> acts = new HashMap<>();
    private static Map<CustomerAct, ActCommandCustomer> actsCustomer = new HashMap<>();

    private Operations() {
    }

    public static Map<AdminAct, ActCommand> getActs() {
        return acts;
    }

    public static void fillMap() {
        acts.put(AdminAct.ADD, new AddCommandAdmin());
        acts.put(AdminAct.VIEW, new ViewCommandAdmin());
        acts.put(AdminAct.REMOVE, new RemoveCommandAdmin());
        acts.put(AdminAct.REMOVEALL, new RemoveAllCommandAdmin());
        acts.put(AdminAct.VIEWORDER, new ViewOrderCommandAdmin());
        acts.put(AdminAct.CHECK, new CheckOrderCommandAdmin());
        acts.put(AdminAct.VIEWBLACKLIST, new ViewBlackListCommandAdmin());
        acts.put(AdminAct.VIEWARCHIVE, new ViewArchiveCommandAdmin());
    }

    public static void fillMapCustomer() {
        actsCustomer.put(CustomerAct.ADD, new AddCommandCustomer());
        actsCustomer.put(CustomerAct.VIEW, new ViewCommandCustomer());
        actsCustomer.put(CustomerAct.REMOVE, new RemoveCommandCustomer());
        actsCustomer.put(CustomerAct.REMOVEALL, new RemoveAllCommandCustomer());
        actsCustomer.put(CustomerAct.VIEWORDER, new ViewOrderCommandCustomer());
        actsCustomer.put(CustomerAct.PAYORDER, new PaymentCommandCustomer());
    }

    public static void doAction(CustomerAct act) {
        FileWorker sz = new FileWorker();
        String customers = FileWorker.getFilePath() + "customers.txt";
        Customer res = null;
        try {
            res = (Customer) sz.deserialization(customers);
        } catch (InvalidSerializationException e) {
            System.out.println(e.getMessage());
        }
        new CustomerActs(res);
        try {
            actsCustomer.get(act).execute();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String inputString() {
        input = new Scanner(System.in);
        return input.next();
    }

    public static void sortServices(SortingIndex index) {
        OnlineShop.setGoodList((List<Goods>) FileWorker.readObject(FileWorker.getFilePath() + "OnlineShop.txt"));
        Collections.sort(OnlineShop.getGoodList(), new ServiceComparator(index));
        for (Goods product : OnlineShop.getGoodList())
            System.out.println(product);
    }

    public static Human registrationHuman(Role role) {
        String admins = FileWorker.getFilePath() + "admins.txt";
        String customers = FileWorker.getFilePath() + "customers.txt";
        boolean in;
        if (role.equals(role.ADMINISTRATOR)) {
            Administrator admin = new Administrator(Operations.inputString(), Operations.inputString(), Operations.inputString());
            System.out.println(admin);
            in = sz.serialization(admin, admins);
            return admin;
        } else if (role.equals(role.CUSTOMER)) {
            Customer customer = new Customer(Operations.inputString(), Operations.inputString(), Operations.inputString(), Operations.inputString(), Operations.inputNumber());
            System.out.println(customer);
            in = sz.serialization(customer, customers);
            return customer;
        } else return null;
    }

    public static Human checkHuman(Role role) {
        int flag = 0;
        String admins = FileWorker.getFilePath() + "admins.txt";
        String customers = FileWorker.getFilePath() + "customers.txt";
        boolean in;
        Human res = null;
        int flag1 = 0;
        if (role.equals(role.ADMINISTRATOR)) {
            try {
                res = (Administrator) sz.deserialization(admins);
            } catch (InvalidSerializationException e) {
                System.out.println(e.getMessage()+ ", зарегистрируйтесь под администратором");
                res = registrationHuman(role.ADMINISTRATOR);
            }
            System.out.println(res);
            do {
                System.out.println("Введите данные об админе");
                Administrator admin = new Administrator(Operations.inputString(), Operations.inputString(), Operations.inputString());
                if (admin.equals(res)) {
                    flag1 = 1;
                }
            } while (flag1 == 0);
        } else if (role.equals(role.CUSTOMER)) {
            try {
                res = (Customer) sz.deserialization(customers);
            } catch (InvalidSerializationException e) {
                System.out.println(e.getMessage() + ", зарегистрируйтесь под покупателем");
                res = registrationHuman(role.CUSTOMER);
            }
            System.out.println(res);
            do {
                System.out.println("Введите данные о покупателе");
                Customer customer = new Customer(Operations.inputString(), Operations.inputString(), Operations.inputString(), Operations.inputString(), Operations.inputNumber());
                if (customer.equals(res)) {
                    flag1 = 1;
                }
            } while (flag1 == 0);
        }
        return res;
    }

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
}
