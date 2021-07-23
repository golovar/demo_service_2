package com.example.demo.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class HexaValueValidatorTest {

    @Mock
    private HexaValueValidator hexaValueValidator;

    @Test
    void isValid() {
        Mockito.when(hexaValueValidator.isValid("A")).thenReturn(true);
        Mockito.when(hexaValueValidator.isValid("Z")).thenReturn(false);

        boolean isTrue = hexaValueValidator.isValid("A");
        assertEquals(true, isTrue);

        boolean isFalse = hexaValueValidator.isValid("Z");
        assertEquals(false, isFalse);
    }
}