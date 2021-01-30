# Gerenciador de salas de reunioes

![Foo](https://raw.githubusercontent.com/matheusosp/blog_Django-React/main/Lista%20de%20tarefas%20-%20Google%20Chrome.jpg)

## TO RUN LOCALLY
```
git clone git@github.com:matheusosp/Gerenciador-de-salas-de-reunioes-Java-Angular.git
cd java
mvn spring-boot:run
cd ..
cd angular
npm install
ng serve -o
```
## Stack utilizada:


 * Spring Web
 * Spring Data JPA
 * H2 Database
 * Java 8
 * Maven
 * 
 
## Endpoints criados na API

* Criar sala de reuniao
POST - /api/v1/room

* Listar todas as salas
GET - /api/v1/rooms

* Buscar uma sala pelo Id
GET - /api/v1/room/{id}

* Atualizar uma sala pelo Id
PUT - /api/v1/room/{id}

* Excluir uma sala pelo id
DELETE - /api/v1/room/{Id}

