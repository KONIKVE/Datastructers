package org.example;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {






    public static void main(String[] args) {
        final LinkedHashMap<Integer,String> LRU_CHACHE = new LinkedHashMap(2,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                System.out.println("removeEldestEntry:"+eldest);
                return size() > 2;
            }
        };
        LRU_CHACHE.put(1,"A");
        LRU_CHACHE.put(2,"B");
        System.out.println(LRU_CHACHE);
        LRU_CHACHE.put(2,"B");
        System.out.println(LRU_CHACHE);
        LRU_CHACHE.put(3,"c");
        System.out.println(LRU_CHACHE);
    }

}
