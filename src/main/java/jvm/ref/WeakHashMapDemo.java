package jvm.ref;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

    public static void main(String[] args) {
       //myHashMap();

       myWeakHashMap();
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer,String> map = new WeakHashMap<>();
        Integer key = new Integer(1 );
        String value = "HashMap";
        map.put(key,value);
        System.out.println(map); //1=hashmap

        key = null;
        System.out.println(map); //1=hashmap

        System.gc();
        System.out.println(map+"\t"+map.size()); //{} 0

    }

    private static void myHashMap() {
        HashMap<Integer,String> map = new HashMap<>();
        Integer key = new Integer(1 );
        String value = "HashMap";
        map.put(key,value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map+"\t"+map.size());

    }
}
