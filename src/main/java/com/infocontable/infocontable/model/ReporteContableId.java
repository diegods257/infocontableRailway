package com.infocontable.infocontable.model;


import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class ReporteContableId implements Serializable {

    private String tipo_soporte;
    private String num_soporte;
    private String id_tercero;


}
