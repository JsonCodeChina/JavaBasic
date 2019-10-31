package stringTest;

public class ValueTest {

    public static void change(String s){
        s += " world ";
        System.out.println(s);
    }


    public static void main(String[] args) {

        String s = "hello";
        change(s);
        System.out.println(s);

    }
}
