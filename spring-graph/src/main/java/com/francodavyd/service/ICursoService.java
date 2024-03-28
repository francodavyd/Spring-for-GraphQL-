package com.francodavyd.service;

import com.francodavyd.model.Curso;

import java.util.List;

public interface ICursoService {
    public void crear(Curso curso);
    public List<Curso> obtenerLista();
    public Curso obtenerPorId(Long id);
    public void eliminar(Long id);
}
