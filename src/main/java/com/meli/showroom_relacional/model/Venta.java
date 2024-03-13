package com.meli.showroom_relacional.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numero;
    LocalDate fecha;
    Double total;
    String medioDePago;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "ventas_prendas",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "prenda_id")
    )
    List<Prenda> listaDePrendas;
}
