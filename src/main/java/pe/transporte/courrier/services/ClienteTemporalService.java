package pe.transporte.courrier.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.transporte.courrier.entities.ClienteTemporal;
import pe.transporte.courrier.repositories.ClienteTemporalRepository;
import pe.transporte.courrier.repositories.UsuarioRepository;

@Service
@Transactional
public class ClienteTemporalService {

    private final UsuarioRepository usuarioRepository;

    private final ClienteTemporalRepository clienteTemporalRepository;

    public ClienteTemporalService(ClienteTemporalRepository clienteTemporalRepository, UsuarioRepository usuarioRepository) {
        this.clienteTemporalRepository = clienteTemporalRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // Crear o guardar cliente temporal
    public ClienteTemporal guardar(ClienteTemporal clienteTemporal){
        return clienteTemporalRepository.save(clienteTemporal);
    }

    // Listar todos los clientes temporales
    public List<ClienteTemporal> listarTodos() {
        return clienteTemporalRepository.findAll();
    }

    // Buscar por id
    public ClienteTemporal buscarPorId(Long id) {
        return clienteTemporalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente temporal no encontrado con el ID: " + id));
    }

    // Buscar por dni
    public Optional<ClienteTemporal> buscarPorDni(String dni) {
        return clienteTemporalRepository.findByDni(dni);
    }

    // Eliminar por id
    public void eliminar(Long id) {
        if(!usuarioRepository.existsById(id)){
            throw new IllegalArgumentException("No existe el cliente con ese ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }

}
