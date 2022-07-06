/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logistica.service.impl;

import com.logistica.entity.TipoProducto;
import com.logistica.exeption.ResourceNotFoundException;
import com.logistica.repository.TipoProductoRepository;
import com.logistica.service.TipoProductoService;
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
public class TipoProductoServiceImpl implements TipoProductoService{
    @Autowired
    TipoProductoRepository repositoryPrincipal;
    
    @Override
    public List<TipoProducto> findAll(){
        return repositoryPrincipal.findAll(Sort.by(Sort.Direction.ASC, "idTipoProducto"));
    }
    
    @Override
    public Optional<TipoProducto> findById(Long id){
        return repositoryPrincipal.findById(id);
    }
    
    @Override
    public TipoProducto create(TipoProducto request){
        TipoProducto s = repositoryPrincipal.save(request);
        return s;
    }
        
    @Override
    public TipoProducto update(Long id, TipoProducto request){
        TipoProducto obj  = repositoryPrincipal.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el registro con id = " + id));
        obj.setCodigo(request.getCodigo());
        obj.setNombre(request.getNombre());
        obj.setDescripcion(request.getDescripcion());
        
        return repositoryPrincipal.save(obj);
    }
    
    @Override
    public void delete(Long id){
        System.out.println("--id---"+id);
        repositoryPrincipal.deleteById(id);
        System.out.println("ELIMINADO");
    }
}
