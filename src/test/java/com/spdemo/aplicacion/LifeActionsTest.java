package com.spdemo.aplicacion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.spdemo.dominio.Persona;

import org.junit.jupiter.api.Test;

public class LifeActionsTest {
    @Test
    void testMayorDeEdad() {

        Persona persona17 = new Persona("a","b",17);
        Persona persona18 = new Persona("a","b",18);
        Persona persona19 = new Persona("a","b",19);
        
        boolean result17 = LifeActions.mayorDeEdad(persona17);
        boolean result18 = LifeActions.mayorDeEdad(persona18);
        boolean result19 = LifeActions.mayorDeEdad(persona19);
        
        boolean expResult17 = false;
        boolean expResult18 = true;
        boolean expResult19 = true;
        
        assertEquals(result17, expResult17);       
        assertEquals(result18, expResult18);
        assertEquals(result19, expResult19);


    }

    @Test
    void testMorir() {

        Persona persona = new Persona("a","b",80);
        boolean resultA = persona.isAlive();
        boolean expResultA = true;
        
        LifeActions.morir(persona);
        
        boolean resultD = persona.isAlive();
        boolean expResultD = false;
        
        assertEquals(expResultA, resultA);
        assertEquals(expResultD, resultD);

    }
}
