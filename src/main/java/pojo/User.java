package pojo;

public class User {
    private String name;

    private String getPrname(){
        return "prJava";
    }

    public String getPuname(){
        return "puJava";
    }

    static {
        System.out.println("here is User static");
    }



}
