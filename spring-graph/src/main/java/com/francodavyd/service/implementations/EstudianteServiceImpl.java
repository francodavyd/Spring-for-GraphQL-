package com.francodavyd.service.implementations;

import com.francodavyd.model.Estudiante;
import com.francodavyd.repository.IEstudianteRepository;
import com.francodavyd.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements IEstudianteService {
    @Autowired
    private IEstudianteRepository repository;
    @Override
    public void crear(Estudiante estudiante) {
         repository.save(estudiante);
    }

    @Override
    public List<Estudiante> obtenerLista() {
        return repository.findAll();
    }

    @Override
    public Estudiante obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
