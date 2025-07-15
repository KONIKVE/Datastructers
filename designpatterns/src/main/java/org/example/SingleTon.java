package org.example;

import java.util.ArrayList;

public class SingleTon {

    private static SingleTon SINGLE_TON;
    private SingleTon(){

    }
    public static SingleTon getSingleTon() {
        if (SINGLE_TON == null) {
            synchronized (SingleTon.class) {
                if (SINGLE_TON == null) {
                    SINGLE_TON = new SingleTon();
                }
            }
        }
        return SINGLE_TON;
    }

    public static void m1(int ... a){


    }

    public static void main(String[] args) {
        m1();
        m1(10);
        m1(10,20,30);
        m1(new int[]{10,20});
//        m1(new int[]{10,20},19);

    }
}
