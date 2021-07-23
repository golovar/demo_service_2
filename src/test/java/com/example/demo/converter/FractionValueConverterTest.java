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
class FractionValueConverterTest {

    @Mock
    private FractionConverter fractionConverter;

    @Test
    void convertMessage() {
        Mockito.when(fractionConverter.convertMessage("6/2")).thenReturn(new MessageData("6/2", 3));
        Mockito.when(fractionConverter.convertMessage("5/8/2")).thenReturn(null);

        MessageData messageData = fractionConverter.convertMessage("6/2");
        assertNotNull(messageData);

        MessageData messageDataNull = fractionConverter.convertMessage("5/8/2");
        assertNull(messageDataNull);
    }
}