package com.example.demo.validator;

public class NumberValueValidator implements IValidator {
    @Override
    public boolean isValid(String value) {
        return value.chars().allMatch(Character::isDigit);
    }
}
