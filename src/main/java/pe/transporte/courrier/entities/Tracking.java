package pe.transporte.courrier.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "trackings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime fechaHora;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado es obligatorio")
    private EstadoTracking estado;

    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "encomienda_id", nullable = false)
    private Encomienda encomienda;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;

    //Ubicación GPS
    private Double latitud;
    private Double longitud;

    public enum EstadoTracking {
        REGISTRADO,
        LLEGADA_ORIGEN,
        ACEPTADO,
        EMPAQUETADO,
        EMBARCADO,
        TRANSPORTANDO,
        LLEGADA_DESTINO,
        ENTREGADO
    }
}