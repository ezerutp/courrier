package pe.transporte.courrier.services;

import java.util.List;

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
    public Encomienda guardar(Encomienda encomienda){
        return encomiendaRepository.save(encomienda);
    }

    // Obtener todas las encomiendas
    public List<Encomienda> listarTodos(){
        return encomiendaRepository.findAll();
    }

    // Listar encomiendas por cliente remitente formal


    // Buscar encomienda por id
    public Encomienda buscarPorId(Long id){
        return encomiendaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Encomienda no encontrado con el ID: " + id));
    }

    // Eliminar encomienda por id
    public void eliminar(Long id){
        if(!encomiendaRepository.existsById(id)){
            throw new IllegalArgumentException("No existe una encomienda con el ID: " + id);
        }
        encomiendaRepository.deleteById(id);
    }

    // 
}
