package pe.transporte.courrier.services;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import pe.transporte.courrier.entities.Sucursal;
import pe.transporte.courrier.repositories.SucursalRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class SucursalService {
    
    private final SucursalRepository sucursalRepository;

    // Crear o guardar una sucursal
    public Sucursal guardar(Sucursal sucursal){
        return sucursalRepository.save(sucursal);
    }

    // Listar todas las sucursales
    public List<Sucursal> listarTodos(){
        return sucursalRepository.findAll();
    }

    // Buscar por id de un sucursal
    public Sucursal buscarPorId(Long id){
        return sucursalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se encontro una sucursal con ID: " + id));
    }

    // Eliminar una sucursal por id
    public void eliminar(Long id){
        if(!sucursalRepository.existsById(id)){
            throw new IllegalArgumentException("No existe una sucursal con el Id: " + id);
        }
        sucursalRepository.deleteById(id);
    }
}
