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


//Para diferenciarlo de la Configuracion de Hibernate
@org.springframework.context.annotation.Configuration
public class PersistenceBeanConfiguration {

    @Bean
    Session getSession()
    {
      SessionFactory factory = new Configuration().configure().addAnnotatedClass(Persona.class).buildSessionFactory();

      Session session = factory.openSession();

      return session;
    }
    
    @Bean
    IPersonaGBD getIPersonaGDB(Session s) throws InvalidAttributeValueException, NumberFormatException, IOException
    {
      return new HibernatePersonaDB(s);
    }
}
