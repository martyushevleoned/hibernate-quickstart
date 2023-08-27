package org.example;

import org.example.tables.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        System.out.println();
        Country country = session.get(Country.class, "RUS");
        System.out.println(country.getName());
        System.out.println();

        City city = session.get(City.class, 1);
        System.out.println(city.getName());
        System.out.println(city.getCountry().getName());
        System.out.println();

//=================================================================================================

//        SELECT
//        City city = session.get(City.class, 4079);
//        System.out.println(city);

//        INSERT
//        Transaction transaction = session.beginTransaction();
//        City city = new City();
//        city.setId(4080);
//        city.setName("MySity");
//        city.setCountryCode("PSE");
//        city.setDistrict("MySity");
//        city.setPopulation(9001);
//        session.save(city);
//        transaction.commit();

//        UPDATE
//        Transaction transaction = session.beginTransaction();
//        City city = session.get(City.class, 4080);
//        city.setCountryCode("RUS");
//        session.save(city);
//        transaction.commit();

//        DELETE
//        Transaction transaction = session.beginTransaction();
//        City city = session.get(City.class, 4080);
//        session.delete(city);
//        transaction.commit();

        sessionFactory.close();
    }
}
