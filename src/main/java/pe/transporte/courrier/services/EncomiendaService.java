package pe.transporte.courrier.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.transporte.courrier.entities.Encomienda;
import pe.transporte.courrier.repositories.EncomiendaRepository;

@Service
@Transactional
public class EncomiendaService {

    private final EncomiendaRepository encomiendaRepository;

    public EncomiendaService(EncomiendaRepository encomiendaRepository) {
        this.encomiendaRepository = encomiendaRepository;
    }

    // Crear o guardar encomienda
    public Encomienda guardar(Encomienda encomienda) {
        return encomiendaRepository.save(encomienda);
    }

    // Obtener todas las encomiendas
    public List<Encomienda> listarTodos() {
        return encomiendaRepository.findAll();
    }

    // Listar encomiendas por id del cliente (Usuario o ClienteTemporal)
    public List<Encomienda> listarPorClienteId(Long id) {
        try {
            List<Encomienda> listaFormal = encomiendaRepository.findByClienteRemitenteId(id);
            List<Encomienda> listaTemporal = encomiendaRepository.findByRemitenteTemporalId(id);
            List<Encomienda> resultado = new ArrayList<>();
            resultado.addAll(listaFormal);
            resultado.addAll(listaTemporal);
            return resultado;
        } catch (Exception e) {
            System.err.println("Error al listar encomiendas: " + e.getMessage());
            throw new RuntimeException("Error al listar encomiendas por cliente");
        }
    }

    // Listar encomiendas por dni del cliente (Usuario o ClienteTemporal)
    public List<Encomienda> ListarPorClienteDni(String dni) {
        try {
            List<Encomienda> listaFormal = encomiendaRepository.findByClienteRemitenteDni(dni);
            List<Encomienda> listaTemporal = encomiendaRepository.findByRemitenteTemporalDni(dni);
            List<Encomienda> resultado = new ArrayList<>();
            resultado.addAll(listaFormal);
            resultado.addAll(listaTemporal);
            return resultado;
        } catch (Exception e) {
            System.err.println("Error al listar encomiendas: " + e.getMessage());
            throw new RuntimeException("Error al listar encomiendas por cliente");
        }
    }

    // Listar encomiendas por id del cliente destinatario (Usuario o ClienteTemporal)
    public List<Encomienda> listarPorDestinatarioId(Long id) {
        try {
            List<Encomienda> listaFormal = encomiendaRepository.findByClienteDestinatarioId(id);
            List<Encomienda> listaTemporal = encomiendaRepository.findByDestinatarioTemporalId(id);
            List<Encomienda> resultado = new ArrayList<>();
            resultado.addAll(listaFormal);
            resultado.addAll(listaTemporal);
            return resultado;
        } catch (Exception e) {
            System.err.println("Error al listar encomiendas: " + e.getMessage());
            throw new RuntimeException("Error al listar encomiendas por cliente");
        }
    }

    // Listar encomiendas por dni del cliente destinatario (Usuario o ClienteTemporal)
    public List<Encomienda> ListarPorDestinatarioDni(String dni) {
        try {
            List<Encomienda> listaFormal = encomiendaRepository.findByClienteDestinatarioDni(dni);
            List<Encomienda> listaTemporal = encomiendaRepository.findByDestinatarioTemporalDni(dni);
            List<Encomienda> resultado = new ArrayList<>();
            resultado.addAll(listaFormal);
            resultado.addAll(listaTemporal);
            return resultado;
        } catch (Exception e) {
            System.err.println("Error al listar encomiendas: " + e.getMessage());
            throw new RuntimeException("Error al listar encomiendas por cliente");
        }
    }

    // Listar encomiendas por estado
    public List<Encomienda> ListarPorEstado(Encomienda.Estado estado) {
        return encomiendaRepository.findByEstado(estado);
    }

    // Buscar encomienda por codigo de seguimiento
    public Optional<Encomienda> buscarPorCodigoSeguimient(String codigoSeguimiento) {
        return encomiendaRepository.findByCodigoSeguimiento(codigoSeguimiento);
    }

    // Buscar encomienda por id
    public Encomienda buscarPorId(Long id) {
        return encomiendaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Encomienda no encontrado con el ID: " + id));
    }

    public boolean existeCodigoSeguimiento(String codigoSeguimiento){
        return encomiendaRepository.eexistsByCodigoSeguimiento(codigoSeguimiento);
    }

    // Actualizar estado
    public void actualizarEstado(Long id, Encomienda.Estado nuevoEstado) {
        Encomienda encomienda = buscarPorId(id);
        encomienda.setEstado(nuevoEstado);
        guardar(encomienda);
    }

    // Eliminar encomienda por id
    public void eliminar(Long id) {
        if (!encomiendaRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe una encomienda con el ID: " + id);
        }
        encomiendaRepository.deleteById(id);
    }

    //
}
