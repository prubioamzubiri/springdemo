package com.spdemo.springdemo;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.management.InvalidAttributeValueException;

import com.spdemo.persistencia.TextBD;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDataBase {

    //private static final Logger log = (Logger) LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    TextBD getTextBD() throws InvalidAttributeValueException, NumberFormatException, IOException {

      TextBD repository = new TextBD(); 
      File file = new File("./datos.txt");
      repository.load(file);
      return repository;
    }
    
}
