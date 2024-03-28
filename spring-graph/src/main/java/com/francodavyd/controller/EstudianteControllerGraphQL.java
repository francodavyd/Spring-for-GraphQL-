package com.francodavyd.controller;

import com.francodavyd.model.Curso;
import com.francodavyd.model.Estudiante;
import com.francodavyd.model.graphql.InputEstudiante;
import com.francodavyd.service.ICursoService;
import com.francodavyd.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EstudianteControllerGraphQL {
    @Autowired
    private IEstudianteService serviceE;
    @Autowired
    private ICursoService serviceC;
    @MutationMapping(name = "createEstudiante")
    public Estudiante crear(@Argument (name = "input") InputEstudiante inputEstudiante){
        Curso curso = serviceC.obtenerPorId(Long.parseLong(inputEstudiante.getIdCurso()));
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(inputEstudiante.getNombre());
        estudiante.setApellido(inputEstudiante.getApellido());
        estudiante.setEdad(inputEstudiante.getEdad());
        estudiante.setCurso(curso);
        serviceE.crear(estudiante);
        return estudiante;
     }
    @QueryMapping(name = "findEstudianteById")
    public Estudiante obtenerPorId(@Argument(name = "estudianteId") String id){
            Long estudianteId = Long.parseLong(id);
            return serviceE.obtenerPorId(estudianteId);
    }
   @QueryMapping(name = "findAllEstudiantes")
    public List<Estudiante> obtenerLista(){
        return serviceE.obtenerLista();

   }
   @MutationMapping(name = "deleteEstudiante")
   public String eliminarEstudiante(@Argument(name = "estudianteId") String id){
        serviceE.eliminar(Long.parseLong(id));
        return "Estudiante eliminado correctamente";
   }
}
