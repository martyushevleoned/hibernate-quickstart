package org.example.tables;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "city")
public class City {

    @Id
//    @Column(name = "ID", columnDefinition = "int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name", columnDefinition = "char")
    private String name;

    @ManyToOne
    @JoinColumn(name = "CountryCode")
    private Country country;

    @Column(name = "District", columnDefinition = "char")
    private String district;

    @Column(name = "Population", columnDefinition = "int")
    private Integer population;
}
