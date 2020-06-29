package com.guatejug.demo.stream.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Mario Batres
 */
@Getter
@Setter
@ToString()
public class DataWrapper {

    @JsonProperty("region")
    private String region;

    @JsonProperty("departamento_codigo")
    private String departamento_codigo;

    @JsonProperty("departamento")
    private String departamento;

    @JsonProperty("municipio_codigo")
    private String municipio_codigo;

    @JsonProperty("municipio")
    private String municipio;

    @JsonProperty("poblacion")
    private Long poblacion;

}
