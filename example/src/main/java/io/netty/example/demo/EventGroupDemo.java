package io.netty.example.demo;

import io.netty.channel.DefaultEventLoopGroup;
import io.netty.example.echo.Printer;

import java.util.concurrent.TimeUnit;

public class EventGroupDemo {
    public static void main(String[] args){
        DefaultEventLoopGroup group =new DefaultEventLoopGroup(4);
       for(int i =1;i<10;i++){
           group.scheduleAtFixedRate(new Printer(),i,i, TimeUnit.SECONDS);
       }
       try{
       group.awaitTermination(5,TimeUnit.MINUTES);}catch (Exception ex){}finally {
           group.shutdownGracefully();
       }
    }
}
