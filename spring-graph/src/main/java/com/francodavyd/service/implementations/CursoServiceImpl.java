package com.francodavyd.service.implementations;

import com.francodavyd.model.Curso;
import com.francodavyd.repository.ICursoRepository;
import com.francodavyd.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements ICursoService {

    @Autowired
    private ICursoRepository repository;
    @Override
    public void crear(Curso curso) {
        repository.save(curso);
    }

    @Override
    public List<Curso> obtenerLista() {
        return repository.findAll();
    }

    @Override
    public Curso obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
   repository.deleteById(id);
    }
}
