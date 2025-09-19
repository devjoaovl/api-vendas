package xbrain.vendas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xbrain.vendas.api.entity.Vendas;
import xbrain.vendas.api.entity.Vendedor;

import java.time.LocalDate;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

}
