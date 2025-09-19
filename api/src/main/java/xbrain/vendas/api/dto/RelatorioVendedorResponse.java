package xbrain.vendas.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

    @Getter
    @AllArgsConstructor
    public class RelatorioVendedorResponse {
        private String nome;
        private Double totalVendas;
        private Double mediaDiaria;
    }
