package pe.transporte.courrier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.transporte.courrier.entities.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long>{
    
}
