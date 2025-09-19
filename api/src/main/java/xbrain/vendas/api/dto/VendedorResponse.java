package xbrain.vendas.api.dto;


import lombok.*;
import xbrain.vendas.api.entity.Vendedor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendedorResponse {

    private String vendedorNome;
    private Long totalVendas;
    private Double mediaDiaria;

    public static VendedorResponse of(Vendedor vendedor, Long totalVendas, Double mediaDiaria) {
        return VendedorResponse.builder()
                .vendedorNome(vendedor.getNome())
                .totalVendas(totalVendas != null ? totalVendas : 0L)
                .mediaDiaria(mediaDiaria != null ? mediaDiaria : 0.0)
                .build();
    }
}

