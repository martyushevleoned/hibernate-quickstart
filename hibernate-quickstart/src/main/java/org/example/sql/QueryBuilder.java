package org.example.sql;

import org.example.tables.City;
import org.example.tables.Country;
import org.example.tables.CountryLanguage;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class QueryBuilder {

    private static final Session session = MySqlWorker.getSession();
    public static final CriteriaBuilder builder = session.getCriteriaBuilder();

    public static List<Country> getAllCountries() {
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);

        return session.createQuery(query).getResultList();
    }

    public static List<City> getAllCities() {
        CriteriaQuery<City> query = builder.createQuery(City.class);
        Root<City> root = query.from(City.class);
        query.select(root);

        return session.createQuery(query).getResultList();
    }

    public static List<CountryLanguage> getAllCountryLanguages(){
        CriteriaQuery<CountryLanguage> query = builder.createQuery(CountryLanguage.class);
        Root<CountryLanguage> root = query.from(CountryLanguage.class);
        query.select(root);

        return session.createQuery(query).getResultList();
    }
}
