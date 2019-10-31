package JUC.cas;

import java.util.concurrent.atomic.AtomicReference;


class User{
    String userName;
    int age;

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}


public class AtomicReferenceDemo {

    public static void main(String[] args) {
        User u1 = new User("shen",18);
        User u2 = new User("bo",20);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(u1);

        System.out.println(atomicReference.compareAndSet(u1,u2)+"\t"+atomicReference.get());
        System.out.println(atomicReference.compareAndSet(u1,u2)+"\t"+atomicReference.get());


    }
}
