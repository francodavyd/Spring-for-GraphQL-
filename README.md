# SpringForGraphQL
En este proyecto he aprendido a integrar GraphQL con Spring Boot. Para probar esta aplicación debes crear
una base de datos llamada "spring_graph", luego ejecutarla e ir a localhost:8080/graphiql para poder realizar tus consultas, tambien allí
se encontrara la documentación de los endpoints en la esquina superior izquierda de la página.
Por ejemplo, para realizar una Mutation que cree un Estudiante, sería:

mutation{ <br>
  createEstudiante(input: { <br>
    nombre:"Franco", <br>
    apellido:"Sanchez", <br>
    edad: 21, <br>
    idCurso: "1" <br>
  }){ <br>
    nombre, <br>
    apellido, <br>
    curso{ <br>
      nombre, <br>
      categoria <br>
    }   <br>
  } <br>
} <br>

Y para realizar una Query que obtenga todos los estudiantes, sería: <br>
<br>
query{ <br>
  findAllEstudiantes{ <br>
    nombre <br>
    apellido <br>
  } <br>
} <br>
