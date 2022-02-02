package com.spdemo.aplicacion;

import com.spdemo.dominio.Persona;
import com.spdemo.persistencia.*;

public class PersonaAplication2 implements IPersonaAplication{

    private IPersonaGBD GBD;

    public PersonaAplication2(IPersonaGBD gbd)
    {
        this.GBD = gbd;
    }

    
    @Override
    public void addPersona(Persona p) {
        
        GBD.addPersona(p);
        
    }

    @Override
    public Persona getPersona(String id) {
        
        return GBD.getPersona(id);
    }

    @Override
    public void removePersona(String id) {
        
        GBD.removePersona(id);
        
    }
    
}
