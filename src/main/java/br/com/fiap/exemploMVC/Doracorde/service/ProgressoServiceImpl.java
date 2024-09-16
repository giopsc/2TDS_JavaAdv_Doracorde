package br.com.fiap.exemploMVC.Doracorde.service;

import br.com.fiap.exemploMVC.Doracorde.datasource.ProgressoRepository;
import br.com.fiap.exemploMVC.Doracorde.domainmodel.Progresso;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProgressoServiceImpl implements ProgressoService{

    private ProgressoRepository repo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Progresso save(Progresso p) { return this.repo.save( p ); }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Progresso p) { this.repo.delete( p ); }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final long id) { this.repo.deleteById( id ); }

    @Transactional(propagation = Propagation.NEVER)
    public Optional<Progresso> findById(final long id) { return this.repo.findById( id ); }

    @Transactional(propagation = Propagation.NEVER)
    public List<Progresso> findAllProgresso() { return this.repo.findAll(); }
}
