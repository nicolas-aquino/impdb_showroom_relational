package com.meli.showroom_relacional.controller;

import com.meli.showroom_relacional.dto.request.PrendaRequestDto;
import com.meli.showroom_relacional.dto.response.PrendaResponseDto;
import com.meli.showroom_relacional.service.PrendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {

    private PrendaService prendaService;

    public PrendaController(PrendaService prendaService) {
        this.prendaService = prendaService;
    }

    @PostMapping("")
    public ResponseEntity<PrendaResponseDto> createPrenda(
            @RequestBody
            PrendaRequestDto prendaDTO
    ) {
        return ResponseEntity.ok(prendaService.savePrenda(prendaDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<PrendaResponseDto>> findAllPrendas() {
        return ResponseEntity.ok(prendaService.getAllPrendas());
    }

    @GetMapping("/{code}")
    public ResponseEntity<PrendaResponseDto> findPrendaById(
            @PathVariable
            Long code
    ) {
        return ResponseEntity.ok(prendaService.getPrendaByCode(code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<PrendaResponseDto> updatePrenda(
            @PathVariable
            Long code,
            @RequestBody
            PrendaRequestDto prendaDTO
    ) {
        return ResponseEntity.ok(prendaService.updatePrenda(code, prendaDTO));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<PrendaResponseDto> deletePrenda(
            @PathVariable
            Long code
    ) {
        return ResponseEntity.ok(prendaService.deletePrenda(code));
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<List<PrendaResponseDto>> findPrendaBySize(
            @PathVariable
            String size
    ) {
        return ResponseEntity.ok(prendaService.getPrendaBySize(size));
    }

    @GetMapping("/contains")
    public ResponseEntity<List<PrendaResponseDto>> getPrendasByContainsName(
            @RequestParam(name = "name")
            String name
    ) {
        return ResponseEntity.ok(prendaService.getPrendaByContainsName(name));
    }

}
