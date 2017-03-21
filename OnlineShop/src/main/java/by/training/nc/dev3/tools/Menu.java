package by.training.nc.dev3.tools;

import by.training.nc.dev3.beans.Administrator.Administrator;
import by.training.nc.dev3.beans.Customer.Customer;
import by.training.nc.dev3.beans.OnlineShop;
import by.training.nc.dev3.enums.AdminAct;
import by.training.nc.dev3.enums.CustomerAct;
import by.training.nc.dev3.enums.Role;
import by.training.nc.dev3.exceptions.MyException;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    public static Administrator admin = new Administrator();
    public static Customer customer;
    //public static List<Customer> customers = new ArrayList<>();

    public static void menu() throws MyException {
        int flag = 0;
        role:
        while (true) {
            System.out.println("===========================================================");
            System.out.println("==================" + OnlineShop.getName() + "==================================");
            System.out.println("===========================================================");
            System.out.println("Выберите пользователя:");
            System.out.println("1. Администратор");
            System.out.println("2. Клиент");
            System.out.println("0. Выход");
            System.out.println("===========================================================");
            out2:
            switch (Operations.inputNumber()) {
                case 1:
                    while (flag == 0) {
                        System.out.println("===========================================================");
                        System.out.println("1. Вход");
                        System.out.println("2. Регистрация");
                        System.out.println("0. Назад");
                        System.out.println("===========================================================");

                        switch (Operations.inputNumber()) {
                            case 1:
                                admin = (Administrator) Operations.checkHuman(Role.ADMINISTRATOR);
                                flag++;
                                break;
                            case 2:
                                System.out.println("===========================================================");
                                System.out.println("Введите данные об админе");
                                admin = (Administrator) Operations.registrationHuman(Role.ADMINISTRATOR);
                                flag++;
                                break;
                            case 0:
                                System.out.println("===========================================================");
                                System.out.println(flag);
                                break out2;
                            default:
                                System.out.println("===========================================================");
                                System.out.println("Неверный выбор либо формат. Повторите...");
                        }
                    }
                    admin.fillMap();
                    out:
                    while (true) {
                        System.out.println("===========================================================");
                        System.out.println("1. Просмотр товара магазина");
                        System.out.println("2. Добавить товар");
                        System.out.println("3. Удалить товар");
                        System.out.println("4. Просмотр заказов покупателей");
                        System.out.println("5. Проверка оплаты заказа");
                        System.out.println("6. Записать список товара в файл");
                        System.out.println("7. Удалить весь товар");
                        System.out.println("0. Назад");
                        System.out.println("===========================================================");

                        switch (Operations.inputNumber()) {
                            case 1:
                                admin.doAction(AdminAct.VIEW);
                                break;
                            case 2:
                                System.out.println("===========================================================");
                                admin.doAction(AdminAct.ADD);
                                break;
                            case 3:
                                System.out.println("===========================================================");
                                admin.doAction(AdminAct.REMOVE);
                                break;
                            case 4:
                                System.out.println("===========================================================");
                                admin.doAction(AdminAct.VIEWORDER);
                                break;
                            case 5:
                                System.out.println("===========================================================");

                                break;
                            case 6:
                                System.out.println("===========================================================");
                                admin.doAction(AdminAct.WRITE);
                                break;
                            case 7:
                                System.out.println("===========================================================");
                                admin.doAction(AdminAct.REMOVEALL);
                                break;
                            case 0:
                                System.out.println("===========================================================");
                                flag = 0;
                                break out;
                            default:
                                System.out.println("===========================================================");
                                System.out.println("Неверный выбор либо формат. Повторите...");
                        }
                    }
                    break;
                case 2:
                    while (flag == 0) {
                        System.out.println("===========================================================");
                        System.out.println("1. Вход");
                        System.out.println("2. Регистрация");
                        System.out.println("0. Назад");
                        System.out.println("===========================================================");

                        switch (Operations.inputNumber()) {
                            case 1:
                                customer = (Customer) Operations.checkHuman(Role.CUSTOMER);
                                flag++;
                                break;
                            case 2:
                                System.out.println("===========================================================");
                                System.out.println("Введите данные о покупателе");
                                customer = (Customer) Operations.registrationHuman(Role.CUSTOMER);
                                flag++;
                                break;
                            case 0:
                                System.out.println("===========================================================");
                                break out2;
                            default:
                                System.out.println("===========================================================");
                                System.out.println("Неверный выбор либо формат. Повторите...");
                        }
                    }
                    customer.fillMap();
                    toMenu:
                    while (true) {
                        System.out.println("===========================================================");
                        System.out.println("1. Показать весь товар магазина");
                        System.out.println("2. Добавить товар в заказ");
                        System.out.println("3. Удалить товар из заказа");
                        System.out.println("4. Удалить весь товар из заказа");
                        System.out.println("5. Сформировать заказ");
                        System.out.println("6. Оплата заказа");
                        System.out.println("0. Назад");
                        System.out.println("===========================================================");

                        switch (Operations.inputNumber()) {
                            case 1:
                                System.out.println("===========================================================");
                                customer.doAction(CustomerAct.VIEW);
                                break;
                            case 2:
                                System.out.println("===========================================================");
                                customer.doAction(CustomerAct.ADD);
                                break;
                            case 3:
                                System.out.println("===========================================================");
                                customer.doAction(CustomerAct.REMOVE);
                                break;
                            case 4:
                                System.out.println("===========================================================");
                                customer.doAction(CustomerAct.REMOVEALL);
                                break;
                            case 5:
                                System.out.println("===========================================================");
                                customer.doAction(CustomerAct.VIEWORDER);
                                break;
                            case 6:
                                System.out.println("===========================================================");
                                customer.doAction(CustomerAct.PAYORDER);
                                break;
                            case 0:
                                System.out.println("===========================================================");
                                flag = 0;
                                break toMenu;
                            default:
                                System.out.println("===========================================================");
                                System.out.println("Неверный выбор либо формат. Повторите...");
                        }
                    }
                    break;
                case 0:
                    System.out.println("===========================================================");
                    System.out.println("Работа завершена...");
                    System.out.println("===========================================================");
                    System.exit(0);
                default:
                    System.out.println("===========================================================");
                    System.out.println("Неверный выбор либо формат. Повторите...");
            }
        }
    }
}
