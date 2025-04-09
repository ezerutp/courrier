package pe.transporte.courrier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.transporte.courrier.entities.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long>{
    
}
