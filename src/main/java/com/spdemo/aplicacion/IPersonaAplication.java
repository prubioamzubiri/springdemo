package com.spdemo.aplicacion;

import com.spdemo.dominio.Persona;

public interface IPersonaAplication {

    public void addPersona(Persona p);

    public Persona getPersona (String id);

    public void removePersona (String id);

    
}