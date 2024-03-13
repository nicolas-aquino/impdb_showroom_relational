package com.meli.showroom_relacional.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VentaResponseDto {
    Long numero;
    LocalDate fecha;
    Double total;
    @JsonProperty("medio_de_pago")
    String medioDePago;
    List<PrendaResponseDto> prendas;
}
