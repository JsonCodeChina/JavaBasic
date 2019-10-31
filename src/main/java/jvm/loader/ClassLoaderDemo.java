package jvm.loader;

import javafx.beans.binding.ObjectExpression;

class T {

}


public class ClassLoaderDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        T t1 = new T();

        System.out.println(Object.class.getClassLoader());

        System.out.println(T.class.getClassLoader());
        System.out.println(T.class.getClassLoader().getParent());
        System.out.println(T.class.getClassLoader().getParent().getParent());

    }
}
