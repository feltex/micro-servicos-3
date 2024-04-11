package br.com.feltex.streamservice.domain;

import br.com.feltex.streamservice.domain.model.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamRepository extends JpaRepository<Stream, Long> {

}
