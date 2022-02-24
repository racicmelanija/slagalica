package com.example.slagalica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SlagalicaApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SlagalicaApplication.class, args);
        SlagalicaService service = applicationContext.getBean(SlagalicaServiceImpl.class);
        service.sortWords();
    }

}
