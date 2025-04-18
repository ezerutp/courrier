package pe.transporte.courrier.services;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.transporte.courrier.entities.Pago;
import pe.transporte.courrier.repositories.PagoRepository;

@Service
@Transactional
public class PagoService {
    
    private final PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository){
        this.pagoRepository = pagoRepository;
    }

    // Crear o guardar un pago
    public Pago guardar(Pago pago){
        return pagoRepository.save(pago);
    }

    // Listar todos los pagos
    public List<Pago> listarTodos(){
        return pagoRepository.findAll();
    }

    // Listar por tipo de pago
    public List<Pago> listarPorTipoPago(Pago.TipoPago tipo){
        return pagoRepository.findByTipoPago(tipo);
    }

    // Listar por estado
    public List<Pago> listarPorEstadoPago(Pago.EstadoPago estado){
        return pagoRepository.findByEstado(estado);
    }

    // Buscar por id del pago
    public Pago buscarPorId(Long id){
        return pagoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se encontró un pago con ID: " + id));
    }

    // Eliminar por id del pago
    public void eliminar(Long id){
        if(!pagoRepository.existsById(id)){
            throw new IllegalArgumentException("No existe un pago con ID: " + id);
        }
        pagoRepository.deleteById(id);;
    }
}
