package br.com.fiap.exemploMVC.Doracorde.domainmodel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_ACESSIBILIDADE")
public class Acessibilidade {
    @Id
    @Column(name = "ID_ACESSIBILIDADE")
    @GeneratedValue(generator = "SQ_ACESSIBILIDADE",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SQ_ACESSIBILIDADE",sequenceName = "SQ_ACESSIBILIDADE",allocationSize = 1)
    private Long id;

    private String legenda;

    private String descricaoAudio;

    private String constraste;

    private Integer tamanhoFonte;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Acessibilidade acessibilidade)) return false;
        return id == acessibilidade.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
