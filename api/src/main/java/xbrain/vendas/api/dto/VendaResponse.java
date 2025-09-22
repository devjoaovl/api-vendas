package xbrain.vendas.api.dto;

import lombok.*;
import xbrain.vendas.api.entity.Vendas;
import xbrain.vendas.api.entity.Vendedor;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendaResponse {
    private long id;
    private LocalDate dataVenda;
    private Double valorVenda;
    private VendedorResponse vendedor;

    public static VendaResponse of(Vendas venda, Vendedor vendedor) {
        return VendaResponse.builder()
                .id(venda.getId())
                .dataVenda(venda.getDataVenda())
                .valorVenda(venda.getValor())
                .vendedor(VendedorResponse.of(vendedor))
                .build();
    }
}
