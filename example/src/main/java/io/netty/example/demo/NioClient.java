package io.netty.example.demo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Random;

public class NioClient {
    public static void main(String[] args) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("172.16.21.230", 8080));
            socketChannel.configureBlocking(false);
            String sendMessage = "hello " + new Random().nextInt(100);
            ByteBuffer buffer = ByteBuffer.wrap(sendMessage.getBytes());
            socketChannel.write(buffer);
            Thread.sleep(2000);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (socketChannel != null) {
                try {
                    socketChannel.close();
                } catch (Exception exx) {
                    exx.printStackTrace();
                }
            }
        }
    }
}
