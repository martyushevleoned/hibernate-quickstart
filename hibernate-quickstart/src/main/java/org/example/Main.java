package org.example;


import org.example.tables.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();


        Optional<Country> country = Optional.ofNullable(session.get(Country.class, "RUS"));
        if (country.isPresent()) {
            System.out.println(country.get().getName());
            List<CountryLanguage> languages = country.get().getLanguages();
            languages.forEach(l -> System.out.println(l.getPercentage() + "\t" + l.getLanguage()));
        } else {
            System.out.println("Country not found");
        }

        City city = City.builder().id(12).name("Name").district("some district").population(1123).build();
        System.out.println(city);

//=======================================================================================
//        Add city
//        Transaction transaction = session.beginTransaction();
//
//        Country country = new Country();
//        country.setCode("AAA");
//        country.setName("Zabugor'e");
//        country.setContinent(Continent.ASIA);
//        country.setRegion("South Asia");
//        country.setSurfaceArea(987654.00);
//        country.setIndepYear(2023);
//        country.setPopulation(1);
//        country.setLifeExpectancy(99.9);
//        country.setGnp(987.65);
//        country.setGnpOld(987.65);
//        country.setLocalName("Bugor");
//        country.setGovernmentForm("Federation");
//        country.setHeadOfState("Me");
//        country.setCapital(999);
//        country.setCode2("AA");
//
//        City city = new City();
//        city.setId(4080);
//        city.setName("Urodsk");
//        city.setCountry(country);
//        city.setDistrict("Zavodland");
//        city.setPopulation(1);
//
//        session.save(city);
//        transaction.commit();


//        Select
//        City city = session.get(City.class, 4080);
//        System.out.println(city.getName());
//        Country country = session.get(Country.class, "AAA");
//        System.out.println(country.getName());


//        Delete city (with country)
//        Transaction transaction = session.beginTransaction();
//        session.delete(session.get(City.class, 4080));
//        session.delete(session.get(Country.class, "AAA"));
//        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
