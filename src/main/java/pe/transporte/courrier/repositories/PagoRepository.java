package pe.transporte.courrier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.transporte.courrier.entities.Pago;
import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long>{
    List<Pago> findByTipoPago(Pago.TipoPago tipoPago);
    List<Pago> findByEstado(Pago.EstadoPago estado);
}
