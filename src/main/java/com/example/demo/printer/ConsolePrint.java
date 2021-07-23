package com.example.demo.printer;

import com.example.demo.beans.MessageData;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsolePrint implements IPrinter {

    @Override
    public void print(MessageData messageData, double sum) {
        log.info(messageData.getStrValue() + " " + sum);
    }
}
