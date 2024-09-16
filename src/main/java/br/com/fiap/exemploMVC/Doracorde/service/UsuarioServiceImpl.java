package br.com.fiap.exemploMVC.Doracorde.service;

import br.com.fiap.exemploMVC.Doracorde.datasource.UsuarioRepository;
import br.com.fiap.exemploMVC.Doracorde.domainmodel.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository repo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Usuario save(Usuario u) { return this.repo.save( u ); }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Usuario u) { this.repo.delete( u ); }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final long id) { this.repo.deleteById( id ); }

    @Transactional(propagation = Propagation.NEVER)
    public Optional<Usuario> findById(final long id) { return this.repo.findById( id ); }

    @Transactional(propagation = Propagation.NEVER)
    public List<Usuario> findAllUsuario() { return this.repo.findAll(); }
}
