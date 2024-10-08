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
public class TelefonoPersonaId implements java.io.Serializable {
    private static final long serialVersionUID = 1032788256864531061L;
    @Column(name = "CorrelativoTelefono", nullable = false)
    private Integer correlativoTelefono;

    @Column(name = "CodigoPersona", nullable = false)
    private Integer codigoPersona;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TelefonoPersonaId entity = (TelefonoPersonaId) o;
        return Objects.equals(this.codigoPersona, entity.codigoPersona) &&
                Objects.equals(this.correlativoTelefono, entity.correlativoTelefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoPersona, correlativoTelefono);
    }

}