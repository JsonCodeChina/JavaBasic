package jvm.ref;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo {


    public static void memoryEnough(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(softReference.get());

    }

    public static void memoryNotEnough(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;

        try {
            byte[] bytes = new byte[30*1024*1024];
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }

    }


    public static void main(String[] args) {
        //memoryEnough();
        memoryNotEnough();
    }
}
