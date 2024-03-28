package com.francodavyd.service;

import com.francodavyd.model.Estudiante;

import java.util.List;

public interface IEstudianteService {
    public void crear(Estudiante estudiante);
    public List<Estudiante> obtenerLista();
    public Estudiante obtenerPorId(Long id);
    public void eliminar(Long id);
}
