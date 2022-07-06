package com.logistica.controller;

import com.logistica.entity.LocalizacionEntrega;
import org.springframework.web.bind.annotation.*;

import com.logistica.model.ResponseModel;
import com.logistica.service.LocalizacionEntregaService;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({ "/api/localizacionEntrega" })
public class LocalizacionEntregaController {
    @Autowired
    private LocalizacionEntregaService servicePrincipal;
    
//    @GetMapping
//    public List<LocalizacionEntrega> findAll() {
//        
//        return servicePrincipal.findAll();
//    }
    
    @GetMapping
    public ResponseEntity<Object> findAll() {
//        return new ResponseModel(null, HttpStatus.OK,servicePrincipal.findAll());
        return new ResponseEntity<>(servicePrincipal.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
//        return new ResponseModel(null, HttpStatus.OK,servicePrincipal.findById(id));
        return new ResponseEntity<>(servicePrincipal.findById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody LocalizacionEntrega request){
//        LocalizacionEntrega s = servicePrincipal.save(new Warehouse(request.getName(), request.getType(),true, request.getDescription()));
        LocalizacionEntrega s = servicePrincipal.create(request);
        //return new ResponseModel(null, HttpStatus.CREATED, s);
        return new ResponseEntity<>(servicePrincipal.create(request), HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody LocalizacionEntrega request) {
        //return new ResponseModel(null, HttpStatus.OK,servicePrincipal.update(id, request));
        //return new Responsee(null, HttpStatus.OK,servicePrincipal.update(id, request));
        return new ResponseEntity<>(servicePrincipal.update(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        servicePrincipal.delete(id);
//        return new RespoCnseModel(null, HttpStatus.OK, null);        
        return new ResponseEntity<>(null, HttpStatus.OK);        
    }

}