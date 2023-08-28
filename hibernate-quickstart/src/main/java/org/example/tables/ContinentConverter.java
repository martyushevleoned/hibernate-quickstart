package org.example.tables;

import javax.persistence.AttributeConverter;

public class ContinentConverter implements AttributeConverter<Continent, String> {
    @Override
    public String convertToDatabaseColumn(Continent continent) {
        switch (continent) {
            case ASIA -> {
                return "Asia";
            }
            case EUROPE -> {
                return "Europe";
            }
            case NORTH_AMERICA -> {
                return "North America";
            }
            case AFRICA -> {
                return "Africa";
            }
            case OCEANIA -> {
                return "Oceania";
            }
            case ANTARCTICA -> {
                return "Antarctica";
            }
            case SOUTH_AMERICA -> {
                return "South America";
            }
            default -> {
                return null;
            }
        }
    }

    @Override
    public Continent convertToEntityAttribute(String s) {
        switch (s) {
            case "Asia" -> {
                return Continent.ASIA;
            }
            case "Europe" -> {
                return Continent.EUROPE;
            }
            case "North America" -> {
                return Continent.NORTH_AMERICA;
            }
            case "Africa" -> {
                return Continent.AFRICA;
            }
            case "Oceania" -> {
                return Continent.OCEANIA;
            }
            case "Antarctica" -> {
                return Continent.ANTARCTICA;
            }
            case "South America" -> {
                return Continent.SOUTH_AMERICA;
            }
            default -> {
                return null;
            }
        }
    }
}
