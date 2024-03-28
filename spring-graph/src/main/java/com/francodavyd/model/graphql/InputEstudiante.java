package com.francodavyd.model.graphql;

import lombok.Data;

@Data
public class InputEstudiante {
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
    private String idCurso;
}
