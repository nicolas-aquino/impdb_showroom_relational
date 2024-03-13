package com.meli.showroom_relacional.controller;

import com.meli.showroom_relacional.dto.response.MessageDto;
import com.meli.showroom_relacional.dto.request.VentaRequestDto;
import com.meli.showroom_relacional.dto.response.PrendaResponseDto;
import com.meli.showroom_relacional.dto.response.VentaResponseDto;
import com.meli.showroom_relacional.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class VentaController {

    private VentaService service;

    public VentaController(VentaService service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<VentaResponseDto> crearVenta(@RequestBody VentaRequestDto ventaDto) {
        return new ResponseEntity<>(service.crearVenta(ventaDto), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<VentaResponseDto>> getAll() {
        return new ResponseEntity<>(service.findVentas(), HttpStatus.OK);
    }

    @GetMapping("/{number}")
    public ResponseEntity<VentaResponseDto> getVentaByNumber(@PathVariable Long number) {
       return new ResponseEntity<>(service.findVentaByNumero(number), HttpStatus.OK);
    }

    @PutMapping("/{number}")
    public ResponseEntity<VentaResponseDto> updateVenta(@PathVariable Long number, @RequestBody VentaRequestDto ventaDto) {
        return new ResponseEntity<>(service.updateVenta(number, ventaDto), HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<MessageDto> deleteVenta(@PathVariable Long number) {
        return new ResponseEntity<>(service.deleteVenta(number), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<VentaResponseDto>> getVentasByDate(@RequestParam String date) {
        return new ResponseEntity<>(service.findVentasByDate(date), HttpStatus.OK);
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<PrendaResponseDto>> getClothesBySale(@PathVariable Long number) {
        return new ResponseEntity<>(service.findClothesBySale(number), HttpStatus.OK);
    }
}
