package com.guatejug.demo.stream.api;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Mario Batres
 */
@Getter
@Setter
@EqualsAndHashCode(of = "nombre")
@ToString
public class Region {

    private String nombre;

    private List<Departamento> departamentoList;

    public Region() {
    }

    public Region(String nombre) {
        this.nombre = nombre;
    }

}
