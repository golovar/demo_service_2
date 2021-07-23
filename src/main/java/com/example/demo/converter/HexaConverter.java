package com.example.demo.converter;

import com.example.demo.beans.MessageData;

public class HexaConverter implements IConverter {
    @Override
    public MessageData convertMessage(String message) {
        MessageData messageData = new MessageData();
        messageData.setStrValue(message);
        messageData.setNumberValue(Long.parseLong(message, 16));
        return messageData;
    }
}
