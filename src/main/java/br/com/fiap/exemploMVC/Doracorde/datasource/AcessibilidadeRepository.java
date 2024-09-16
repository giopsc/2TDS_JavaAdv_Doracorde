package br.com.fiap.exemploMVC.Doracorde.datasource;

import br.com.fiap.exemploMVC.Doracorde.domainmodel.Acessibilidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcessibilidadeRepository extends JpaRepository<Acessibilidade, Long>{}
