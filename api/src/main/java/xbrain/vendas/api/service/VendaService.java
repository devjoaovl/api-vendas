package xbrain.vendas.api.service;

import org.springframework.stereotype.Service;
import xbrain.vendas.api.dto.RelatorioVendedorDTO;
import xbrain.vendas.api.entity.Venda;
import xbrain.vendas.api.repository.VendaRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService {
    private final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Venda criarVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    public List<RelatorioVendedorDTO> relatorio(LocalDate inicio, LocalDate fim) {
        List<Venda> vendas = vendaRepository.findByPeriodo(inicio, fim);
        long dias = ChronoUnit.DAYS.between(inicio, fim) + 1;

        return vendas.stream()
                .collect(Collectors.groupingBy(Venda::getVendedorNome,
                        Collectors.summingDouble(Venda::getValor)))
                .entrySet()
                .stream()
                .map(e -> new RelatorioVendedorDTO(
                        e.getKey(),
                        e.getValue(),
                        e.getValue() / dias
                ))
                .collect(Collectors.toList());
    }
}
