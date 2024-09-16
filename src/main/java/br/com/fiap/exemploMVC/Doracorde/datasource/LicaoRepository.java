package br.com.fiap.exemploMVC.Doracorde.datasource;

import br.com.fiap.exemploMVC.Doracorde.domainmodel.Licao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LicaoRepository extends JpaRepository<Licao, Long>{}
