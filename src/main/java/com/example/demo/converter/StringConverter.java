package com.example.demo.converter;

import com.example.demo.beans.MessageData;

public class StringConverter implements IConverter {
    @Override
    public MessageData convertMessage(String message) {
        return new MessageData(message, Integer.valueOf(message));
    }
}
