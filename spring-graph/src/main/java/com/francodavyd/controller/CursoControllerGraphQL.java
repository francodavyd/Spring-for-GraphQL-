package com.francodavyd.controller;

import com.francodavyd.model.Curso;
import com.francodavyd.model.graphql.InputCurso;
import com.francodavyd.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CursoControllerGraphQL {
@Autowired
    private ICursoService service;

    @MutationMapping(name = "createCurso")
    public Curso crear(@Argument(name = "input")InputCurso inputCurso){
        Curso curso = new Curso();
       curso.setNombre(inputCurso.getNombre());
       curso.setCategoria(inputCurso.getCategoria());
       curso.setProfesor(inputCurso.getProfesor());

       service.crear(curso);
       return curso;

    }

    @QueryMapping(name = "findCursoById")
    public Curso obtenerPorId(@Argument(name = "cursoId") String id){
        Long cursoId = Long.parseLong(id);
        return service.obtenerPorId(cursoId);
    }
    @QueryMapping(name = "findAllCursos")
    public List<Curso> obtenerLista(){
        return service.obtenerLista();

    }
    @MutationMapping(name = "deleteCurso")
    public String eliminarCurso(@Argument(name = "cursoId") String id){
        service.eliminar(Long.parseLong(id));
        return "Curso eliminado correctamente";
    }
}
