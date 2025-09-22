package xbrain.vendas.api.dto;


import lombok.*;
import xbrain.vendas.api.entity.Vendedor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioResponse {

    private String vendedorNome;
    private Long totalVendas;
    private Double mediaDiaria;

    public static RelatorioResponse of(Vendedor vendedor, Long totalVendas, Double mediaDiaria) {
        return RelatorioResponse.builder()
                .vendedorNome(vendedor.getNome())
                .totalVendas(totalVendas != null ? totalVendas : 0L)
                .mediaDiaria(mediaDiaria != null ? mediaDiaria : 0.0)
                .build();
    }
}

