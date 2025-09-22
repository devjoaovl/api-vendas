package xbrain.vendas.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xbrain.vendas.api.dto.VendaRequest;
import xbrain.vendas.api.dto.RelatorioResponse;
import xbrain.vendas.api.dto.VendaResponse;
import xbrain.vendas.api.entity.Vendas;
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

    public VendaResponse criarVenda(VendaRequest request) {
        var vendedor = vendedorRepository.findById(request.getIdVendedor())
                .orElseThrow(() -> new RuntimeException("Vendedor não encontrado."));
        var venda = vendaRepository.save(Vendas.of(request));
        return VendaResponse.of(venda,vendedor);
    }

    public List<Vendas> listarTodasVendas() {
        return vendaRepository.findAll();
    }

    public List<RelatorioResponse> relatorio(LocalDate inicio, LocalDate fim) {
        return vendedorRepository.findAll().stream()
                .map(vendedor -> {
                    var totalVendas = buscarTotalVendas(vendedor.getId(), inicio, fim);
                    var mediaDiaria = calcularMediaDiaria( vendedor.getId(), inicio, fim);
                    return RelatorioResponse.of(vendedor, totalVendas, mediaDiaria);
                })
                .toList();
    }

    private Long buscarTotalVendas(Long vendedorId, LocalDate inicio, LocalDate fim) {
        return vendaRepository.countByPeriodo(inicio, fim, vendedorId);
    }

    private double calcularMediaDiaria(Long vendedorId, LocalDate inicio, LocalDate fim) {
        var soma = vendaRepository.sumByPeriodo(inicio, fim, vendedorId);
        var dias = ChronoUnit.DAYS.between(inicio, fim) + 1;
        var media = dias > 0 ? soma / dias : 0.0;
        return Math.round(media * 100.0) / 100.0;
    }
}
