package by.training.nc.dev3.tools;


import by.training.nc.dev3.beans.Customer;
import by.training.nc.dev3.beans.Goods;

import java.io.*;
import java.util.*;

public class FileWorker {
    private final static String filePath = "src//main//resources//";

    public static String getFilePath() {
        return filePath;
    }

    /**
     * Reads to the list
     *
     * @param fileName - file name
     * @return - list of services
     */
    public static List<?> readObject(String fileName) {
        File fr = new File(fileName);
        ObjectInputStream istream = null;
        List<?> st = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(fr);
            istream = new ObjectInputStream(fis);
            st = (List<?>) istream.readObject();
        } catch (ClassNotFoundException ce) {
            System.out.println("Класс не существует");
        } catch (
                FileNotFoundException e) {
            System.out.println("Файл для десериализации не существует");
        } catch (InvalidClassException ioe) {
            System.out.println("Несовпадение версий классов");
        } catch (IOException ioe) {
            System.out.println("");
        } finally {
            try {
                if (istream != null) {
                    istream.close();
                }
            } catch (IOException e) {
                System.out.println("ошибка закрытия потока ");
            }
        }
        return st;
    }

    /**
     * Writes a list to a file
     *
     * @param list - list of services
     * @param file - output file
     */
    public static void writeObject(List<?> list, File file) {
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
            System.out.println("Файл не может быть создан");
        } catch (NotSerializableException e) {
            System.out.println("Класс не поддерживает сериализацию");
        } catch (IOException e) {
            System.out.println("Ошибка");
        } finally {
            try {
                if (ostream != null) {
                    ostream.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка закрытия потока");
            }
        }
    }

    /**
     * Writes a map to a file
     *
     * @param list - map of order
     * @param file - output file
     */
    public static void writeOrder(Map<Customer, List<Goods>> list, File file) {
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
            System.out.println("Файл не может быть создан");
        } catch (NotSerializableException e) {
            System.out.println("Класс не поддерживает сериализацию");
        } catch (IOException e) {
            System.out.println("Ошибка!");
        } finally {
            try {
                if (ostream != null) {
                    ostream.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка закрытия потока");
            }
        }
    }

    /**
     * Reads to the map
     *
     * @param fileName - file name
     * @return -  map of order
     */
    public static Map<Customer, List<Goods>> readOrder(String fileName) {
        File fr = new File(fileName);
        ObjectInputStream istream = null;
        Map<Customer, List<Goods>> st = new HashMap<>();
        try {
            FileInputStream fis = new FileInputStream(fr);
            istream = new ObjectInputStream(fis);
            st = (Map<Customer, List<Goods>>) istream.readObject();

        } catch (ClassNotFoundException ce) {
            System.out.println("Класс не существует");
        } catch (
                FileNotFoundException e) {
            System.out.println("Файл для десериализации не существует");
        } catch (InvalidClassException ioe) {
            System.out.println("Несовпадение версий классов");
        } catch (IOException ioe) {
            System.out.println("");
        } finally {
            try {
                if (istream != null) {
                    istream.close();
                }
            } catch (IOException e) {
                System.out.println("ошибка закрытия потока ");
            }
        }
        return st;
    }

    /**
     * Reads the profit of the store
     *
     * @param file - Object file
     * @return - Online store profits
     */
    public static double readFile(File file) {
        double str = 0;
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (sc.hasNext())
                str = Double.parseDouble(sc.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден..." + file.getName());
        }
        return str;
    }

    /**
     * Records the profit of the store
     *
     * @param info - profit
     * @param file - output file
     */
    public static void write(double info, File file) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            pw.println(info);
        } catch (IOException e) {
            System.out.println("Ошибка записи. Невозможно создать файл \"" + file.getName() + "\"");
        }
    }

    /**
     * Writes string to file in bytes
     *
     * @param info - string with information about the customer
     * @param file - output file
     * @return - true, if successful record, otherwise false
     */
    public static boolean writeByteFile(String info, File file) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file, true))) {
            bos.write(info.getBytes());
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка записи. Невозможно создать файл \"" + file.getName() + "\"");
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Reads string from file in bytes
     *
     * @param file - input file
     * @return - string with information about customers
     */
    public static String readByteFile(File file) {
        String str = "";
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            byte arr[] = new byte[bis.available()];
            bis.read(arr);
            str = new String(arr);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден..." + file.getName());
        } catch (IOException e) {
        }
        return str;
    }
}

