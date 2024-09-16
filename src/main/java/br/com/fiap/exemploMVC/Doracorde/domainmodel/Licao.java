package br.com.fiap.exemploMVC.Doracorde.domainmodel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_LICAO")
public class Licao {

    @Id
    @Column(name = "ID_LICAO")
    @GeneratedValue(generator = "SQ_LICAO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SQ_LICAO", sequenceName = "SQ_LICAO", allocationSize = 1)
    private Long id;


    private String nomeLicao;


    private String titulo;


    private String descricao;


    private String videoDemostracao;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_LICAO_INSTRUMENTO",
            joinColumns = {
                    @JoinColumn(
                            name = "LICAO",
                            referencedColumnName = "ID_LICAO",
                            foreignKey = @ForeignKey(name = "FK_LICAO_INSTRUMENTO")
                    )
            }, inverseJoinColumns = {
            @JoinColumn(
                    name = "INSTRUMENTO",
                    referencedColumnName = "ID_INSTRUMENTO",
                    foreignKey = @ForeignKey(name = "FK_INSTRUMENTO_LICAO")
            )
    }
    )
    private Set<Instrumento> instrumentos = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Licao licao)) return false;
        return id == licao.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
