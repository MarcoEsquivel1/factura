package com.example.factura.controller;

import com.example.factura.entity.Detalle;
import com.example.factura.entity.Factura;
import com.example.factura.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
    @Autowired
    FacturaService facturaService;
    @GetMapping
    public List<Factura> getAll(){
        return facturaService.getAll();
    }
    @PostMapping(consumes = {"application/json", "application/x-www-form-urlencoded"})
    public Factura post(Factura factura){
        return facturaService.post(factura);
    }

    @GetMapping("/{id}")
    public Optional<Factura> getById(@PathVariable("id") Integer id) {
        return facturaService.getById(id);
    }

    @PutMapping("/{id}")
    public Optional<Factura> update(@PathVariable("id") Integer id, @RequestBody Factura factura) {
        return facturaService.update(id, factura);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        facturaService.delete(id);
    }
}
