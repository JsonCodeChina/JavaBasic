package jvm.exception;

public class MetaspaceOOMTest {

    static class OOM
    {

    }

    public static void main(String[] args) {
        int i = 0;
        try {
            while(true){
                i++;
//                Enhancer enhancer = new Enhancer();

            }
        }catch(Throwable e){
            System.out.println("多少次后发生了异常"+i);
            e.printStackTrace();
        }
    }
}
