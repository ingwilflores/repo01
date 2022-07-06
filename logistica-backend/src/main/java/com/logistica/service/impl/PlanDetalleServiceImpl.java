/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logistica.service.impl;

import com.logistica.entity.PlanDetalle;
import com.logistica.exeption.ResourceNotFoundException;
import com.logistica.repository.PlanDetalleRepository;
import com.logistica.service.PlanDetalleService;
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
public class PlanDetalleServiceImpl implements PlanDetalleService{
    @Autowired
    PlanDetalleRepository repositoryPrincipal;
    
    @Override
    public List<PlanDetalle> findAll(){
        return repositoryPrincipal.findAll(Sort.by(Sort.Direction.ASC, "idPlanDetalle"));
    }
    
    @Override
    public Optional<PlanDetalle> findById(Long id){
        return repositoryPrincipal.findById(id);
    }
    
    @Override
    public PlanDetalle create(PlanDetalle request){
        PlanDetalle s = repositoryPrincipal.save(request);
        return s;
    }
        
    @Override
    public PlanDetalle update(Long id, PlanDetalle request){
        PlanDetalle obj  = repositoryPrincipal.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el registro con id = " + id));
        obj.setIdPlan(request.getIdPlan());
        obj.setDescuentoAplicado(request.getDescuentoAplicado());
        obj.setPorcentajeDescuentoAplicado(request.getPorcentajeDescuentoAplicado());
        obj.setPrecioNormal(request.getPrecioNormal());
        
        return repositoryPrincipal.save(obj);
    }
    
    @Override
    public void delete(Long id){
        System.out.println("--id---"+id);
        repositoryPrincipal.deleteById(id);
        System.out.println("ELIMINADO");
    }
}
