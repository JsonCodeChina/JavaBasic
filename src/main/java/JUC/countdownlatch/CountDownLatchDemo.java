package JUC.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(5);

        for(int i = 1; i <= 5 ;i++)
        {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 离开教室");
                countDownLatch.countDown();
            },StudentEnums.forEachItem(i).getMessage()).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 大哥关门");

    }
}

enum StudentEnums{
    ONE(1,"沈"),TWO(2,"李"),THREE(3,"赵"),FOUR(4,"孙"),FIVE(5,"钱");

    private Integer code;
    private String message;

    private StudentEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static StudentEnums forEachItem(Integer index){
        for (StudentEnums element:values())
        {
            if(element.getCode() == index){
                return element;
            }
        }
        return null;
    }
}
