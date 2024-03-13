package com.meli.showroom_relacional.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VentaRequestDto {
    LocalDate fecha;
    Double total;
    @JsonProperty("medio_de_pago")
    String medioDePago;
    @JsonProperty("ids_prenda")
    Set<Long> idsPrenda;
}
