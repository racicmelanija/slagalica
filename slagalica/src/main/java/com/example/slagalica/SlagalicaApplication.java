package com.example.slagalica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SlagalicaApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SlagalicaApplication.class, args);
        SlagalicaService service = applicationContext.getBean(SlagalicaServiceImpl.class);
        List<String> test = new ArrayList<>();
        test.add("а");
        test.add("н");
        test.add("т");
        test.add("и");
        test.add("ц");
        test.add("и");
        test.add("п");
        test.add("а");
        test.add("ц");
        test.add("и");
        test.add("ј");
        test.add("а");
        System.out.println(service.findAllWords(test));
    }

}
