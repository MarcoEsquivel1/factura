package com.example.factura.repository;

import com.example.factura.entity.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("detalleRepository")
public interface DetalleRepository extends
        JpaRepository<Detalle,Integer> {
}
