package com.logistica.controller;

import com.logistica.entity.Producto;
import org.springframework.web.bind.annotation.*;

import com.logistica.service.ProductoService;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin()
@RestController
@RequestMapping({ "/api/producto" })
public class ProductoController {
    @Autowired
    private ProductoService servicePrincipal;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(servicePrincipal.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(servicePrincipal.findById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody Producto request){
        Producto s = servicePrincipal.create(request);
        return new ResponseEntity<>(servicePrincipal.create(request), HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Producto request) {
        return new ResponseEntity<>(servicePrincipal.update(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        servicePrincipal.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);        
    }

}