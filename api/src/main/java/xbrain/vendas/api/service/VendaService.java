package xbrain.vendas.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xbrain.vendas.api.dto.VendaRequest;
import xbrain.vendas.api.dto.VendedorRequest;
import xbrain.vendas.api.dto.VendedorResponse;
import xbrain.vendas.api.entity.Vendas;
import xbrain.vendas.api.entity.Vendedor;
import xbrain.vendas.api.repository.VendaRepository;
import xbrain.vendas.api.repository.VendedorRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RequiredArgsConstructor
@Service
public class VendaService {
    private final VendaRepository vendaRepository;
    private final VendedorRepository vendedorRepository;


    public Vendas criarVenda(VendaRequest request) {
        return vendaRepository.save(Vendas.of(request));
    }

    public Vendedor criarVendedor(VendedorRequest request) {
        return vendedorRepository.save(Vendedor.of(request));
    }

    public List<Vendas> listarTodasVendas() {
        return vendaRepository.findAll();
    }



    public List<VendedorResponse> relatorio(LocalDate inicio, LocalDate fim) {
        return vendedorRepository.findAll().stream()
                .map(vendedor -> {
                    var totalVendas = vendaRepository.countByPeriodo(inicio, fim, vendedor.getId());
                    return VendedorResponse.of(vendedor, totalVendas, 0.0);
                })
                .toList();
    }
}
