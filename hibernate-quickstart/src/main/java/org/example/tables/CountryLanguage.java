package org.example.tables;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tables.enums.IsOfficialConverter;
import org.example.tables.keys.LanguagePK;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(LanguagePK.class)
@Table(name = "countrylanguage")
public class CountryLanguage {

    @Id
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

