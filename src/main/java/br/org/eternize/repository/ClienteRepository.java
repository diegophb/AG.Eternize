package br.org.eternize.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.eternize.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {


}
