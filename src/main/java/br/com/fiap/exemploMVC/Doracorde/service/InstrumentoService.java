package br.com.fiap.exemploMVC.Doracorde.service;

import br.com.fiap.exemploMVC.Doracorde.domainmodel.Instrumento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InstrumentoService{

    Instrumento save (Instrumento i);

    void delete ( Instrumento i );

    void deleteById ( long id );

    List<Instrumento> findAllInstrumento();
}
