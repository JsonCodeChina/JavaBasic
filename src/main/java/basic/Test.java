package basic;

public class Test {

    public static String  test2(){
        try {
            System.out.println("1");
            return test3();
        }finally {
            System.out.println("2");
        }

    }
    public static String  test3(){
        System.out.println("3");
        return "s";
    }



    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(test2());
    }
}
