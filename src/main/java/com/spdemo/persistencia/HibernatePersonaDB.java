package com.spdemo.persistencia;

import com.spdemo.dominio.Persona;

import org.hibernate.Session;

public class HibernatePersonaDB implements IPersonaGBD{

    private Session session;

    public HibernatePersonaDB(Session session)
    {
        this.session = session;
                 
    }
    
    @Override
    public Persona getPersona(String id) {

        Persona p = (Persona) session.get(Persona.class, id);

        return p;
        
    }

    @Override
    public void addPersona(Persona persona) {

        Persona per = (Persona) session.get(Persona.class, persona.getId());

        if(per==null)
        {
            session.beginTransaction();  
            session.save(persona);
            session.getTransaction().commit();
        }
        
    }

    @Override
    public void updatePersona(Persona persona) {
        
        session.beginTransaction();
        session.update(persona);
        session.getTransaction().commit();
       
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
