package com.logistica.repository;

import com.logistica.entity.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long> {

}