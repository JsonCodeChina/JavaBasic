package JUC.lock;

import java.util.concurrent.TimeUnit;

/**
 * 1 标准访问的时候是先发邮件还是先发短信？
 * 2 sendEmail方法暂停四秒种后，先发邮件还是先发短信？
 *      1 2 某一个时刻内，只能有唯一一个线程去访问这些synchronized方法
 *          也就是说，锁的是当前对象this 被锁定后 其它的线程不能进入到当
 *          前对象其它的synchronized方法
 * 3 新增普通方法 先打印邮件还是调用普通方法？
 *      3 加个普通方法后发现和同步锁无关
 * 4 二部手机，请问先打印邮件还是短信？
 *      4 锁的是各自的对象，互不影响
 * 5 二个静态同步方法，同一部手机，请问先打印邮件还是短信？
 * 6 二个静态同步方法，二部手机，请问先打印邮件还是短信？
 *      5 6 当静态方法加锁后 锁的是类对象
 *
 * 7 一个静态同步方法，一个普通同步方法，同一部手机，请问先打印邮件还是先打印短信？
 * 8 一个静态同步方法，一个普通同步方法，二部手机，请问先打印邮件还是先打印短信？
 *      7 8 类锁和对象锁 静态方法锁的是类 其他对象调用时需等待释放锁
 *                     非静态方法是对象锁 无需等待类锁的释放
 *
 */
class Phone{
    public static synchronized void sendEmail() throws Exception
    {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("====send email");
    }

    public  synchronized void sendMessage() throws  Exception
    {
        System.out.println("====send message");
    }

    public void sayHello(){
        System.out.println("====getHello");
    }
}


public class Lock_8 {

    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"a").start();

        Thread.sleep(100);

        new Thread(()->{
            try {
                //phone.sendMessage();
                phone2.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"b").start();
    }

}
