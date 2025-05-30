package pe.transporte.courrier.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.transporte.courrier.entities.ClienteTemporal;

public interface ClienteTemporalRepository extends JpaRepository<ClienteTemporal, Long>{
    Optional<ClienteTemporal> findByDni(String dni);
}
