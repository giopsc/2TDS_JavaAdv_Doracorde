package br.com.fiap.exemploMVC.Doracorde.service;

import br.com.fiap.exemploMVC.Doracorde.domainmodel.Licao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LicaoService{

    Licao save(Licao l);

    void delete(Licao l);

    void deleteById(long id);

    List<Licao> findAllLicao();

}
