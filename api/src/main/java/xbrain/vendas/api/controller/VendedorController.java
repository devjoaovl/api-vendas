package xbrain.vendas.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xbrain.vendas.api.dto.VendedorRequest;
import xbrain.vendas.api.dto.VendedorResponse;
import xbrain.vendas.api.service.VendedorService;

@RestController
@RequestMapping("/vendedores")
@RequiredArgsConstructor
public class VendedorController {

    private final VendedorService vendedorService;

    @PostMapping
    public VendedorResponse criarVendedor(@RequestBody VendedorRequest vendedorRequest) {
        return vendedorService.criarVendedor(vendedorRequest);
    }
}
