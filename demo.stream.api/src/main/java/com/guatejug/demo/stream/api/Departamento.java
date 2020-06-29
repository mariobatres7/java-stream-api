package com.guatejug.demo.stream.api;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author Mario Batres
 */
@Data
@EqualsAndHashCode(of = "codigo")
@ToString()
public class Departamento {

    private String codigo;

    private String nombre;
    
    private Long poblacion;
}
