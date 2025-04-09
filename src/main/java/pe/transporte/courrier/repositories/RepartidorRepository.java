package pe.transporte.courrier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.transporte.courrier.entities.Repartidor;

public interface RepartidorRepository extends JpaRepository<Repartidor, Long>{
    
}
