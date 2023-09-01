package org.example.tables;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tables.enums.IsOfficialConverter;
import org.example.tables.keys.CountryLanguagePK;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(CountryLanguagePK.class)
@Table(name = "countrylanguage")
public class CountryLanguage {

    @Id
    @Column(name = "CountryCode", columnDefinition = "char")
    private String countryCode;

    @Id
    @Column(name = "Language", columnDefinition = "char")
    private String language;

    @Convert(converter = IsOfficialConverter.class)
    @Column(name = "IsOfficial", columnDefinition = "enum")
    private Boolean isOfficial;

    @Column(name = "Percentage", columnDefinition = "decimal(4,1)")
    private Double percentage;

}