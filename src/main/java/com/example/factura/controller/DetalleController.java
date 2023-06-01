package com.example.factura.controller;

import com.example.factura.entity.Detalle;
import com.example.factura.service.DetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/detalles")
public class DetalleController {
    @Autowired
    DetalleService detalleService;

    @GetMapping
    public Object getAll(){
        return detalleService.getAll();
    }

    @PostMapping(consumes = {"application/json", "application/x-www-form-urlencoded"})
    public Object post(@RequestBody Detalle detalle){
        return detalleService.post(detalle);
    }

    @GetMapping("/{id}")
    public Optional<Detalle> getById(@PathVariable("id") Integer id) {
        return detalleService.getById(id);
    }

    @PutMapping("/{id}")
    public Optional<Detalle> update(@PathVariable("id") Integer id, @RequestBody Detalle detalle) {
        return detalleService.update(id, detalle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        detalleService.delete(id);
    }

}
