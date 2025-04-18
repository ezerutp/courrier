package pe.transporte.courrier.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.transporte.courrier.entities.Repartidor;
import pe.transporte.courrier.entities.Repartidor.Estado;

public interface RepartidorRepository extends JpaRepository<Repartidor, Long>{

        Optional<Repartidor> findByPlacaVehiculo(String placaVehiculo);
        boolean existsByPlacaVehiculo(String placaVehiculo);
        List<Repartidor> findByTipoVehiculo(String tipoVehiculo);
        List<Repartidor> findByEstado(Estado estado);
}
