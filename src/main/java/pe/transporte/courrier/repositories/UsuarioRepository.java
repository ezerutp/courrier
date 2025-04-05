package pe.transporte.courrier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.transporte.courrier.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
