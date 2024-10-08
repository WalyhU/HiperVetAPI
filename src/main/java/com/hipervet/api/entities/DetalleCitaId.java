package com.hipervet.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class DetalleCitaId implements java.io.Serializable {
    private static final long serialVersionUID = -5876183805949407379L;
    @Column(name = "Correlativo", nullable = false)
    private Integer correlativo;

    @Column(name = "NumeroCita", nullable = false)
    private Integer numeroCita;

    @Column(name = "NumeroFicha", nullable = false)
    private Integer numeroFicha;

    @Column(name = "CodigoSucursal", nullable = false)
    private Short codigoSucursal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DetalleCitaId entity = (DetalleCitaId) o;
        return Objects.equals(this.numeroCita, entity.numeroCita) &&
                Objects.equals(this.numeroFicha, entity.numeroFicha) &&
                Objects.equals(this.codigoSucursal, entity.codigoSucursal) &&
                Objects.equals(this.correlativo, entity.correlativo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCita, numeroFicha, codigoSucursal, correlativo);
    }

}