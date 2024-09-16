package br.com.fiap.exemploMVC.Doracorde.service;

import br.com.fiap.exemploMVC.Doracorde.datasource.AcessibilidadeRepository;
import br.com.fiap.exemploMVC.Doracorde.domainmodel.Acessibilidade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AcessibilidadeServiceImpl implements AcessibilidadeService {

    private AcessibilidadeRepository repo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Acessibilidade save(Acessibilidade a) { return this.repo.save( a ); }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final Acessibilidade a) { this.repo.delete( a ); }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(long id) { this.repo.deleteById( id ); }

    @Transactional(propagation = Propagation.NEVER)
    public Optional<Acessibilidade> findById( final long id ){ return this.repo.findById( id ); }

    @Transactional(propagation = Propagation.NEVER)
    public List<Acessibilidade> findAllAcessibilidade() { return this.repo.findAll(); }
}
