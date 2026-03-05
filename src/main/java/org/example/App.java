package org.example;

import org.example.database.DataBase;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        System.out.println("Hello World!");

        DataBase.getConnection();
    }
}
