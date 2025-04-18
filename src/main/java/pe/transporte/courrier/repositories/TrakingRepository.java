package pe.transporte.courrier.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.transporte.courrier.entities.Tracking;

public interface TrakingRepository extends JpaRepository<Tracking, Long>{
    List<Tracking> findByEncomiendaIdOrderByFechaHoraAsc(Long encomiendaId);
    Optional<Tracking> findTopByEncomiendaIdOrderByFechaHoraDesc(Long encomiendaId);
}
