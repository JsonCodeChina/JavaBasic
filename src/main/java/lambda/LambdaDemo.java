package lambda;

/**
 * default static
 */
@FunctionalInterface
interface Foo{
    public void sayHello();
    //public void sayBye();
}

public class LambdaDemo {

    public static void main(String[] args) {
//        Foo foo = new Foo() {
//            @Override
//            public void sayHello() {
//                System.out.println("ss");
//            }
//
//            @Override
//            public void sayBye() {
//
//            }
//        };
        Foo foo = ()-> {
            System.out.println("sx");
        };

        foo.sayHello();

    }
}
