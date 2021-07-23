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
class HexaValueConverterTest {

    @Mock
    private HexaConverter hexaConverter;

    @Test
    void convertMessage() {
        Mockito.when(hexaConverter.convertMessage("F")).thenReturn(new MessageData("F", 15));
        Mockito.when(hexaConverter.convertMessage("Z")).thenReturn(null);

        MessageData messageData = hexaConverter.convertMessage("F");
        assertNotNull(messageData);

        MessageData messageDataNull = hexaConverter.convertMessage("Z");
        assertNull(messageDataNull);
    }
}