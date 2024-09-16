package br.com.fiap.exemploMVC.Doracorde.service;

import br.com.fiap.exemploMVC.Doracorde.datasource.LicaoRepository;
import br.com.fiap.exemploMVC.Doracorde.domainmodel.Licao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LicaoServiceImpl implements LicaoService{

    private LicaoRepository repo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Licao save(Licao l) { return this.repo.save( l ); }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Licao l) { this.repo.delete( l ); }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final long id) { this.repo.deleteById( id ); }

    @Transactional(propagation = Propagation.NEVER)
    public Optional<Licao> findById(final long id) { return this.repo.findById( id ); }

    @Transactional(propagation = Propagation.NEVER)
    public List<Licao> findAllLicao() { return this.repo.findAll(); }
}
