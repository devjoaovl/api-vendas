package xbrain.vendas.api.controller;


import org.springframework.web.bind.annotation.*;
import xbrain.vendas.api.dto.VendaRequest;
import xbrain.vendas.api.dto.VendedorRequest;
import xbrain.vendas.api.dto.VendedorResponse;
import xbrain.vendas.api.entity.Vendas;
import xbrain.vendas.api.entity.Vendedor;
import xbrain.vendas.api.service.VendaService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {
    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @GetMapping
    public List<Vendas> listarTodasVendas() {
        return vendaService.listarTodasVendas();
    }

    @GetMapping("/relatorio")
    public List<VendedorResponse> relatorio(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim) {
        return vendaService.relatorio(inicio, fim);
    }


    @PostMapping
    public Vendas criarVenda(@RequestBody VendaRequest vendas) {
        return vendaService.criarVenda(vendas);
    }

    @PostMapping("vendedor")
    public Vendedor criarVendedor(@RequestBody VendedorRequest vendedorRequest) {
        return vendaService.criarVendedor(vendedorRequest);
    }
}
