package com.spdemo.aplicacion;

import org.hibernate.Session;
import com.spdemo.dominio.Persona;

public class PersonaAplication implements IPersonaAplication{

    private Session session;

    public PersonaAplication(Session session)
    {
        this.session = session;
                 
    }

    @Override
    public void addPersona(Persona p) {

        Persona per = (Persona) session.get(Persona.class, p.getId());

        if(per==null)
        {
            session.beginTransaction();  
            session.save(p);
            session.getTransaction().commit();
        }
        
    }

    @Override
    public Persona getPersona(String id) {
        
        Persona p = (Persona) session.get(Persona.class, id);

        return p;
    }

    @Override
    public void removePersona(String id) {
        
        Persona p = (Persona) session.get(Persona.class, id);

        if(p!=null)
        {
            session.beginTransaction();

            session.remove(p);
            
            session.getTransaction().commit();
        }
        
    }
    
}
