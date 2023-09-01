import junit.framework.TestCase;
import org.example.sql.HqlBuilder;
import org.example.tables.City;
import org.example.tables.Country;
import org.example.tables.CountryLanguage;

import java.util.List;

public class HqlBuilderTest extends TestCase {

    public void testGetAllCountryLanguages() {

        List<CountryLanguage> languages = HqlBuilder.getAllLanguagesOfCity(1);
        languages.forEach(l -> System.out.println(l.getLanguage()));
    }
}
