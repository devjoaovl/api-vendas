package xbrain.vendas.api.entity;


import jakarta.persistence.*;
import lombok.*;
import xbrain.vendas.api.dto.VendedorRequest;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
    private List<Vendas> vendas = new ArrayList<>();

    public Vendedor(Long id) {
        this.id = id;
    }
    public static Vendedor of(VendedorRequest request){
       return Vendedor.builder()
               .nome(request.getNome())
               .build();
    }
}
