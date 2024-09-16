package br.com.fiap.exemploMVC.Doracorde.datasource;

import br.com.fiap.exemploMVC.Doracorde.domainmodel.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{}
