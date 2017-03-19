package by.training.nc.dev3.tools;

import by.training.nc.dev3.beans.Good;
import by.training.nc.dev3.beans.Human;
import by.training.nc.dev3.enums.Role;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Дмитрий on 18.03.2017.
 */
public final class Operations {
    public static Scanner input = new Scanner(System.in);

    private Operations() {
    }

    public static String inputString() {
        input = new Scanner(System.in);
        return input.next();
    }

//    public static Object inputObject(Object object) {
//        Good good = new Good();
//        if (object instanceof Good) {
//            good.setName(inputString());
//            good.setNumber(inputNumber());
//            good.setUnitPrice(inputNumber());
//        }
//        return good;
//    }

    public static Human inputRole(Role role) {
        return role.getRole();
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
