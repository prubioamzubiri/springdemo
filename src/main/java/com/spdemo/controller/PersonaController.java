package com.spdemo.controller;

import java.io.File;
import java.io.IOException;

import javax.management.InvalidAttributeValueException;

import com.spdemo.dominio.Persona;
import com.spdemo.persistencia.TextBD;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    private final TextBD repository;

    PersonaController(TextBD repository) throws InvalidAttributeValueException, NumberFormatException, IOException {
      this.repository = repository;
    }

    
    @GetMapping("/{id}")
    public Persona getPersona(@PathVariable String id)
    {
        return repository.getPersona(id);
    }
    
}
