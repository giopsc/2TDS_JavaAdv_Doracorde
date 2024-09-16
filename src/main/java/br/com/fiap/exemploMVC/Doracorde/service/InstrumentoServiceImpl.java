package br.com.fiap.exemploMVC.Doracorde.service;

import br.com.fiap.exemploMVC.Doracorde.datasource.InstrumentoRepository;
import br.com.fiap.exemploMVC.Doracorde.domainmodel.Instrumento;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class InstrumentoServiceImpl implements InstrumentoService {

    private InstrumentoRepository repo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Instrumento save(Instrumento i) { return this.repo.save( i ); }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final Instrumento i) { this.repo.delete( i ); }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(long id) { this.repo.deleteById( id ); }

    @Transactional(propagation = Propagation.NEVER)
    public Optional<Instrumento> findById(long id) { return this.repo.findById( id ); }

    @Transactional(propagation = Propagation.NEVER)
    public List<Instrumento> findAllInstrumento() { return this.repo.findAll(); }
}
