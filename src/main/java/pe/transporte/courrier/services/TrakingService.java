package pe.transporte.courrier.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import pe.transporte.courrier.entities.Encomienda;
import pe.transporte.courrier.entities.Sucursal;
import pe.transporte.courrier.entities.Tracking;
import pe.transporte.courrier.entities.Tracking.EstadoTracking;
import pe.transporte.courrier.repositories.TrakingRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class TrakingService {

    private final TrakingRepository trackingRepository;

    // Registrar un nuevo tracking
    public Tracking guardar(Tracking tracking) {
        return trackingRepository.save(tracking);
    }

    // Registrar tracking con datos específicos (opcional)
    public Tracking registrarTracking(Encomienda encomienda, EstadoTracking estado, String observaciones, Sucursal sucursal, Double latitud, Double longitud) {
        Tracking tracking = Tracking.builder()
            .encomienda(encomienda)
            .estado(estado)
            .observaciones(observaciones)
            .sucursal(sucursal)
            .latitud(latitud)
            .longitud(longitud)
            .fechaHora(LocalDateTime.now())
            .build();
        return guardar(tracking);
    }

    // Listar todos los trackings
    public List<Tracking> listarTodos() {
        return trackingRepository.findAll();
    }

    // Buscar por id de un tracking
    public Tracking buscarPorId(Long id) {
        return trackingRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("No se encontró un tracking con ID: " + id));
    }

    // Eliminar un tracking por id
    public void eliminar(Long id) {
        if (!trackingRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe un tracking con el ID: " + id);
        }
        trackingRepository.deleteById(id);
    }

    // Obtener historial por encomienda
    public List<Tracking> historialPorEncomienda(Long encomiendaId) {
        return trackingRepository.findByEncomiendaIdOrderByFechaHoraAsc(encomiendaId);
    }

    // Obtener último tracking de una encomienda
    public Tracking ultimoTracking(Long encomiendaId) {
        return trackingRepository.findTopByEncomiendaIdOrderByFechaHoraDesc(encomiendaId)
            .orElseThrow(() -> new IllegalArgumentException("No hay registros de tracking para la encomienda ID: " + encomiendaId));
    }
}
