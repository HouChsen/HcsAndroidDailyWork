package com.he.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 86186 on 2022/5/16.
 */
public class Server {
    private final int ServerPort=29898;
    private ServerSocket serverSocket=null;
    private Socket socket=null;
    private OutputStream outputStream=null;
    private InputStream inputStream=null;
    private PrintWriter printWriter=null;
    private BufferedReader reader=null;

    public Server(){
        /*


                                                                    这里只是展示代码，实际运行在Eclipse
                                                                    这里只是展示代码，实际运行在Eclipse
                                                                    这里只是展示代码，实际运行在Eclipse
                                                                    这里只是展示代码，实际运行在Eclipse
                                                                    这里只是展示代码，实际运行在Eclipse




 */

        try{
            serverSocket=new ServerSocket(ServerPort);
            System.out.println("服务启动...");
            socket=serverSocket.accept();
            System.out.println("客户端已连接...\n");
        }catch(IOException e){
            e.printStackTrace();
        }
        try{
            outputStream=socket.getOutputStream();
            inputStream=socket.getInputStream();
            printWriter=new PrintWriter(outputStream,true);
            reader=new BufferedReader(new InputStreamReader(inputStream));
            while(true){
                String message=reader.readLine();
                System.out.println("来自客户端的信息"+message);
                if(message.equals("Bye")||message.equals("bye"))
                    break;
                printWriter.println("服务器已接收");
                printWriter.flush();
            }
            outputStream.close();
            inputStream.close();
            socket.close();
            serverSocket.close();
            System.out.println("客户端关闭连接");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){//192.168.1.106
        new Server();
    }
}
