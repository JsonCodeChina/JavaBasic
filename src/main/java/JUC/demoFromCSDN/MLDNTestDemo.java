package JUC.demoFromCSDN;

import java.util.ArrayList;
import java.util.List;

public class MLDNTestDemo {
    public static void main(String[] args) {
        List<String> all = new ArrayList<String>();
        for(int x = 0;x<20;x++){
            int temp = x;
            new Thread(()->{
                for (int y = 0;y<30;y++) {
                    all.add(Thread.currentThread().getName() + " - " + temp + " - " + y);
                    System.out.println(all);
                }

            }).start();
        }
    }
}
