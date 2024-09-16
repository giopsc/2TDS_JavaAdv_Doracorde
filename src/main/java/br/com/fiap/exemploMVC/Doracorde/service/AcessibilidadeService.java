package br.com.fiap.exemploMVC.Doracorde.service;

import br.com.fiap.exemploMVC.Doracorde.domainmodel.Acessibilidade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AcessibilidadeService{

    Acessibilidade save(Acessibilidade a);

    void delete(Acessibilidade a);

    void deleteById(long id);

    List<Acessibilidade> findAllAcessibilidade();

}