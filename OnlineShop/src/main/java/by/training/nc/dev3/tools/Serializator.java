package by.training.nc.dev3.tools;

/**
 * Created by Дмитрий on 20.03.2017.
 */
import by.training.nc.dev3.beans.Human;

import java.io.*;

public class Serializator {
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
        } catch (IOException ioe){
            System.err.println("Общая I/O ошибка: " + ioe);
        } finally{
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

//    public static void write(String fileName, int text) {
//        File file = new File(fileName);
//        try {
//            if(!file.exists()){
//                file.createNewFile();
//            }
//            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
//            try {
//                out.print(text);
//            } finally {
//                out.close();
//            }
//        } catch(IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}

