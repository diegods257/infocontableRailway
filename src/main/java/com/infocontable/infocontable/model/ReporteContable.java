package com.infocontable.infocontable.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "reportescontables")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ReporteContable {

    @EmbeddedId
    private ReporteContableId reporteContableId = new ReporteContableId();

    @Column
    private String num_cuenta;

    @Column
    private String metodo_pago;

    @Column
    private Double valor;

    @Column
    private String descripcion;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @Column
    private String comentarios;

    @Column
    private String nombre_tercero;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_nit")
    private User user;

}
