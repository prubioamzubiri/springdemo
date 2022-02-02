package com.spdemo.aplicacion;

import com.spdemo.persistencia.*;

import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class ApplicationBeanConfiguration {

    @Bean
    IPersonaAplication getPersonaAplication(IPersonaGBD iPersonaGBD)
    {
        return new PersonaAplication2(iPersonaGBD);
    }
    
}
