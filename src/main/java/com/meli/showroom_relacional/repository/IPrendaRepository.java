package com.meli.showroom_relacional.repository;

import com.meli.showroom_relacional.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrendaRepository extends JpaRepository<Prenda, Long> {

    List<Prenda> findPrendasByTalle(String size);
    List<Prenda> findByNombreContainsIgnoreCase(String name);

}
