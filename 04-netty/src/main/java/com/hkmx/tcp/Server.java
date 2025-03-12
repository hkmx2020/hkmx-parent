package com.hkmx.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author maoxwa
 * @version 1.0
 * @date 2021/4/2 0:12
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2000);

        System.out.println("服务器准备就绪");
        System.out.println("服务器信息：" + serverSocket.getInetAddress() + ", p:" + serverSocket.getLocalPort());

        for (; ; ) {
            Socket socket = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(socket);
            clientHandler.start();
        }

    }

    /**
     * 客户端处理
     */
    private static class ClientHandler extends Thread {

        private Socket socket;
        private boolean flag = true;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("客户端信息：" + socket.getInetAddress() + ", p:" + socket.getPort());

            try {
                // 用于打印数据
                PrintStream printStream = new PrintStream(socket.getOutputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                do {
                    String str = bufferedReader.readLine();
                    if ("bye".equals(str)) {
                        flag = false;
                    } else {
                        // 打印到屏幕， 并回送数据
                        printStream.println(str);
                        System.out.println("回送:" + str.length());
                    }
                } while (flag);
                bufferedReader.close();
                printStream.close();
            } catch (Exception e) {
                System.out.println("连接异常断开");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("客户端已关闭");
        }

    }
}
