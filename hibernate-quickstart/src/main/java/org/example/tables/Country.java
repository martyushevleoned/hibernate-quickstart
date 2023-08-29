package org.example.tables;

import lombok.Data;
import org.example.tables.enums.Continent;
import org.example.tables.enums.ContinentConverter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "Code", columnDefinition = "char")
    private String code;

    @Column(name = "Name", columnDefinition = "char")
    private String name;

    @Convert(converter = ContinentConverter.class)
    @Column(name = "Continent", columnDefinition = "enum")
    private Continent continent;

    @Column(name = "Region", columnDefinition = "char")
    private String region;

    @Column(name = "SurfaceArea", columnDefinition = "decimal(10,2)")
    private Double surfaceArea;

    @Column(name = "IndepYear", columnDefinition = "smallint")
    private Integer indepYear;

    @Column(name = "Population", columnDefinition = "int")
    private Integer population;

    @Column(name = "LifeExpectancy", columnDefinition = "decimal(3,1)")
    private Double lifeExpectancy;

    @Column(name = "GNP", columnDefinition = "decimal(10,2)")
    private Double gnp;

    @Column(name = "GNPOld", columnDefinition = "decimal(10,2)")
    private Double gnpOld;

    @Column(name = "LocalName", columnDefinition = "char")
    private String localName;

    @Column(name = "GovernmentForm", columnDefinition = "char")
    private String governmentForm;

    @Column(name = "HeadOfState", columnDefinition = "char")
    private String headOfState;

    @Column(name = "Capital", columnDefinition = "int")
    private Integer capital;

    @Column(name = "Code2", columnDefinition = "char")
    private String code2;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    @OrderBy("ID")
    private List<City> cities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    @OrderBy("Percentage")
    private List<CountryLanguage> languages;
}
