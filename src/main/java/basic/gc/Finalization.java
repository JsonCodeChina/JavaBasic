package basic.gc;

public class Finalization {

    public static Finalization finalization;

    @Override
    protected void finalize(){
        System.out.println("finalized");
        finalization = this;
    }

    public static void main(String[] args) {
        Finalization f = new Finalization();
        System.out.println("first print:"+f);
        f = null;
        System.gc();
        try{
            Thread.currentThread().sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("second print:"+f);
        System.out.println(f.finalization);
    }
}
