package com.spdemo.aplicacion;

import com.spdemo.dominio.Persona;

import org.apache.commons.lang3.NotImplementedException;


public class LifeActions {
  
    static void morir (Persona persona)
    {
        //throw new NotImplementedException("Método no implementado");
        persona.setAlive(false);
    }
    
    static boolean mayorDeEdad(Persona persona)
    {
        
        //throw new NotImplementedException("Método no implementado");
        return (persona.getAge()>=18);
    }   


}
