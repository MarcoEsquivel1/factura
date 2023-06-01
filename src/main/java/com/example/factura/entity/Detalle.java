package com.example.factura.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "detalle")
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer iddetalle;
    @Column(name = "producto")
    private String producto;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "subtotal")
    private Double subtotal;
    @Column(name = "factura_id")
    private Integer factutaId;
}
