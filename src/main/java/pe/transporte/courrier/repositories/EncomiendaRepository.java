package pe.transporte.courrier.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.transporte.courrier.entities.Encomienda;
import pe.transporte.courrier.entities.Encomienda.Estado;

public interface EncomiendaRepository extends JpaRepository<Encomienda, Long> {
    // Para los remitentes (Usuario) formal
    List<Encomienda> findByClienteRemitenteId(Long id);
    List<Encomienda> findByClienteRemitenteDni(String dni);

    // Para los remitentes temporales (ClienteTemporal);
    List<Encomienda> findByRemitenteTemporalId(Long id);
    List<Encomienda> findByRemitenteTemporalDni(String dni);

    // Para los destinatarios (Usuario)
    List<Encomienda> findByClienteDestinatarioId(Long id);
    List<Encomienda> findByClienteDestinatarioDni(String dni);

    // Para los destinatarios temporales (ClienteTemporal)
    List<Encomienda> findByDestinatarioTemporalId(Long id);
    List<Encomienda> findByDestinatarioTemporalDni(String dni);
    
    // Otros atributos
    List<Encomienda> findByEstado(Estado estado);
    Optional<Encomienda> findByCodigoSeguimiento(String codigoSeguimiento);

    boolean existsByCodigoSeguimiento(String codigoSeguimiento);
}
