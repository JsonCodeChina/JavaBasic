package basic.loadSequence;

class Father   ///Father.class--Son.class -Father Instance--Son Instance
{
    private int i = test();

    {
        System.out.println("222222");
    }
    public Father(){
        System.out.println("111111");
    }

    static{
        System.out.println("333333");
    }

    public int test(){
        System.out.println("xxxx");
        return 1;
    }
}
class Son extends Father
{

    private int i = test();
    {
        System.out.println("555555");
    }
    public Son()
    {
        System.out.println("444444");
    }

    static{
        System.out.println("666666");
    }

    public int test(){
        System.out.println("sssss");
        return 1;
    }
}
public class Test {


    public static void main(String[] args) {
        new Son();//从父到子，静态先行 362154
        System.out.println("======================");
        new Son();//2154
        System.out.println("======================");
        new Father();//21
    }
}
