package com.example.demo.converter;

import com.example.demo.beans.MessageData;

public class FractionConverter implements IConverter {
    @Override
    public MessageData convertMessage(String message) {
        MessageData messageData = new MessageData();
        messageData.setStrValue(message);

        String[] fractionParts = message.split("/");
        messageData.setNumberValue(divide(Integer.valueOf(fractionParts[0]), Integer.valueOf(fractionParts[1])));
        return messageData;
    }

    private double divide(int num, int den) {
        return num / den;
    }
}
