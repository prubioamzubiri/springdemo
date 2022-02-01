package com.spdemo.aplicacion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.spdemo.dominio.Persona;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.runners.MethodSorters;
//import org.junit.jupiter.api.Test;
import org.junit.Test;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonaAplicationTest {

    private static Session session;
    private static Persona p;
    private static String id;
    private static PersonaAplication pa;

    @Before
    public void createContext()
    {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Persona.class).buildSessionFactory();

        session = factory.openSession();

        id = "0014";
        
        p = new Persona(id, "pepe", 4);
       /* Persona p = new Persona();
        p.setId(id);
        p.setAge(4);
        p.setName("name");
        p.setAlive(true);*/

        pa = new PersonaAplication(session);
    }

    @Test
    public void AtestAddPersona() {

        pa.addPersona(p);

        Persona p2 = pa.getPersona(id);

        assertEquals(p.getId(), p2.getId());
        assertEquals(p.getAge(), p2.getAge());
        assertEquals(p.getName(), p2.getName());
        assertEquals(p.isAlive(), p2.isAlive());

    }

    @Test
    public void BtestGetPersona() {

        assertEquals(1, 1);
        
    }

    @Test
    public void CtestRemovePersona() {

        pa.removePersona(id);

        Persona p3 = pa.getPersona(id);

        assertEquals(p3, null);

    }
}
