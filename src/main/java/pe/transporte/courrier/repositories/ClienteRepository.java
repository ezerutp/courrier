package pe.transporte.courrier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.transporte.courrier.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
