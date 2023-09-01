import junit.framework.TestCase;
import org.example.sql.QueryBuilder;
import org.example.tables.City;
import org.example.tables.Country;
import org.example.tables.CountryLanguage;

import java.util.List;

public class QueryBuilderTest extends TestCase {

    public void testGetAllCountries(){
        List<Country> countries = QueryBuilder.getAllCountries();
        countries.forEach(c -> System.out.println(c.getName()));
    }

    public void testGetAllCities(){
        List<City> cities = QueryBuilder.getAllCities();
        cities.forEach(c -> System.out.println(c.getName()));
    }

    public void testGetAllCountryLanguages(){
        List<CountryLanguage> cities = QueryBuilder.getAllCountryLanguages();
        cities.forEach(c -> System.out.println(c.getLanguage()));
    }
}
