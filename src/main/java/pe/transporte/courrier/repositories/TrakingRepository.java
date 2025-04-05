package pe.transporte.courrier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.transporte.courrier.entities.Tracking;

public interface TrakingRepository extends JpaRepository<Tracking, Long>{
    
}
