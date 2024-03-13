package com.meli.showroom_relacional.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrendaRequestDto {

    String nombre;
    String tipo;
    String marca;
    String color;
    String talle;
    Integer cantidad;
    @JsonProperty("precio_venta")
    Double precioVenta;

}

