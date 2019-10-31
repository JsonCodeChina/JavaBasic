package contain;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class ContainNotsafeDemo {

    public void changeValue(String str){
        str += "4";
        System.out.println(str);
    }

    public static void main(String[] args) {
        ContainNotsafeDemo test = new ContainNotsafeDemo();

//        Set<String> set = Collections.synchronizedSet(new HashSet<>());

//        Set<String> set = new CopyOnWriteArraySet();
//        for(int i = 1; i <= 10 ;i++)
//        {
//            new Thread(()->{
//
//                set.add(UUID.randomUUID().toString().substring(0,8));
//                System.out.println(set);
//
//            },String.valueOf(i)).start();
//        }

        String str = "123";
        String str2 = "123";
        int a = 1;
        int b = 2;
        String str1 = new String("123");
        System.out.println(a == b);
//        test.changeValue(str);
//        System.out.println(str);

    }
}
