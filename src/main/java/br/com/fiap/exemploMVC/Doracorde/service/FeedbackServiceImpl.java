package br.com.fiap.exemploMVC.Doracorde.service;

import br.com.fiap.exemploMVC.Doracorde.datasource.FeedbackRepository;
import br.com.fiap.exemploMVC.Doracorde.domainmodel.Feedback;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FeedbackServiceImpl implements FeedbackService{

    private FeedbackRepository repo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Feedback save(Feedback f) { return this.repo.save( f ); }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Feedback f) { this.repo.delete( f ); }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final long id ) { this.repo.deleteById( id ); }

    @Transactional(propagation = Propagation.NEVER)
    public Optional<Feedback> findById( final long id ) { return this.repo.findById( id ); }

    @Transactional(propagation = Propagation.NEVER)
    public List<Feedback> findAllFeedback() { return this.repo.findAll(); }
}
