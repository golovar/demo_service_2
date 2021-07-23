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
class NumberValueValidatorTest {

    @Mock
    private NumberValueValidator numberValueValidator;

    @Test
    void isValid() {
        Mockito.when(numberValueValidator.isValid("6")).thenReturn(true);
        Mockito.when(numberValueValidator.isValid("Q")).thenReturn(false);

        boolean isTrue = numberValueValidator.isValid("6");
        assertEquals(true, isTrue);

        boolean isFalse = numberValueValidator.isValid("Q");
        assertEquals(false, isFalse);
    }
}