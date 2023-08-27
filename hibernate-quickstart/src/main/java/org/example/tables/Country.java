package org.example.tables;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "Code", columnDefinition = "char")
    private String code;

    @Column(name = "Name", columnDefinition = "char")
    private String name;

    @Column(name = "Continent", columnDefinition = "enum")
    private String continent;

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
}