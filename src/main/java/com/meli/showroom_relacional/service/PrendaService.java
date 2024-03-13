package com.meli.showroom_relacional.service;

import com.meli.showroom_relacional.dto.request.PrendaRequestDto;
import com.meli.showroom_relacional.dto.response.PrendaResponseDto;
import com.meli.showroom_relacional.model.Prenda;
import com.meli.showroom_relacional.repository.IPrendaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaService {

    IPrendaRepository prendaRepository;

    ModelMapper mapper = new ModelMapper();

    public PrendaService(IPrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
    }

    public PrendaResponseDto savePrenda(PrendaRequestDto prendaDTO) {
        Prenda prenda = mapper.map(
                prendaDTO,
                Prenda.class
        );
        return mapper.map(
                prendaRepository.save(prenda),
                PrendaResponseDto.class
        );
    }

    public List<PrendaResponseDto> getAllPrendas() {
        return mapper.map(
                prendaRepository.findAll(),
                new TypeToken<List<PrendaResponseDto>>() {}.getType()
        );
    }

    public PrendaResponseDto getPrendaByCode(Long code) {
        return mapper.map(
                prendaRepository.findById(code),
                PrendaResponseDto.class
        );
    }

    public PrendaResponseDto updatePrenda(Long code, PrendaRequestDto prendaDTO) {
        Prenda prenda = prendaRepository.findById(code).get();

        mapper.map(prendaDTO, prenda);

        prendaRepository.save(prenda);
        return mapper.map(prenda, PrendaResponseDto.class);
    }

    public PrendaResponseDto deletePrenda(Long code) {
        PrendaResponseDto prendaResponseDTO =
                mapper.map(prendaRepository.findById(code).get(), PrendaResponseDto.class);

        prendaRepository.deleteById(code);

        return prendaResponseDTO;
    }

    public List<PrendaResponseDto> getPrendaBySize(String size) {
        return mapper.map(
                prendaRepository.findPrendasByTalle(size),
                new TypeToken<List<PrendaResponseDto>>() {}.getType()
        );
    }

    public List<PrendaResponseDto> getPrendaByContainsName(String name) {
        return mapper.map(
                prendaRepository.findByNombreContainsIgnoreCase(name),
                new TypeToken<List<PrendaResponseDto>>() {}.getType()
        );
    }

}
