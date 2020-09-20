package javabasic.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 窦康泰
 * @date 2020/09/09
 */
public class Client {

    public void send() {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            socket = new Socket("127.0.0.1", 8888);
            new ReceiveClientThread(socket).start();
            new SendClientThread(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            if (outputStream != null) {
//                try {
//                    outputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (socket != null) {
//                try {
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

}

class M1 {
    public static void main(String[] args) {
        new Client().send();
    }
}

class M2 {
    public static void main(String[] args) {
        new Client().send();
    }
}

class M3 {
    public static void main(String[] args) {
        new Client().send();
    }
}

class SendClientThread extends Thread {

    private Socket socket;

    public SendClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
            Scanner in = new Scanner(System.in);
            while (true) {
                String s = in.next();
                outputStream.write(s.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReceiveClientThread extends Thread {

    private Socket socket;

    public ReceiveClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            while (true) {
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(bytes)) != -1) {
                    System.out.println(new String(bytes, 0, len));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            if (inputStream != null) {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (socket != null) {
//                try {
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}
