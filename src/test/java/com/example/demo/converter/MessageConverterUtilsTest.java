package com.example.demo.converter;

import com.example.demo.beans.MessageData;
import com.example.demo.validator.MessageType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class MessageConverterUtilsTest {

    @Test
    void convertMessage() {
        try (MockedStatic<MessageConverterUtils> utilities = Mockito.mockStatic(MessageConverterUtils.class)) {
            utilities.when(() -> MessageConverterUtils.convertMessage(MessageType.STRING, "5"))
                    .thenReturn(new MessageData("5", 5));

            MessageData messageData = MessageConverterUtils.convertMessage(MessageType.STRING, "5");
            assertEquals(messageData, new MessageData("5", 5));
        }
    }
}