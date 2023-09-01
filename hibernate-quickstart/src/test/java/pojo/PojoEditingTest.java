package pojo;

import junit.framework.TestCase;

import org.example.sql.QueryWorker;
import org.example.tables.City;
import org.example.tables.Country;
import org.example.tables.CountryLanguage;
import org.example.tables.enums.Continent;

import java.util.Optional;

public class PojoEditingTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

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

        QueryWorker.insert(country);
    }

    public void testInsertCity() {
        City city = City.builder()
                .id(4080)
                .name("Chel")
                .country(QueryWorker.getCountry("AAA").get())
                .district("Chel")
                .population(100)
                .build();

        QueryWorker.insert(city);
    }

    public void testInsertCountryLanguage() {
        CountryLanguage countryLanguage = CountryLanguage.builder()
                .country(QueryWorker.getCountry("AAA").get())
                .language("Russian")
                .isOfficial(true)
                .percentage(99.)
                .build();

        QueryWorker.insert(countryLanguage);
    }

    //======================================================================

    public void testGetCountry() {
        Optional<Country> country = QueryWorker.getCountry("AAA");
        country.ifPresent(value -> System.out.println("Country: " + value.getName()));
    }

    public void testGetCity() {
        Optional<City> city = QueryWorker.getCity(4080);
        city.ifPresent(c -> System.out.println("City: " + c.getName()));
    }

    public void testGetCountryLanguage() {
        Optional<CountryLanguage> countryLanguage = QueryWorker.getCountryLanguage("AAA", "Russian");
        countryLanguage.ifPresent(language -> System.out.println("Country language: " + language.getLanguage()));
    }

    //=====================================================================

    public void testDeleteCountry() {
        QueryWorker.deleteCountry("AAA");
    }

    public void testDeleteCity() {
        QueryWorker.getCity(4080);
    }

    public void testDeleteCountryLanguage() {
        QueryWorker.getCountryLanguage("AAA", "Russian");
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
