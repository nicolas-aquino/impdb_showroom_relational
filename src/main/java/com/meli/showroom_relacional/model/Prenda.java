package com.meli.showroom_relacional.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "prendas")
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;
    String nombre;
    String tipo;
    String marca;
    String color;
    String talle;
    Integer cantidad;
    Double precio_venta;
    @ManyToMany(mappedBy = "listaDePrendas")
    List<Venta> ventas;
}
