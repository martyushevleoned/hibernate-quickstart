package org.example.sql;

import org.example.tables.City;
import org.example.tables.CountryLanguage;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class HqlBuilder {

    private static final Session session = MySqlWorker.getSession();

    public static List<CountryLanguage> getAllLanguagesOfCity(int cityId) {

        Optional<City> city = PojoBuilder.getCity(cityId);

        if (city.isEmpty())
            return null;

        String hql = "from " + CountryLanguage.class.getSimpleName() +
                " where countryCode = '" + city.get().getCountryCode() + "'";
        return session.createQuery(hql).getResultList();
    }
}
