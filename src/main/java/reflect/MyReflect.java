package reflect;

import pojo.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyReflect {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<?> c = Class.forName("pojo.User");
        User user = (User) c.newInstance();

        Method getPrname = c.getDeclaredMethod("getPrname", null);
        getPrname.setAccessible(true);
        Object o = getPrname.invoke(user, null);

        Method getPuname = c.getMethod("getPuname", null);
        Object o1 = getPuname.invoke(user, null);

        System.out.println(o);
    }
}
