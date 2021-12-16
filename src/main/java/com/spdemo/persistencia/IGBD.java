package com.example.persistencia;

import com.example.dominio.Persona;

public interface IGBD {

    /**
     * Se obtiene una persona de la BD mediante su identificador.
     * @param id id de la Persona que se desea obtener
     * @return Persona con el id indicado, si no existe dicha persona en la base de datos devuelve null
     */
    public Persona getPersona(String id);

    public void addPersona(Persona persona);

    public void updatePersona(Persona persona);
    
}
