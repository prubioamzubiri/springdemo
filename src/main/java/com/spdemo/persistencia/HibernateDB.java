package com.spdemo.persistencia;

import com.spdemo.dominio.Persona;

import org.hibernate.Session;

public class HibernateDB implements IGBD{

    private Session session;

    public HibernateDB(Session session)
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
    public void removePersona(Persona persona) {
        
        Persona p = (Persona) session.get(Persona.class, persona.getId());

        if(p!=null)
        {
            session.beginTransaction();

            session.remove(p);
            
            session.getTransaction().commit();
        }
        
    }
    
}
