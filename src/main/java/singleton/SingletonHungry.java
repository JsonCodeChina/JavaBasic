package singleton;


/**
 * 饿汉式：在类初始化直接创建实例对象，不管你是否需要这个对象都会被创建
 */
public class SingletonHungry {

    private  SingletonHungry(){

    }

    public static final SingletonHungry instance;

    static {
        instance = new SingletonHungry();
    }



}
