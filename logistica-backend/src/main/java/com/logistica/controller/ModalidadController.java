package com.logistica.controller;

import com.logistica.entity.Modalidad;
import org.springframework.web.bind.annotation.*;

import com.logistica.model.ResponseModel;
import com.logistica.service.ModalidadService;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;


@CrossOrigin()
@RestController
@RequestMapping({ "/api/modalidad" })
public class ModalidadController {
    @Autowired
    private ModalidadService servicePrincipal;
    
//    @GetMapping
//    public List<LocalizacionEntrega> findAll() {
//        
//        return servicePrincipal.findAll();
//    }
    
    @GetMapping
    public ResponseEntity<Object> findAll() {
        System.out.println("----modalidad---");
        return new ResponseEntity<>(servicePrincipal.findAll(), HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @Valid @RequestBody Modalidad request) {
        return new ResponseEntity<>(servicePrincipal.update(id, request), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody Modalidad request){
        Modalidad s = servicePrincipal.create(request);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

}