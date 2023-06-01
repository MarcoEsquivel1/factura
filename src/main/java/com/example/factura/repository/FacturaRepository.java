package com.example.factura.repository;

import com.example.factura.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("facturaRepository")
public interface FacturaRepository extends JpaRepository<Factura,Integer> {
}

