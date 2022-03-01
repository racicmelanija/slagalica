package com.example.slagalica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/words")
public class SlagalicaController {
    private final SlagalicaService service;

    @Autowired
    public SlagalicaController(SlagalicaService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllWords(@RequestParam("letters") List<String> letters){
        return new ResponseEntity<>(service.findAllWords(letters), HttpStatus.OK);
    }
}
