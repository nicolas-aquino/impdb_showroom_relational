package com.meli.showroom_relacional.repository;

import com.meli.showroom_relacional.model.Prenda;
import com.meli.showroom_relacional.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVentaRepository extends JpaRepository<Venta, Long> {
    List<Prenda> findByFecha(String fecha);
}
