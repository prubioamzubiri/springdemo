package com.spdemo.persistencia;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Random;

import com.spdemo.dominio.Persona;

import org.junit.Before;
import org.junit.Test;

public class AnotherBDTest {

    private IPersonaGBD gbd;

    @Before
    public void ConfigureTest()
    {
      Configuration cfg = new Configuration();

      String connectionURL;

    // -Ddbhost=host -Ddbport=port -Ddbdatabase=databasename
    // String host = (System.getProperty("dbhost")==null)? "127.0.0.1":System.getProperty(data);
    //   String host = getProperty("dbhost", "127.0.0.1");
    //   String port = getProperty("dbport","3306");
    //   String database = getProperty("dbdatabase","database1");

      connectionURL = "jdbc:h2:mem:default";//; DB_CLOSE_ON_EXIT=FALSE"; //"jdbc:mysql://" + host + ":" + port + "/" + database;
      cfg.setProperty("hibernate.connection.url", connectionURL);

      cfg.setProperty("hibernate.connection.driver_class","org.h2.Driver");
      cfg.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");

      // -Ddbuser=user
      //String user = getProperty("dbuser", "root");
      cfg.setProperty("hibernate.connection.username", "sa");

      //-Ddbpassword=password
      //String password = getProperty("dbpassword","root");
      cfg.setProperty("hibernate.connection.password", "sa");

      SessionFactory factory = cfg.configure().addAnnotatedClass(Persona.class).buildSessionFactory();

      Session session = factory.openSession();

      gbd = new HibernatePersonaDB(session);

    }

    @Test
    public void pruebaTest()
    {
        Persona p = new Persona("0001", "name", 1);
        gbd.addPersona(p);

        Persona p2 = gbd.getPersona("0001");

        assertEquals(p.getAge(), p2.getAge());
        assertEquals(p.getId(), p2.getId());
        assertEquals(p.isAlive(), p2.isAlive());
        assertEquals(p.getName(), p2.getName());
    }
    
}
