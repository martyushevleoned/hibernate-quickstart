import junit.framework.TestCase;
import org.example.sql.PojoBuilder;
import org.example.tables.City;
import org.example.tables.Country;
import org.example.tables.CountryLanguage;
import org.example.tables.enums.Continent;

import java.util.Optional;

public class PojoBuilderTest extends TestCase {

    public void testInsertCountry() {
        Country country = Country.builder()
                .code("AAA")
                .name("Urodia")
                .continent(Continent.EUROPE)
                .region("West Europe")
                .surfaceArea(10.)
                .indepYear(10)
                .population(10)
                .lifeExpectancy(10.)
                .gnp(10.)
                .gnpOld(10.)
                .localName("Urodsk")
                .governmentForm("Republic")
                .headOfState("Me")
                .capital(10)
                .code2("AA")
                .build();

        PojoBuilder.insert(country);
    }

    public void testInsertCity() {
        City city = City.builder()
                .id(4080)
                .name("Chel")
                .countryCode("AAA")
                .district("Chel")
                .population(100)
                .build();

        PojoBuilder.insert(city);
    }

    public void testInsertCountryLanguage() {
        CountryLanguage countryLanguage = CountryLanguage.builder()
                .countryCode("AAA")
                .language("Russian")
                .isOfficial(true)
                .percentage(99.)
                .build();

        PojoBuilder.insert(countryLanguage);
    }

//    ==================================================================================================================

    public void testGetCountry() {
        Optional<Country> country = PojoBuilder.getCountry("AAA");
        country.ifPresent(c -> System.out.println(c.getName()));
    }

    public void testGetCity() {
        Optional<City> city = PojoBuilder.getCity(4080);
        city.ifPresent(c -> System.out.println(c.getName()));
    }

    public void testGetCountryLanguage() {
        Optional<CountryLanguage> countryLanguage = PojoBuilder.getCountryLanguage("AAA", "Russian");
        countryLanguage.ifPresent(cl -> System.out.println(cl.getLanguage()));
    }

//    ==================================================================================================================

    public void testDeleteCountry() {
        PojoBuilder.deleteCountry("AAA");
    }

    public void testDeleteCity() {
        PojoBuilder.deleteCity(4080);
    }

    public void testDeleteCountryLanguage() {
        PojoBuilder.deleteCountryLanguage("AAA", "Russian");
    }
}
