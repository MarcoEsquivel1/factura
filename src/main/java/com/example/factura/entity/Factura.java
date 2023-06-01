package com.example.factura.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name = "idfactura")
    private Integer idfactura;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "dui")
    private String dui;
    @Column(name = "fecha")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;
    @Column(name = "total")
    private Double total;
    @OneToMany(mappedBy = "factutaId")
    private List<Detalle> detalleList;
}
