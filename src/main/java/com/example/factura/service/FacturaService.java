package com.example.factura.service;

import com.example.factura.entity.Detalle;
import com.example.factura.entity.Factura;
import com.example.factura.repository.DetalleRepository;
import com.example.factura.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service("facturaService")
public class FacturaService {
    @Autowired
    FacturaRepository facturaRepository;
    @Autowired
    DetalleRepository detalleRepository;

    public List<Factura> getAll(){
        return facturaRepository.findAll();
    }

    public Factura post(Factura factura){
        return facturaRepository.save(factura);
    }


    public Optional<Factura> getById(@PathVariable("id") Integer id){
        Optional<Factura> factura = facturaRepository.findById(id);
        return factura;
    }

    public Optional<Factura> update(Integer id, Factura factura){
        Optional<Factura> facturaInDB = facturaRepository.findById(id);

        //verify in factura if the attribute is null, if it is null, it will not be updated
        if(factura.getFecha() != null){
            facturaInDB.get().setFecha(factura.getFecha());
        }
        if(factura.getNombre() != null){
            facturaInDB.get().setNombre(factura.getNombre());
        }
        if(factura.getDireccion() != null){
            facturaInDB.get().setDireccion(factura.getDireccion());
        }
        if(factura.getDui() != null){
            facturaInDB.get().setDui(factura.getDui());
        }
        if(factura.getTotal() != null) {
            facturaInDB.get().setTotal(factura.getTotal());
        }

        //save
        facturaRepository.save(facturaInDB.get());
        return facturaInDB;
    }

    public void delete(Integer id){
        facturaRepository.deleteById(id);
    }

}

