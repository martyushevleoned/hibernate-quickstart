import junit.framework.TestCase;
import org.example.sql.MySqlWorker;
import org.example.tables.City;
import org.example.tables.Country;
import org.example.tables.CountryLanguage;
import org.example.tables.enums.Continent;
import org.example.tables.keys.LanguagePK;
import org.hibernate.Session;

import java.util.Optional;

public class PojoEditingTest extends TestCase {

    Session session;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        session = MySqlWorker.getSession();
    }

    public void testGetCountry() {
        Optional<Country> country = MySqlWorker.getCountry("AAA");
        country.ifPresent(value -> System.out.println("Country: " + value.getName()));
    }

    public void testGetCity() {
        Optional<City> city = MySqlWorker.getCity(4080);
        city.ifPresent(c -> System.out.println("City: " + c.getName()));
    }

    public void testGetCountryLanguage() {
        Optional<CountryLanguage> countryLanguage = MySqlWorker.getCountryLanguage("RUS", "Russian");
        countryLanguage.ifPresent(language -> System.out.println("Country language: " + language.getLanguage()));
    }

    //======================================================================

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

        MySqlWorker.insert(country);
    }

    public void testInsertCity() {
        City city = City.builder()
                .name("Chel")
                .country(MySqlWorker.getCountry("AAA").get())
                .district("Chel")
                .population(100)
                .build();

        MySqlWorker.insert(city);
    }

    public void testInsertCountryLanguage(){
        CountryLanguage countryLanguage = CountryLanguage.builder()
                .country(MySqlWorker.getCountry("AAA").get())
                .language("Russian")
                .isOfficial(true)
                .percentage(99.)
                .build();

        MySqlWorker.insert(countryLanguage);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        session.close();
    }
}
