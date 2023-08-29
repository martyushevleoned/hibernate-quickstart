package org.example.tables.enums;

import javax.persistence.AttributeConverter;

public class IsOfficialConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {
        return aBoolean ? "T" : "F";
    }

    @Override
    public Boolean convertToEntityAttribute(String s) {
        switch (s) {
            case "T" -> {
                return true;
            }
            case "F" -> {
                return false;
            }
            default -> {
                return null;
            }
        }
    }
}
