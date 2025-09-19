package xbrain.vendas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xbrain.vendas.api.entity.Vendas;
import xbrain.vendas.api.entity.Vendedor;

import java.time.LocalDate;
import java.util.List;

public interface VendaRepository extends JpaRepository<Vendas, Long> {

    @Query("SELECT COUNT(v) FROM Vendas v WHERE v.dataVenda BETWEEN :inicio AND :fim AND v.vendedor.id = :idVendedor")
    Long countByPeriodo(@Param("inicio") LocalDate inicio,
                        @Param("fim") LocalDate fim,
                        @Param("idVendedor") Long idVendedor);
}
