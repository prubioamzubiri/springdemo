package com.spdemo.persistencia;

import java.io.File;
import java.io.IOException;
import javax.management.InvalidAttributeValueException;

import com.spdemo.dominio.Persona;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.hibernate.cfg.Configuration;



//Para diferenciarlo de la Configuracion de Hibernate
@org.springframework.context.annotation.Configuration
public class PersistenceBeanConfiguration {

    @Bean
    TextBD getTextBD() throws InvalidAttributeValueException, NumberFormatException, IOException {

      TextBD repository = new TextBD(); 
      File file = new File("./datos.txt");
      repository.load(file);
      return repository;
    }

    @Bean
    Session getSession()
    {
      SessionFactory factory = new Configuration().configure().addAnnotatedClass(Persona.class).buildSessionFactory();

      Session session = factory.openSession();

      return session;
    }
    
    @Bean
    HibernateDB getHibernateDB(Session session)
    {
      HibernateDB hibernateDB = new HibernateDB(session);

      return hibernateDB;
    }
}
