package org.example;

import java.util.ArrayList;
import java.util.List;

public class Fibnoci {


    private static int fibnoci(int n1,int n2){
        return n1+n2;
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for (int i = 2; i < 10; i++) {
            list.add(fibnoci(list.get(list.size()-2),list.get(list.size()-1)));
        }
        System.out.println(list);
    }


}
