package br.org.eternize.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.org.eternize.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    Optional<Reserva> findById(Long id_reserva);
}
