package com.spdemo.persistencia;

import com.spdemo.dominio.Persona;

import java.io.File;
import java.io.FileNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.hibernate.cfg.Configuration;

import javax.management.InvalidAttributeValueException;
import java.io.IOException;
import java.util.Properties;


//Para diferenciarlo de la Configuracion de Hibernate
@org.springframework.context.annotation.Configuration
public class PersistenceBeanConfiguration {

    @Bean
    Session getSession()
    {
      Configuration cfg = new Configuration();

      String connectionURL;

      String host = System.getProperty("host")!=null? System.getProperty("host") : "127.0.0.1";
      String port = System.getProperty("port")!=null? System.getProperty("port") : "3306";
      String database = System.getProperty("database")!=null? System.getProperty("database") : "database1";

      connectionURL = "jdbc:mysql://" + host + ":" + port + "/" + database;

      cfg.setProperty("hibernate.connection.url", connectionURL);


      String user = System.getProperty("user")!=null? System.getProperty("user") : "root";

      cfg.setProperty("hibernate.connection.username", user);

      String password = System.getProperty("password")!=null? System.getProperty("password") : "root";

      cfg.setProperty("hibernate.connection.password", password);

      SessionFactory factory = cfg.configure().addAnnotatedClass(Persona.class).buildSessionFactory();

      Session session = factory.openSession();

      return session;
    }
    
    @Bean
    IPersonaGBD getIPersonaGDB(Session s) throws InvalidAttributeValueException, NumberFormatException, IOException
    {
      return new HibernatePersonaDB(s);
    }
}
