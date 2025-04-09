package pe.transporte.courrier.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.transporte.courrier.entities.Usuario;
import pe.transporte.courrier.entities.Usuario.Rol;
import pe.transporte.courrier.repositories.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Crear o guardar usuario
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Obtener todos los usuarios
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Obtener solo los clientes
    public List<Usuario> listarPorRol(Rol rol){
        return usuarioRepository.findAllByRol(rol);
    }

    // Buscar por ID
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + id));
    }

    // Buscar por Email
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    // Buscar por Dni
    public Optional<Usuario> buscarPorDni(String dni){
        return usuarioRepository.findByDni(dni);
    }

    // Eliminar por ID
    public void eliminar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe un usuario con ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    // Verificar si el email ya existe
    public boolean emailExiste(String email) {
        return usuarioRepository.existsByEmail(email);
    }
}
