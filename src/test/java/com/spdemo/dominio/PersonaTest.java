package com.spdemo.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.Test;

public class PersonaTest {
    @Test
    public void testHBirthday() {

        Random random = new Random();
        int initAge = random.nextInt();
        
        Persona instance = new Persona("a","b",initAge,false);
        instance.hBirthday();
        int expResultD=initAge;
        int resultD = instance.getAge();

        instance.setAlive(true);
        instance.hBirthday();
        
        int expResultA=initAge + 1;
        int resultA = instance.getAge();        
        
        assertEquals(expResultD, resultD);
        assertEquals(expResultA, resultA);


    }
}
