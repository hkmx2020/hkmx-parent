package com.hkmx.tcp;

import sun.security.util.Cache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @author maoxwa
 * @version 1.0
 * @date 2021/4/2 0:12
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.setSoTimeout(3000);
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(), 2000), 3000);

        System.out.println("已发起服务器连接， 并进入后续流程");
        System.out.println("客户端信息：" + socket.getLocalAddress() + ", p:" + socket.getLocalPort());
        System.out.println("服务器信息：" + socket.getInetAddress() + ", p:" + socket.getPort());

        try {
            todo(socket);
        } catch (IOException e) {
            System.out.println("异常关闭");
        }

        socket.close();
        System.out.println("客户端已经退出");
    }

    private static void todo(Socket socket) throws IOException {
        // 构建键盘输入流
        InputStream in = System.in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

        // 得到socket输出流， 并转换为打印流
        OutputStream socketOutputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(socketOutputStream);

        // 得到socket输入流
        InputStream socketInputStream = socket.getInputStream();
        BufferedReader socketBufferReader = new BufferedReader(new InputStreamReader(socketInputStream));

        boolean flag = true;
        do {
            // 读取一行数据
            String line = bufferedReader.readLine();
            // 发送到服务器
            printStream.println(line);

            // 从服务器读取一行
            String echo = socketBufferReader.readLine();
            if ("bye".equals(echo)) {
                flag = false;
            } else {
                System.out.println(echo);
            }
        } while (flag);


        printStream.close();
        socketOutputStream.close();


    }

}
