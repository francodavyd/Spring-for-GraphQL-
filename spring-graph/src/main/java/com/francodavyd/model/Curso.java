package com.francodavyd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;
    private String profesor;
    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, targetEntity = Estudiante.class)
    private List<Estudiante> list;
}
