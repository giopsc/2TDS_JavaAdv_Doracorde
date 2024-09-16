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
@Table(name = "TB_USUARIO")
public class Usuario {

    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(generator = "SQ_USUARIO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SQ_USUARIO", sequenceName = "SQ_USUARIO",allocationSize = 1)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
