package com.spdemo.persistencia;

import java.io.File;
import java.io.IOException;
import javax.management.InvalidAttributeValueException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDataBase {

    @Bean
    TextBD getTextBD() throws InvalidAttributeValueException, NumberFormatException, IOException {

      TextBD repository = new TextBD(); 
      File file = new File("./datos.txt");
      repository.load(file);
      return repository;
    }
    
}
