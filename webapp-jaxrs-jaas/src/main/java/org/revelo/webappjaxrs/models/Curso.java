package org.revelo.webappjaxrs.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private Double duracion;

    //@XmlTransient
    //@JsonbTransient
    //@JsonIgnore //Me ignora la relacion y me muestra solo los campos del curso
    @ManyToOne(fetch = FetchType.LAZY)
    private Instructor instructor;


    public Curso() {
    }

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
