package io.NIO.chat;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ChatClientStart {

    public static void main(String[] args) throws IOException {
        ChatClient chatClient = new ChatClient();

        new Thread(()->{
            while (true){
                try {
                    chatClient.receiveMessageFromServer();
                    try{TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e){e.printStackTrace();}
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            },"client").start();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String msg = scanner.nextLine();
            chatClient.sendMessageToServer(msg);
        }
    }
}
