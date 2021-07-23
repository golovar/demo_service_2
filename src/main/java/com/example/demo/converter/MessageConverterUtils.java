package com.example.demo.converter;

import com.example.demo.beans.MessageData;
import com.example.demo.validator.MessageType;

import java.util.HashMap;
import java.util.Map;

public class MessageConverterUtils {
    private static Map<MessageType, IConverter> converterMap = new HashMap<>();

    static {
        converterMap.put(MessageType.HEXA, new HexaConverter());
        converterMap.put(MessageType.STRING, new StringConverter());
        converterMap.put(MessageType.FRACTION, new FractionConverter());
    }

    private MessageConverterUtils() {
    }

    public static MessageData convertMessage(MessageType messageType, String value) {
        return converterMap.get(messageType).convertMessage(value);
    }
}
