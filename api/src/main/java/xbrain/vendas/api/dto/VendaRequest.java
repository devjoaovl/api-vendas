package xbrain.vendas.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendaRequest {
    private double valorVenda;
    private LocalDate dataVenda;
    private Long idVendedor;

}
