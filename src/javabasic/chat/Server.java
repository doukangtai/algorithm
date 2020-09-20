package javabasic.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2020/09/09
 */
public class Server {

    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream inputStream;
    private List<Socket> userSocketList = new ArrayList<>();

    public void accept() {
        try {
            serverSocket = new ServerSocket(8888);
            while (true) {
                socket = serverSocket.accept();
                userSocketList.add(socket);
                new ServerThread(serverSocket, socket, userSocketList).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void main(String[] args) {
        new Server().accept();
    }

}

class ServerThread extends Thread {

    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private List<Socket> userSocketList;

    public ServerThread(ServerSocket serverSocket, Socket socket, List<Socket> userSocketList) {
        this.serverSocket = serverSocket;
        this.socket = socket;
        this.userSocketList = userSocketList;
    }

    @Override
    public void run() {
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            while (true) {
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(bytes)) != -1) {
                    for (Socket userSocket : userSocketList) {
                        userSocket.getOutputStream().write(bytes, 0, len);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
