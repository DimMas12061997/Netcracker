package by.training.nc.dev3.tools;

import by.training.nc.dev3.beans.Administrator.Administrator;
import by.training.nc.dev3.beans.Customer.Customer;
import by.training.nc.dev3.beans.Good;
import by.training.nc.dev3.beans.Human;
import by.training.nc.dev3.enums.Role;

import java.io.InvalidObjectException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Дмитрий on 18.03.2017.
 */
public final class Operations {
    public static Serializator sz = new Serializator();
    public static Scanner input = new Scanner(System.in);

    private Operations() {
    }

    public static String inputString() {
        input = new Scanner(System.in);
        return input.next();
    }

    public static Human registrationHuman(Role role) {
        String admins = "admins.txt";
        String customers = "customers.txt";
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

    public static int checkHuman(Role role) {
        int flag = 0;
        String admins = "admins.txt";
        String customers = "customers.txt";
        boolean in;
        Administrator res = null;
        Customer res1 = null;
        if (role.equals(role.ADMINISTRATOR)) {
            try {
                res = (Administrator) sz.deserialization(admins);
                System.out.println(res);
                Administrator admin = new Administrator(Operations.inputString(), Operations.inputString(), Operations.inputString());
                if (admin.equals(res))
                    flag = 1;
            } catch (InvalidObjectException e) {
                e.printStackTrace();
            }
        } else if (role.equals(role.CUSTOMER)) {
            try {
                res1 = (Customer) sz.deserialization(customers);
            } catch (InvalidObjectException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public static int inputNumber() {      //параметризация
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
