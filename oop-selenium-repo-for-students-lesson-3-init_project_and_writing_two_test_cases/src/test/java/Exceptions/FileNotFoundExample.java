package Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileNotFoundExample{

    public static void main(String[] args)  {
        File file = new File("path");
        try {
            FileReader reader = new FileReader(file);
            System.out.println("Опасный код");
        } catch (FileNotFoundException exception) {
            System.out.println("Поймано исключение");
        }finally {
            System.out.println("Итоговое сообщение");
        }
        FileReaderExample reader = new FileReaderExample();
        try {
            reader.readFile("/path/");
        } catch (FileNotFoundException exception){
            exception.printStackTrace();
        }
    }
}
