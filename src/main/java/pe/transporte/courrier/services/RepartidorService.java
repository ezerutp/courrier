package pe.transporte.courrier.services;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.transporte.courrier.entities.Repartidor;
import pe.transporte.courrier.repositories.RepartidorRepository;

@Service
@Transactional
public class RepartidorService {
    
    private final RepartidorRepository repartidorRepository;

    public RepartidorService(RepartidorRepository repartidorRepository){
        this.repartidorRepository = repartidorRepository;
    }

    // Crear o guardar un repartidor
    public Repartidor guardar(Repartidor repartidor){
        return repartidorRepository.save(repartidor);
    }

    // Listar todos los repartidores
    public List<Repartidor> listarTodos(){
        return repartidorRepository.findAll();
    }

    // Listar todos los repartidores por Estado
    public List<Repartidor> listarTodosPorEstado(Repartidor.Estado estado){
        return repartidorRepository.findByEstado(estado);
    }

    // Buscar por id de pago
    public Repartidor buscarPorId(Long id){
        return repartidorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se encontró un repartidor con ID: " + id));
    }

    // Eliminar un repartidor
    public void eliminar(Long id){
        if(!repartidorRepository.existsById(id)){
            throw new IllegalArgumentException("No existe un repartidor con ID: " + id);
        }
        repartidorRepository.deleteById(id);
    }
    
    // Buscar por placa de vehiculo
    public Repartidor buscarPorPlacaVehiculo(String placaVehiculo){
        return repartidorRepository.findByPlacaVehiculo(placaVehiculo).orElseThrow(() -> new IllegalArgumentException("No se encontró un repartidor con esta placa de vehiculo: ." + placaVehiculo));
    }


}
