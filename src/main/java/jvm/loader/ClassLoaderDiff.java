package jvm.loader;

import pojo.User;

public class ClassLoaderDiff {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader cl = User.class.getClassLoader();

        Class c = Class.forName("pojo.User");
    }
}
