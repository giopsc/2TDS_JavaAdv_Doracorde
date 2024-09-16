package br.com.fiap.exemploMVC.Doracorde.datasource;

import br.com.fiap.exemploMVC.Doracorde.domainmodel.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentoRepository extends JpaRepository<Instrumento, Long>{}
