package org.example.tables.keys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguagePK implements Serializable {

    private String country;
    private String language;

    @Override
    public boolean equals(Object obj){
        return obj == this;
    }

    @Override
    public int hashCode(){
        return (country + language).hashCode();
    }
}
