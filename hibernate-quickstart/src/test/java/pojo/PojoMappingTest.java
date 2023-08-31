package pojo;

import junit.framework.TestCase;
import org.example.sql.QueryWorker;
import org.example.tables.Country;
import org.example.tables.CountryLanguage;

import java.util.Optional;

public class PojoMappingTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testGetCitiesByCountry() {

        Optional<Country> country = QueryWorker.getCountry("PSE");

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

        Optional<Country> country = QueryWorker.getCountry("PSE");

        if (country.isEmpty())
            return;

        System.out.println(country.get().getName() + " languages:");

        country.get().getLanguages().forEach(l -> {
            System.out.println(l.getIsOfficial() + "\t" + l.getPercentage() + "\t" + l.getLanguage());
        });
    }

    public void testIsOfficialLanguage() {

        Optional<CountryLanguage> language = QueryWorker.getCountryLanguage("RUS", "Russian");

        if (language.isEmpty())
            return;


        if (language.get().getIsOfficial()) {
            System.out.println(language.get().getLanguage() + " is official language of " + language.get().getCountry().getName());
        } else {
            System.out.println(language.get().getLanguage() + " is not official language of " + language.get().getCountry().getName());
        }
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
