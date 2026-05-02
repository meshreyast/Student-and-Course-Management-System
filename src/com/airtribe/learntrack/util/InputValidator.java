package com.airtribe.learntrack.util;

import com.airtribe.learntrack.exception.InvalidInputException;

public class InputValidator {

    public static int parseIntInput (String input, String fieldName) throws InvalidInputException {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw  new InvalidInputException(fieldName + " must be a valid number.");
        }
    }

    public static String parseStringInput (String input, String fieldName) throws InvalidInputException {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInputException(fieldName + " cannot be empty");
        }
        return input.trim();
    }
}
