package xbrain.vendas.api.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xbrain.vendas.api.dto.VendaRequest;
import xbrain.vendas.api.dto.RelatorioResponse;
import xbrain.vendas.api.dto.VendaResponse;
import xbrain.vendas.api.entity.Vendas;
import xbrain.vendas.api.service.VendaService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vendas")
@RequiredArgsConstructor
public class VendaController {

    private final VendaService vendaService;

    @GetMapping
    public List<Vendas> listarTodasVendas() {
        return vendaService.listarTodasVendas();
    }

    @GetMapping("/relatorio")
    public List<RelatorioResponse> relatorio(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim) {
        return vendaService.relatorio(inicio, fim);
    }


    @PostMapping
    public VendaResponse criarVenda(@RequestBody VendaRequest vendas) {
        return vendaService.criarVenda(vendas);
    }
}
