package com.example.demo.converter;

import com.example.demo.beans.MessageData;

public interface IConverter {
    MessageData convertMessage(String message);
}
