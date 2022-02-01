package com.spdemo.aplicacion;

import org.hibernate.Session;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class LoadApp {

    @Bean
    IPersonaAplication getPersonaAplication(Session s)
    {
        IPersonaAplication PA = new PersonaAplication(s);
        return PA;
    }
    
}
