package br.com.fiap.exemploMVC.Doracorde.datasource;

import br.com.fiap.exemploMVC.Doracorde.domainmodel.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{}
