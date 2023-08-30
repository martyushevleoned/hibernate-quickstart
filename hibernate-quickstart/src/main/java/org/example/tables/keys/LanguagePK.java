package org.example.tables.keys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tables.Country;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguagePK implements Serializable {

    private Country country;
    private String language;

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == LanguagePK.class)
            if (Objects.equals(((LanguagePK) obj).getLanguage(), language))
                return Objects.equals(((LanguagePK) obj).getCountry().getCode(), country.getCode());
        return false;
    }

    @Override
    public int hashCode() {
        return (country.getCode() + language).hashCode();
    }
}
