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
public class CitaId implements java.io.Serializable {
    private static final long serialVersionUID = 6388928791140233125L;
    @Column(name = "numero_cita", nullable = false)
    private Integer numeroCita;

    @Column(name = "codigo_sucursal", nullable = false)
    private Short codigoSucursal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CitaId entity = (CitaId) o;
        return Objects.equals(this.numeroCita, entity.numeroCita) &&
                Objects.equals(this.codigoSucursal, entity.codigoSucursal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCita, codigoSucursal);
    }

}