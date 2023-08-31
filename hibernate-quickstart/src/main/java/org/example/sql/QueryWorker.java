package org.example.sql;

import org.example.tables.City;
import org.example.tables.Country;
import org.example.tables.CountryLanguage;
import org.example.tables.keys.LanguagePK;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;

public class QueryWorker {
    private final static Session session = MySqlWorker.getSession();

    //    get pojo
    public static Optional<Country> getCountry(String countryCode) {
        Optional<Country> country = Optional.ofNullable(session.get(Country.class, countryCode));
        if (country.isEmpty())
            System.out.println("Country with primary key: \"" + countryCode + "\" not found");
        return country;
    }

    public static Optional<City> getCity(int cityId) {
        Optional<City> city = Optional.ofNullable(session.get(City.class, cityId));
        if (city.isEmpty())
            System.out.println("City with primary key: \"" + cityId + "\" not found");
        return city;
    }

    public static Optional<CountryLanguage> getCountryLanguage(String countryCode, String language) {
        Optional<Country> country = getCountry(countryCode);
        if (country.isEmpty()) {
            System.out.println("CountryLanguage with primary keys: \"" + countryCode + "\", \"" + language + "\" not found (Country doesn't exist)");
            return Optional.empty();
        }

        LanguagePK pk = new LanguagePK(country.get(), language);
        Optional<CountryLanguage> countryLanguage = Optional.ofNullable(session.get(CountryLanguage.class, pk));
        if (countryLanguage.isEmpty())
            System.out.println("CountryLanguage with primary keys: \"" + countryCode + "\", \"" + language + "\" not found (Language doesn't exist)");

        return countryLanguage;
    }


    //    insert pojo
    public static void insert(Country country) {
        Transaction transaction = session.beginTransaction();
        session.save(country);
        transaction.commit();
    }

    public static void insert(City city) {
        Transaction transaction = session.beginTransaction();
        session.save(city);
        transaction.commit();
    }

    public static void insert(CountryLanguage countryLanguage) {
        Transaction transaction = session.beginTransaction();
        session.save(countryLanguage);
        transaction.commit();
    }

//    delete pojo

    public static void delete(Country country) {
        Transaction transaction = session.beginTransaction();
        session.delete(country);
        transaction.commit();
    }

    public static void delete(City city) {
        Transaction transaction = session.beginTransaction();
        session.delete(city);
        transaction.commit();
    }

    public static void delete(CountryLanguage countryLanguage) {
        Transaction transaction = session.beginTransaction();
        session.delete(countryLanguage);
        transaction.commit();
    }
}
