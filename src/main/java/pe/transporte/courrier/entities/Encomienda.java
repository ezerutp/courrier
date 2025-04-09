package pe.transporte.courrier.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "encomiendas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Encomienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @DecimalMin(value = "0.1", message = "El peso debe ser mayor a 0")
    private double peso;

    @NotBlank(message = "Las dimensiones son obligatorias")
    private String dimensiones; // Ejemplo: "30x20x15 cm"

    @NotNull
    @Enumerated(EnumType.STRING)
    private Estado estado;

    private LocalDateTime fechaEnvio;
    private LocalDateTime fechaEntrega;

    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que 0")
    private double precio;

    // Relaciones

    // Remitente formal
    @ManyToOne
    @JoinColumn(name = "cliente_remitente_id")
    private Usuario clienteRemitente;

    // Remitente temporal
    @ManyToOne
    @JoinColumn(name = "remitente_temporal_id")
    private ClienteTemporal remitenteTemporal;

    // Destinatario formal
    @ManyToOne
    @JoinColumn(name = "cliente_destinatario_id")
    private Usuario clienteDestinatario;

    // Destinatario temporal
    @ManyToOne
    @JoinColumn(name = "destinatario_temporal_id")
    private ClienteTemporal destinatarioTemporal;

    @ManyToOne
    @JoinColumn(name = "sucursal_origen_id")
    private Sucursal sucursalOrigen;

    @ManyToOne
    @JoinColumn(name = "sucursal_destino_id")
    private Sucursal sucursalDestino;

    // Seguimiento
    @Column(unique = true, nullable = false)
    private String codigoSeguimiento;

    public enum Estado {
        PENDIENTE,
        EN_CAMINO,
        ENTREGADO,
        CANCELADO
    }
}
