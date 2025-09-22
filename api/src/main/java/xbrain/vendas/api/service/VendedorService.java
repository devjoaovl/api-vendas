package xbrain.vendas.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xbrain.vendas.api.dto.VendedorRequest;
import xbrain.vendas.api.dto.VendedorResponse;
import xbrain.vendas.api.entity.Vendedor;
import xbrain.vendas.api.repository.VendedorRepository;

@Service
@RequiredArgsConstructor
public class VendedorService {

    private final VendedorRepository vendedorRepository;

    public VendedorResponse criarVendedor(VendedorRequest request) {
        var vendedor = vendedorRepository.save(Vendedor.of(request));
        return VendedorResponse.of(vendedor);
    }
}
