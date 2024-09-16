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
@Table(name = "TB_INSTRUMENTO")
public class Instrumento {
    @Id
    @Column(name = "ID_INSTRUMENTO")
    @GeneratedValue(generator = "SQ_INSTRUMENTO",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SQ_INSTRUMENTO",sequenceName = "SQ_INSTRUMENTO",allocationSize = 1)
    private Long id;

    private String nomeInstrumento;

    private String categoria;

    private String dificuldade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instrumento instrumento)) return false;
        return id == instrumento.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
