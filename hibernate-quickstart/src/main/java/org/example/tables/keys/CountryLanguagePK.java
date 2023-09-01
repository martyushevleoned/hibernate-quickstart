package org.example.tables.keys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguagePK implements Serializable {

    private String countryCode;
    private String language;

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == CountryLanguagePK.class)
            return (Objects.equals(((CountryLanguagePK) obj).getCountryCode(), countryCode) && Objects.equals(((CountryLanguagePK) obj).getLanguage(), language));
        return false;
    }

    @Override
    public int hashCode() {
        return (countryCode + language).hashCode();
    }
}