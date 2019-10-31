package JUC.demoFromCSDN;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListTest {



    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            String str = (String) iterator.next();
            if(str.equals("c")){
                list.remove(str);
            }else{
                System.out.println(str);
            }

        }



    }
}
