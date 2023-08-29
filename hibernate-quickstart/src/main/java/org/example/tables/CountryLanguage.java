package org.example.tables;

import lombok.Data;
import org.example.tables.enums.IsOfficialConverter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {

    @Column(name = "CountryCode", columnDefinition = "char")
    private String country;

    @Id
    @Column(name = "Language", columnDefinition = "char")
    private String language;

    @Convert(converter = IsOfficialConverter.class)
    @Column(name = "IsOfficial", columnDefinition = "enum")
    private Boolean isOfficial;

    @Column(name = "Percentage", columnDefinition = "decimal(4,1)")
    private Double percentage;
}
