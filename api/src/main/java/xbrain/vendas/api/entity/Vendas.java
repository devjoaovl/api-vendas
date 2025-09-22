package xbrain.vendas.api.entity;

import jakarta.persistence.*;
import lombok.*;
import xbrain.vendas.api.dto.VendaRequest;


import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "venda")
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_venda")
    private LocalDate dataVenda;

    @Column(name = "valor")
    private Double valor;

    @JoinColumn(name = "FK_vendedor")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vendedor vendedor;

    public static Vendas of(VendaRequest request){
        return Vendas.builder()
                .dataVenda(request.getDataVenda())
                .valor(request.getValorVenda())
                .vendedor(new Vendedor(request.getIdVendedor()))
                .build();
    }
}
