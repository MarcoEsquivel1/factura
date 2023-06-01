package com.example.factura.service;

import com.example.factura.entity.Detalle;
import com.example.factura.repository.DetalleRepository;
import com.example.factura.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

@Service("detalleService")
public class DetalleService {
    @Autowired
    FacturaRepository facturaRepository;
    @Autowired
    DetalleRepository detalleRepository;

    public List<Detalle> getAll(Integer id){
        List<Detalle> detalleList = facturaRepository.findById(id).get().getDetalleList();
        return detalleList;
    }

    public Detalle post(Detalle detalle){
        out.println(detalle.getFacturaid());
        return detalleRepository.save(detalle);
    }


    public Optional<Detalle> update(Integer id, Detalle detalle){
        Optional<Detalle> detalleInDB = detalleRepository.findById(id);

        //verify in detalle if the attribute is null, if it is null, it will not be updated
        if(detalle.getProducto() != null){
            detalleInDB.get().setProducto(detalle.getProducto());
        }
        if(detalle.getCantidad() != null){
            detalleInDB.get().setCantidad(detalle.getCantidad());
        }
        if(detalle.getSubtotal() != null){
            detalleInDB.get().setSubtotal(detalle.getSubtotal());
        }

        //save
        detalleRepository.save(detalleInDB.get());
        return detalleInDB;
    }

    public void delete(Integer id){
        detalleRepository.deleteById(id);
    }
}
