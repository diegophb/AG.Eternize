package br.org.eternize.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.eternize.model.Pacote;

public interface PacoteRepository extends JpaRepository<Pacote, Long> {

}
