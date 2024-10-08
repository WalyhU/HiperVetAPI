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
public class TelefonoSucursalId implements java.io.Serializable {
    private static final long serialVersionUID = -2267750930939119430L;
    @Column(name = "CorrelativoTelefono", nullable = false)
    private Integer correlativoTelefono;

    @Column(name = "CodigoSucursal", nullable = false)
    private Short codigoSucursal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TelefonoSucursalId entity = (TelefonoSucursalId) o;
        return Objects.equals(this.codigoSucursal, entity.codigoSucursal) &&
                Objects.equals(this.correlativoTelefono, entity.correlativoTelefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoSucursal, correlativoTelefono);
    }

}