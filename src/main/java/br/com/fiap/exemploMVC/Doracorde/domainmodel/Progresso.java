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
@Table(name = "TB_PROGRESSO")
public class Progresso {

    @Id
    @Column(name = "ID_PROGRESSO")
    @GeneratedValue(generator = "SQ_PROGRESSO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SQ_PROGRESSO", sequenceName = "SQ_PROGRESSO", allocationSize = 1)
    private Long id;


    private String progressao;


    private Integer pontuacao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_PROGRESSO_USUARIO",
            joinColumns = {
                    @JoinColumn(
                            name = "PROGRESSO",
                            referencedColumnName = "ID_PROGRESSO",
                            foreignKey = @ForeignKey(name = "FK_PROGRESSO_USUARIO")
                    )
            }, inverseJoinColumns = {
            @JoinColumn(                    name = "USUARIO",
                    referencedColumnName = "ID_USUARIO",
                    foreignKey = @ForeignKey(name = "FK_USUARIO_PROGRESSO")
            )
    }
    )
    private Usuario usuario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Progresso progresso)) return false;
        return id == progresso.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}