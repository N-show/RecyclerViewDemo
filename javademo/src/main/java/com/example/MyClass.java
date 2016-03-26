package com.example;

import java.util.Random;

public class MyClass {

    public static void main(String args[]) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int a= random.nextInt(900) * 10;
            System.out.println("---" + a);
        }
    }
}
