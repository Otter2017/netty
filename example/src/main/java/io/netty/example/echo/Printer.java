package io.netty.example.echo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Printer implements Runnable{
 private static    Logger logger = LoggerFactory.getLogger(Printer.class);
    @Override
    public void run() {
        logger.info("printing...");
    }
}
