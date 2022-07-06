/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logistica.service.impl;

import com.logistica.entity.Producto;
import com.logistica.exeption.ResourceNotFoundException;
import com.logistica.repository.ProductoRepository;
import com.logistica.service.ProductoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    ProductoRepository repositoryPrincipal;
    
    @Override
    public List<Producto> findAll(){
        return repositoryPrincipal.findAll(Sort.by(Sort.Direction.ASC, "idProducto"));
    }
    
    @Override
    public Optional<Producto> findById(Long id){
        return repositoryPrincipal.findById(id);
    }
    
    @Override
    public Producto create(Producto request){
        Producto s = repositoryPrincipal.save(request);
        return s;
    }
        
    @Override
    public Producto update(Long id, Producto request){
        Producto obj  = repositoryPrincipal.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el registro con id = " + id));
        obj.setCodigo(request.getCodigo());
        obj.setNombre(request.getNombre());
        obj.setDescripcion(request.getDescripcion());
        obj.setIdTipoProducto(request.getIdTipoProducto());
        
        return repositoryPrincipal.save(obj);
    }
    
    @Override
    public void delete(Long id){
        System.out.println("--id---"+id);
        repositoryPrincipal.deleteById(id);
        System.out.println("ELIMINADO");
    }
}
