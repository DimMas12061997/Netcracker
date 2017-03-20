package by.training.nc.dev3.tools;

import by.training.nc.dev3.beans.Administrator.Administrator;
import by.training.nc.dev3.beans.Customer.Customer;
import by.training.nc.dev3.beans.OnlineShop;
import by.training.nc.dev3.enums.AdminAct;
import by.training.nc.dev3.enums.CustomerAct;
import by.training.nc.dev3.enums.Role;

/**
 * Created by Дмитрий on 18.03.2017.
 */
public class Menu {
    public static Administrator admin = new Administrator();
    public static Customer customer;

    public static void menu() {
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

            switch (Operations.inputNumber()) {
                case 1:
                    int flag = 0;
                    do {
                        System.out.println("Введите данные об админе");
                        flag = Operations.checkHuman(Role.ADMINISTRATOR);
                    }
                    while (flag == 0);
                    admin.fillMap();
                    out:
                    while (true) {
                        System.out.println("===========================================================");
                        System.out.println("1. Просмотр товара магазина");
                        System.out.println("2. Добавить товар");
                        System.out.println("3. Удалить товар");
                        System.out.println("4. Проверка оплаты заказа");
                        System.out.println("5. Прочитать список товара из файла");
                        System.out.println("6. Записать список товара в файл");
                        System.out.println("7. Удалить весь товар");
                        System.out.println("8. Изменить администратора");
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
                                admin.doAction(AdminAct.CHECK);
                                break;
                            case 5:
                                System.out.println("===========================================================");

                                break;
                            case 6:
                                System.out.println("===========================================================");

                                break;
                            case 7:
                                System.out.println("===========================================================");
                                admin.doAction(AdminAct.REMOVEALL);
                                break;
                            case 8:
                                System.out.println("===========================================================");
                                System.out.println("Введите данные об админе");
                                admin = (Administrator) Operations.registrationHuman(Role.ADMINISTRATOR);
                                break;
                            case 0:
                                System.out.println("===========================================================");
                                break out;
                            default:
                                System.out.println("===========================================================");
                                System.out.println("Неверный выбор либо формат. Повторите...");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Введите данные о покупателе");
                    customer = (Customer) Operations.registrationHuman(Role.CUSTOMER);
                    customer.fillMap();
                    toMenu:
                    while (true) {
                        System.out.println("===========================================================");
                        System.out.println("1. Показать весь товар магазина");
                        System.out.println("2. Добавить товар в заказ");
                        System.out.println("3. Удалить товар из заказа");
                        System.out.println("4. Удалить весь товар из заказа");
                        System.out.println("5. Просмотр заказа");
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
