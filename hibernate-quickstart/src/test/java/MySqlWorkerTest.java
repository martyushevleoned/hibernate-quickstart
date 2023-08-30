import junit.framework.TestCase;
import org.example.MySqlWorker;
import org.example.tables.City;
import org.example.tables.Country;
import org.example.tables.CountryLanguage;
import org.example.tables.keys.LanguagePK;
import org.hibernate.Session;

import java.util.Optional;

public class MySqlWorkerTest extends TestCase {

    Session session;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        session = MySqlWorker.getSession();
        System.out.println();
    }

    public void testComposeKey() {
        LanguagePK pk = new LanguagePK("ABW", "Dutch");

        Optional<CountryLanguage> language = Optional.ofNullable(session.get(CountryLanguage.class, pk));

        if (language.isPresent()) {
            System.out.println(language.get().getIsOfficial());
        } else {
            System.out.println("Language not found");
        }

        System.out.println();
    }

    public void testGetLanguagesByCountry() {

        Optional<Country> country = Optional.ofNullable(session.get(Country.class, "USA"));

        if (country.isPresent()) {

            System.out.println(country.get().getName() + " languages:");

            country.get().getLanguages().forEach(l -> {
                System.out.println(l.getIsOfficial() + "\t" + l.getPercentage() + "\t" + l.getLanguage());
            });

        } else {
            System.out.println("Country not found");
        }
        System.out.println();
    }

    public void testGetCountryByCity() {

        Optional<City> city = Optional.ofNullable(session.get(City.class, 54));

        if (city.isPresent()) {
            Country country = city.get().getCountry();
            assertEquals(country.getCode(), city.get().getCountry().getCode());
            System.out.println(city.get().getName() + " in " + country.getName());
        } else {
            System.err.println("City not found");
        }
        System.out.println();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        session.close();
    }
}
