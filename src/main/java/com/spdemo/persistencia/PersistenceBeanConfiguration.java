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
/*
    @Bean
    Session getSession()
    {
      SessionFactory factory = new Configuration().configure().addAnnotatedClass(Persona.class).buildSessionFactory();

      Session session = factory.openSession();

      return session;
    }
 */   
    @Bean
    IPersonaGBD getIPersonaGDB() throws InvalidAttributeValueException, NumberFormatException, IOException
    {
      TextBD hibernateDB = new TextBD();

      File f = new File("./datos.txt"); 

      hibernateDB.load(f);
      

      return hibernateDB;
    }
}
