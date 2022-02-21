package com.spdemo.persistencia;

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
    Session getSession()
    {
      SessionFactory factory = new Configuration().configure().addAnnotatedClass(Persona.class).buildSessionFactory();

      Session session = factory.openSession();

      return session;
    }
    
    @Bean
    IPersonaGBD getIPersonaGDB(Session session)
    {
      IPersonaGBD hibernateDB = new TextBD();

      return hibernateDB;
    }
}
