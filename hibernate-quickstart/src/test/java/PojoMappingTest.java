import junit.framework.TestCase;
import org.example.sql.MySqlWorker;
import org.example.tables.Country;
import org.example.tables.CountryLanguage;
import org.example.tables.keys.LanguagePK;
import org.hibernate.Session;

import java.util.Optional;

public class PojoMappingTest extends TestCase {

    Session session;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        session = MySqlWorker.getSession();
        System.out.println();
    }

    public void testGetCitiesByCountry() {
        String testCountryCode = "PSE";

        Optional<Country> country = Optional.ofNullable(session.get(Country.class, testCountryCode));

        if (country.isEmpty()) {
            System.out.println("Country not found");
            return;
        }

        System.out.println(country.get().getName() + " cities:");

        country.get().getCities().forEach(c -> {
            System.out.println(c.getId() + "\t" + c.getName());
        });
    }

    public void testGetLanguagesByCountry() {
        String testCountryCode = "RUS";

        Optional<Country> country = Optional.ofNullable(session.get(Country.class, testCountryCode));

        if (country.isEmpty()) {
            System.out.println("Country not found");
            return;
        }

        System.out.println(country.get().getName() + " languages:");

        country.get().getLanguages().forEach(l -> {
            System.out.println(l.getIsOfficial() + "\t" + l.getPercentage() + "\t" + l.getLanguage());
        });
    }

    public void testIsOfficialLanguage() {
        String testCountryCode = "RUS";
        String testLanguageName = "Russian";

        Optional<Country> country = Optional.ofNullable(session.get(Country.class, testCountryCode));
        if (country.isEmpty()) {
            System.out.println("Country not found");
            return;
        }

        LanguagePK pk = new LanguagePK(country.get(), testLanguageName);

        Optional<CountryLanguage> language = Optional.ofNullable(session.get(CountryLanguage.class, pk));

        if (language.isEmpty()) {
            System.out.println("Language not found");
            return;
        }

        if (language.get().getIsOfficial()) {
            System.out.println(language.get().getLanguage() + " is official language of " + language.get().getCountry().getName());
        } else {
            System.out.println(language.get().getLanguage() + " is not official language of " + language.get().getCountry().getName());
        }
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        session.close();
    }
}
