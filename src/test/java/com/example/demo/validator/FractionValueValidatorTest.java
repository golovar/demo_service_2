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
class FractionValueValidatorTest {

    @Mock
    private FractionValueValidator fractionValueValidator;

    @Test
    void isValid() {
        Mockito.when(fractionValueValidator.isValid("5/8")).thenReturn(true);
        Mockito.when(fractionValueValidator.isValid("5/8/2")).thenReturn(false);

        boolean isTrue = fractionValueValidator.isValid("5/8");
        assertEquals(true, isTrue);

        boolean isFalse = fractionValueValidator.isValid("5/8/2");
        assertEquals(false, isFalse);
    }
}