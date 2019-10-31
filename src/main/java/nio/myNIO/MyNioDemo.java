package nio.myNIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MyNioDemo {

    public static void main(String[] args) {
       //traditionIO();
        nioFile();


    }

    private static void nioFile() {
        RandomAccessFile aFile = null;

        try {
            aFile = new RandomAccessFile("s.txt","rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            int read = fileChannel.read(buf);
            System.out.println(read);
            while (read!=-1){
                buf.flip();
                while(buf.hasRemaining()){
                    System.out.print((char)buf.get()+" ");
                }
                buf.clear();
                read = fileChannel.read(buf);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(aFile!=null){
                try {
                    aFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void traditionIO() {
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("s.txt"));
            byte[] buf = new byte[1024];
            int read = 0;
            while((read = in.read(buf))!=-1){
                   String s =  new String(buf,0,read);
                System.out.println(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in !=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
