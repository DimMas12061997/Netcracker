package by.training.nc.dev3.tools;


import by.training.nc.dev3.beans.Customer.Customer;
import by.training.nc.dev3.beans.Good;
import by.training.nc.dev3.beans.Human;

import java.io.*;
import java.util.*;

public class FileWorker {
    public final static String filePath = "E://NetCracker//Netcracker//OnlineShop//src//main//java//by//training//nc//dev3//files//";

    public boolean serialization(Human s, String fileName) {
        boolean flag = false;
        File f = new File(fileName);
        ObjectOutputStream ostream = null;
        try {
            FileOutputStream fos = new FileOutputStream(f);
            if (fos != null) {
                ostream = new ObjectOutputStream(fos);
                ostream.writeObject(s);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не может быть создан: " + e);
        } catch (NotSerializableException e) {
            System.err.println("Класс не поддерживает сериализацию: " + e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (ostream != null) {
                    ostream.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка закрытия потока");
            }
        }
        return flag;
    }

    public Human deserialization(String fileName) throws InvalidObjectException {
        File fr = new File(fileName);
        ObjectInputStream istream = null;
        try {
            FileInputStream fis = new FileInputStream(fr);
            istream = new ObjectInputStream(fis);
            Human st = (Human) istream.readObject();
            return st;
        } catch (ClassNotFoundException ce) {
            System.err.println("Класс не существует: " + ce);
        } catch (
                FileNotFoundException e) {
            System.err.println("Файл для десериализации не существует: " + e);
        } catch (InvalidClassException ioe) {
            System.err.println("Несовпадение версий классов: " + ioe);
        } catch (IOException ioe) {
            System.err.println("Общая I/O ошибка: " + ioe);
        } finally {
            try {
                if (istream != null) {
                    istream.close();
                }
            } catch (IOException e) {
                System.err.println("ошибка закрытия потока ");
            }
        }
        throw new InvalidObjectException("Объект не восстановлен");
    }

    public static List<Good> readObject(String fileName) {
        File fr = new File(fileName);
        ObjectInputStream istream = null;
        List<Good> st = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(fr);
            istream = new ObjectInputStream(fis);
            st = (List<Good>) istream.readObject();

        } catch (ClassNotFoundException ce) {
            System.err.println("Класс не существует: " + ce);
        } catch (
                FileNotFoundException e) {
            System.err.println("Файл для десериализации не существует: " + e);
        } catch (InvalidClassException ioe) {
            System.err.println("Несовпадение версий классов: " + ioe);
        } catch (IOException ioe) {
            System.err.println("Общая I/O ошибка: " + ioe);
        } finally {
            try {
                if (istream != null) {
                    istream.close();
                }
            } catch (IOException e) {
                System.err.println("ошибка закрытия потока ");
            }
        }
        return st;
    }

    public static void writeObject(List<Good> list, File file) {
        boolean flag = false;
        ObjectOutputStream ostream = null;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (fos != null) {
                ostream = new ObjectOutputStream(fos);
                ostream.writeObject(list);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не может быть создан: " + e);
        } catch (NotSerializableException e) {
            System.err.println("Класс не поддерживает сериализацию: " + e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (ostream != null) {
                    ostream.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка закрытия потока");
            }
        }
    }

    public static void writeOrder(Map<Customer, List<Good>> list, File file) {
        boolean flag = false;
        ObjectOutputStream ostream = null;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (fos != null) {
                ostream = new ObjectOutputStream(fos);
                ostream.writeObject(list);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не может быть создан: " + e);
        } catch (NotSerializableException e) {
            System.err.println("Класс не поддерживает сериализацию: " + e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (ostream != null) {
                    ostream.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка закрытия потока");
            }
        }
    }

    public static Map<Customer, List<Good>> readOrder(String fileName) {
        File fr = new File(fileName);
        ObjectInputStream istream = null;
        Map<Customer, List<Good>> st = new HashMap<>();
        try {
            FileInputStream fis = new FileInputStream(fr);
            istream = new ObjectInputStream(fis);
            st = (Map<Customer, List<Good>>) istream.readObject();

        } catch (ClassNotFoundException ce) {
            System.err.println("Класс не существует: " + ce);
        } catch (
                FileNotFoundException e) {
            System.err.println("Файл для десериализации не существует: " + e);
        } catch (InvalidClassException ioe) {
            System.err.println("Несовпадение версий классов: " + ioe);
        } catch (IOException ioe) {
            System.err.println("Общая I/O ошибка: " + ioe);
        } finally {
            try {
                if (istream != null) {
                    istream.close();
                }
            } catch (IOException e) {
                System.err.println("ошибка закрытия потока ");
            }
        }
        return st;
    }


    public static List<String> readFile(File file) {
        List<String> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (sc.hasNext()) {
                list.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден..." + file.getName());
        }
        return list;
    }


    public static void write(List<Good> list, File file, boolean flag) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, flag)))) {
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                pw.println(it.next());
            }
            System.out.println("Запись успешно произведена в файл \"" + file.getName() + "\"");
        } catch (IOException e) {
            System.out.println("Ошибка записи. Невозможно создать файл \"" + file.getName() + "\"");
        }
    }
}
