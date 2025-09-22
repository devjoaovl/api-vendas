package xbrain.vendas.api.dto;


import lombok.*;
import xbrain.vendas.api.entity.Vendedor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendedorResponse {

    private long id;
    private String nome;

    public static VendedorResponse  of(Vendedor vendedor) {
        return VendedorResponse.builder()
                .id(vendedor.getId())
                .nome(vendedor.getNome())
                .build();
    }
}

