package pe.transporte.courrier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.transporte.courrier.entities.Encomienda;

public interface EncomiendaRepository extends JpaRepository<Encomienda, Long>{
    
}
