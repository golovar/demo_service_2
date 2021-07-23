package com.example.demo.converter;

import com.example.demo.beans.MessageData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class StringValueConverterTest {

    @Mock
    private StringConverter stringConverter;

    @Test
    void convertMessage() {
        Mockito.when(stringConverter.convertMessage("6")).thenReturn(new MessageData("6", 6));
        Mockito.when(stringConverter.convertMessage("X")).thenReturn(null);

        MessageData messageData = stringConverter.convertMessage("6");
        assertNotNull(messageData);

        MessageData messageDataNull = stringConverter.convertMessage("X");
        assertNull(messageDataNull);
    }
}