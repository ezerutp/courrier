package pe.transporte.courrier.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El monto es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El monto debe ser mayor que 0")
    private BigDecimal monto;

    @NotNull(message = "La fecha del pago es obligatoria")
    private LocalDateTime fechaPago;

    @NotNull(message = "El tipo de pago es obligatorio")
    @Enumerated(EnumType.STRING)
    private TipoPago tipoPago;

    @NotNull(message = "El estado del pago es obligatorio")
    @Enumerated(EnumType.STRING)
    private EstadoPago estado;

    @ManyToOne
    @JoinColumn(name = "encomienda_id", nullable = false)
    private Encomienda encomienda;

    public enum TipoPago {
        EFECTIVO,
        TARJETA,
        YAPE,
        PLIN,
        TRANSFERENCIA
    }

    public enum EstadoPago {
        PENDIENTE,
        PAGADO,
        CANCELADO
    }
}
