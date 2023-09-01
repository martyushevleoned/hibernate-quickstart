package org.example.sql;

import org.example.tables.CountryLanguage;
import org.example.tables.keys.CountryLanguagePK;
import org.hibernate.Session;

import org.example.tables.City;
import org.example.tables.Country;
import org.hibernate.Transaction;

import java.util.Optional;

public class QueryWorker {
    private final static Session session = MySqlWorker.getSession();

    public static void insert(Country country) {
        Optional<Country> check = Optional.ofNullable(session.get(Country.class, country.getCode()));

        if (check.isPresent()) {
            System.err.println("Country with pk \"" + country.getCode() + "\" already exist");
            return;
        }

        Transaction transaction = session.beginTransaction();
        session.save(country);
        transaction.commit();
    }

    public static void insert(City city) {
        Optional<City> check = Optional.ofNullable(session.get(City.class, city.getId()));

        if (check.isPresent()) {
            System.err.println("City with pk \"" + city.getId() + "\" already exist");
            return;
        }

        Transaction transaction = session.beginTransaction();
        session.save(city);
        transaction.commit();
    }

    public static void insert(CountryLanguage countryLanguage) {
        CountryLanguagePK pk = new CountryLanguagePK(countryLanguage.getCountryCode(), countryLanguage.getLanguage());
        Optional<CountryLanguage> check = Optional.ofNullable(session.get(CountryLanguage.class, pk));

        if (check.isPresent()) {
            System.err.println("City with pk \"" + countryLanguage.getCountryCode() + "\", \"" + countryLanguage.getLanguage() + "\" already exist");
            return;
        }

        Transaction transaction = session.beginTransaction();
        session.save(countryLanguage);
        transaction.commit();
    }

//    ==================================================================================================================
    public static Optional<Country> getCountry(String countryCode) {
        Optional<Country> country = Optional.ofNullable(session.get(Country.class, countryCode));

        if (country.isEmpty())
            System.err.println("Country with pk \"" + countryCode + "\" doesn't exist");

        return country;
    }

    public static Optional<City> getCity(int cityId) {
        Optional<City> city = Optional.ofNullable(session.get(City.class, cityId));

        if (city.isEmpty())
            System.err.println("City with pk \"" + cityId + "\" doesn't exist");

        return city;
    }

    public static Optional<CountryLanguage> getCountryLanguage(String countryCode, String language) {
        CountryLanguagePK pk = new CountryLanguagePK(countryCode, language);
        Optional<CountryLanguage> countryLanguage = Optional.ofNullable(session.get(CountryLanguage.class, pk));

        if (countryLanguage.isEmpty())
            System.err.println("CountryLanguage with pk \"" + countryCode + "\", \"" + language + "\" doesn't exist");

        return countryLanguage;
    }

//    ==================================================================================================================

    public static void deleteCountry(String countryCode){
        Optional<Country> check = Optional.ofNullable(session.get(Country.class, countryCode));

        if (check.isEmpty()) {
            System.err.println("Country with pk \"" + countryCode+ "\" doesn't exist");
            return;
        }

        Transaction transaction = session.beginTransaction();
        session.delete(check.get());
        transaction.commit();
    }

    public static void deleteCity(int cityId){
        Optional<City> check = Optional.ofNullable(session.get(City.class, cityId));

        if (check.isEmpty()) {
            System.err.println("City with pk \"" + cityId + "\" doesn't exist");
            return;
        }

        Transaction transaction = session.beginTransaction();
        session.delete(check.get());
        transaction.commit();
    }

    public static void deleteCountryLanguage(String countryCode, String language) {
        CountryLanguagePK pk = new CountryLanguagePK(countryCode, language);
        Optional<CountryLanguage> check = Optional.ofNullable(session.get(CountryLanguage.class, pk));

        if (check.isEmpty()) {
            System.err.println("CountryLanguage with pk \"" + countryCode + "\", \"" + language + "\" doesn't exist");
            return;
        }

        Transaction transaction = session.beginTransaction();
        session.delete(check.get());
        transaction.commit();
    }
}
