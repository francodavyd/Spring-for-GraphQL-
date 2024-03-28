# SpringForGraphQL
En este proyecto he aprendido a integrar GraphQL con Spring Boot. Para probar esta aplicación debes crear
una base de datos llamada "spring_graph", luego ejecutarla e ir a localhost:8080/graphiql para poder realizar tus consultas, tambien allí
se encontrara la documentación de los endpoints en la esquina superior izquierda de la página.
Por ejemplo, para realizar una Mutation que cree un Estudiante, sería:

mutation{
  createEstudiante(input: {
    nombre:"Franco",
    apellido:"Sanchez",
    edad: 21,
    idCurso: "1"
  }){
    nombre,
    apellido,
    curso{
      nombre,
      categoria
    }   
  }
}

Y para realizar una Query que obtenga todos los estudiantes, sería:

query{
  findAllEstudiantes{
    nombre
    apellido
  }
}
