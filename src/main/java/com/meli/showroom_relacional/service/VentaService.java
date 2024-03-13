package com.meli.showroom_relacional.service;


import com.meli.showroom_relacional.dto.request.VentaRequestDto;
import com.meli.showroom_relacional.dto.response.MessageDto;
import com.meli.showroom_relacional.dto.response.PrendaResponseDto;
import com.meli.showroom_relacional.dto.response.VentaResponseDto;
import com.meli.showroom_relacional.exception.NotFoundException;
import com.meli.showroom_relacional.model.Prenda;
import com.meli.showroom_relacional.model.Venta;
import com.meli.showroom_relacional.repository.IPrendaRepository;
import com.meli.showroom_relacional.repository.IVentaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    ModelMapper mapper = new ModelMapper();
    IVentaRepository ventaRepository;
    IPrendaRepository prendaRepository;

    public VentaService(IVentaRepository ventaRepository, IPrendaRepository prendaRepository) {
        this.ventaRepository = ventaRepository;
        this.prendaRepository = prendaRepository;
    }

    public VentaResponseDto crearVenta(VentaRequestDto ventaDto) {
        List<Prenda> prendas = prendaRepository.findAllById(ventaDto.getIdsPrenda());
        Venta nueva = mapper.map(ventaDto, Venta.class);
        nueva.setListaDePrendas(prendas);
        Venta response = ventaRepository.save(nueva);
        return mapper.map(response, VentaResponseDto.class);
    }

    public List<VentaResponseDto> findVentas() {
        return mapper.map(
                ventaRepository.findAll(),
                new TypeToken<List<VentaResponseDto>>() {}.getType()
        );
    }

    public VentaResponseDto findVentaByNumero(Long numeroVenta) {
        Venta venta = auxFindVentaByNumero(numeroVenta);
        return mapper.map(venta, VentaResponseDto.class);
    }

    public VentaResponseDto updateVenta(Long numeroVenta, VentaRequestDto ventaDto) {
        auxFindVentaByNumero(numeroVenta);
        return crearVenta(ventaDto);
    }

    public MessageDto deleteVenta(Long numeroVenta) {
        auxFindVentaByNumero(numeroVenta);
        ventaRepository.deleteById(numeroVenta);
        return new MessageDto("Venta removida con éxito");
    }

    public List<VentaResponseDto> findVentasByDate(String date) {
        // validar input
        return mapper.map(
                ventaRepository.findByFecha(date),
                new TypeToken<List<VentaResponseDto>>() {}.getType()
        );
    }

    public List<PrendaResponseDto> findClothesBySale(Long numeroVenta) {
        Venta venta = auxFindVentaByNumero(numeroVenta);
        return mapper.map(
                venta.getListaDePrendas(),
                new TypeToken<List<PrendaResponseDto>>() {}.getType()
        );
    }

    private Venta auxFindVentaByNumero(Long numeroVenta) {
        return ventaRepository.findById(numeroVenta)
                .orElseThrow(() -> new NotFoundException("No se encontro ninguna venta con ese numero"));
    }
}
