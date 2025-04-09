package pe.transporte.courrier.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.transporte.courrier.entities.Usuario;
import pe.transporte.courrier.entities.Usuario.Rol;

import java.util.List;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByDni(String dni);
    List<Usuario> findAllByRol(Rol rol);
    boolean existsByEmail(String email);
}
