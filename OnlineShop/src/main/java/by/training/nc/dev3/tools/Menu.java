package by.training.nc.dev3.tools;

import by.training.nc.dev3.beans.Administrator;
import by.training.nc.dev3.beans.Customer;
import by.training.nc.dev3.beans.OnlineShop;
import by.training.nc.dev3.enums.AdminAct;
import by.training.nc.dev3.enums.CustomerAct;
import by.training.nc.dev3.enums.Role;
import by.training.nc.dev3.enums.SortingIndex;
import by.training.nc.dev3.exceptions.MyException;

public class Menu {
    private static Administrator admin;
    private static Customer customer;

    public static void menu() {
        Operations.fillMap();
        Operations.fillMapCustomer();
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
                                System.out.println("Введите данные об администраторе");
                                admin = (Administrator) Operations.checkHuman(Role.ADMINISTRATOR);
                                if (admin == null) {
                                    System.out.println("Неверно введены данные");
                                    break out2;
                                } else {
                                    flag++;
                                }
                                break;
                            case 2:
                                System.out.println("===========================================================");
                                System.out.println("Введите данные об админе");
                                admin = (Administrator) Operations.registrationHuman(Role.ADMINISTRATOR);
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
                    out:
                    try {
                        while (true) {
                            System.out.println("===========================================================");
                            System.out.println("1. Просмотр товара магазина");
                            System.out.println("2. Добавить товар");
                            System.out.println("3. Удалить товар");
                            System.out.println("4. Просмотр заказов потенциальных покупателей");
                            System.out.println("5. Проверка оплаты заказа");
                            System.out.println("6. Просмотр черного списка");
                            System.out.println("7. Удалить весь товар");
                            System.out.println("8. Сортировка товара");
                            System.out.println("9. Прибыль магазина и данные о покупателях");
                            System.out.println("10. Работа с администраторами/покупателями");
                            System.out.println("0. Назад");
                            System.out.println("===========================================================");

                            switch (Operations.inputNumber()) {
                                case 1:
                                    Operations.getActs().get(AdminAct.VIEW).execute();
                                    break;
                                case 2:
                                    System.out.println("===========================================================");
                                    Operations.getActs().get(AdminAct.ADD).execute();
                                    break;
                                case 3:
                                    System.out.println("===========================================================");
                                    Operations.getActs().get(AdminAct.REMOVE).execute();
                                    break;
                                case 4:
                                    System.out.println("===========================================================");
                                    Operations.getActs().get(AdminAct.VIEWORDER).execute();
                                    break;
                                case 5:
                                    System.out.println("===========================================================");
                                    Operations.getActs().get(AdminAct.CHECK).execute();
                                    break;
                                case 6:
                                    System.out.println("===========================================================");
                                    Operations.getActs().get(AdminAct.VIEWBLACKLIST).execute();
                                    break;
                                case 7:
                                    System.out.println("===========================================================");
                                    Operations.getActs().get(AdminAct.REMOVEALL).execute();
                                    break;
                                case 8:
                                    System.out.println("===========================================================");
                                    label:
                                    while (true) {
                                        System.out.println("1. По цене");
                                        System.out.println("2. По наименованию");
                                        System.out.println("3. По количеству");
                                        System.out.println("0. Назад");

                                        switch (Operations.inputNumber()) {
                                            case 1:
                                                Operations.sortServices(SortingIndex.PRICE);
                                                break label;
                                            case 2:
                                                Operations.sortServices(SortingIndex.NAME);
                                                break label;
                                            case 3:
                                                Operations.sortServices(SortingIndex.NUMBER);
                                                break label;
                                            case 0:
                                                System.out.println("===========================================================");
                                                break label;
                                            default:
                                                System.out.println("Неверный выбор. Повторите");
                                        }
                                    }
                                    break;
                                case 9:
                                    System.out.println("===========================================================");
                                    Operations.getActs().get(AdminAct.VIEWARCHIVE).execute();
                                    break;
                                case 10:
                                    System.out.println("===========================================================");
                                    label:
                                    while (true) {
                                        System.out.println("1. Работа с администраторами");
                                        System.out.println("2. Работа с пользователями");
                                        System.out.println("3. Выход");

                                        switch (Operations.inputNumber()) {
                                            case 1:
                                                System.out.println("===========================================================");
                                                workAdmin:
                                                while (true) {
                                                    System.out.println("1. Просмотр информации об администраторах");
                                                    System.out.println("2. Удалить администратора");
                                                    System.out.println("3. Изменить e-mail администратора");
                                                    System.out.println("4. Добавить администратора");
                                                    System.out.println("0. Выход");

                                                    switch (Operations.inputNumber()) {
                                                        case 1:
                                                            Operations.getActs().get(AdminAct.VIEWADMINS).execute();
                                                            break;
                                                        case 2:
                                                            Operations.getActs().get(AdminAct.REMOVEADMIN).execute();
                                                            break;
                                                        case 3:
                                                            Operations.getActs().get(AdminAct.EDITADMIN).execute();
                                                            break;
                                                        case 4:
                                                            Operations.registrationHuman(Role.ADMINISTRATOR);
                                                            break;
                                                        case 0:
                                                            System.out.println("===========================================================");
                                                            break workAdmin;
                                                        default:
                                                            System.out.println("Неверный выбор. Повторите");
                                                    }
                                                }
                                                break;
                                            case 2:
                                                System.out.println("===========================================================");
                                                workAdmin:
                                                while (true) {
                                                    System.out.println("1. Просмотр информации о покупателях");
                                                    System.out.println("2. Удалить покупателя");
                                                    System.out.println("3. Изменить бюджет покупателя");
                                                    System.out.println("0. Выход");

                                                    switch (Operations.inputNumber()) {
                                                        case 1:
                                                            Operations.getActs().get(AdminAct.VIEWCUSTOMERS).execute();
                                                            break;
                                                        case 2:
                                                            Operations.getActs().get(AdminAct.REMOVECUSTOMER).execute();
                                                            break;
                                                        case 3:
                                                            Operations.getActs().get(AdminAct.EDITCUSTOMER).execute();
                                                            break;
                                                        case 0:
                                                            System.out.println("===========================================================");
                                                            break workAdmin;
                                                        default:
                                                            System.out.println("Неверный выбор. Повторите");
                                                    }
                                                }
                                                break;
                                            case 3:
                                                System.out.println("===========================================================");
                                                break label;
                                            default:
                                                System.out.println("Неверный выбор. Повторите");
                                        }
                                    }
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
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
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
                                System.out.println("Введите данные о покупателе");
                                customer = (Customer) Operations.checkHuman(Role.CUSTOMER);
                                if (customer == null) {
                                    System.out.println("Неверно введены данные");
                                    break out2;
                                } else {
                                    flag++;
                                    System.out.println(customer);
                                }
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
                    toMenu:
                    while (true) {
                        System.out.println("===========================================================");
                        System.out.println("1. Показать весь товар магазина");
                        System.out.println("2. Добавить товар в заказ");
                        System.out.println("3. Удалить товар из заказа");
                        System.out.println("4. Удалить весь товар из заказа");
                        System.out.println("5. Сформировать заказ");
                        System.out.println("6. Оплата заказа");
                        System.out.println("7. Сортировка товара");
                        System.out.println("8. Пополнить бюджет");
                        System.out.println("0. Назад");
                        System.out.println("===========================================================");

                        System.out.println(customer);
                        switch (Operations.inputNumber()) {
                            case 1:
                                System.out.println("===========================================================");
                                Operations.doAction(CustomerAct.VIEW, customer);
                                break;
                            case 2:
                                System.out.println("===========================================================");
                                Operations.doAction(CustomerAct.ADD, customer);
                                break;
                            case 3:
                                System.out.println("===========================================================");
                                Operations.doAction(CustomerAct.REMOVE, customer);
                                break;
                            case 4:
                                System.out.println("===========================================================");
                                Operations.doAction(CustomerAct.REMOVEALL, customer);
                                break;
                            case 5:
                                System.out.println("===========================================================");
                                Operations.doAction(CustomerAct.VIEWORDER, customer);
                                break;
                            case 6:
                                System.out.println("===========================================================");
                                Operations.doAction(CustomerAct.PAYORDER, customer);
                                break;
                            case 7:
                                System.out.println("===========================================================");
                                label:
                                while (true) {
                                    System.out.println("1. По цене");
                                    System.out.println("2. По наименованию");
                                    System.out.println("3. По количеству");
                                    System.out.println("0. Назад");

                                    switch (Operations.inputNumber()) {
                                        case 1:
                                            Operations.sortServices(SortingIndex.PRICE);
                                            break label;
                                        case 2:
                                            Operations.sortServices(SortingIndex.NAME);
                                            break label;
                                        case 3:
                                            Operations.sortServices(SortingIndex.NUMBER);
                                            break label;
                                        case 0:
                                            System.out.println("===========================================================");
                                            break label;
                                        default:
                                            System.out.println("Неверный выбор. Повторите");
                                    }
                                }
                                break;
                            case 8:
                                System.out.println("===========================================================");
                                Operations.doAction(CustomerAct.RECHARGEBUDGET, customer);
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
