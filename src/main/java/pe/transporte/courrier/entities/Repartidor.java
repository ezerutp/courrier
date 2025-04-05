package pe.transporte.courrier.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "repartidores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Repartidor extends Usuario{
  
    @NotBlank(message = "La placa del vehículo es obligatoria")
    @Column(length = 10)
    private String placaVehiculo;

    @NotBlank(message = "El tipo de vehículo es obligatorio")
    private String tipoVehiculo; 
    
    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado del repartidor es obligatorio")
    private Estado estado;

    public enum Estado {
        DISPONIBLE,
        EN_REPARTO,
        INACTIVO
    }

}
