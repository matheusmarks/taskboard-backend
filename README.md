<h1 align="center">Taskboard</h1>
<h4 align="center">Api do taskboard</h4>


<p align="center">
  <img alt="top language" src="https://img.shields.io/github/languages/top/matheusmarks/taskboard-backend.svg" />
  <img alt="top language" src="https://img.shields.io/github/repo-size/matheusmarks/taskboard-backend.svg" />
  <img alt="last commit" src="https://img.shields.io/github/last-commit/matheusmarks/taskboard-backend.svg" />
</p>

<p align="center">
 <a href="#Tecnologias">Tecnologias</a> • 
 <a href="#usabilidade">Usabilidade</a> • 
  <a href="#licença">Licença</a> • 
</p>

<h3>Tecnologias</h3>
  <ul>
    <li>Java</li>
    <li>Spring Boot</li>
    <li>Jpa Repository</li>
    <li>Hibernate</li>
    <li>Postgres</li>
    <li>Docker</li>
  </ul>
 
 <h3>Usabilidade</h3>
 <p>Primeiramente, é necessária a instalação do Java e da jdk, logo em seguida siga os trechos de código abaixo no seu terminal: </p>
 
 ```bash
# Clonar o repositório
$ git clone https://github.com/matheusmarks/taskboard-frontend

# Ir para a pasta do projeto
$ cd taskboard-frontend

# Instalar as dependências
$ npm install ou yarn 

# Inicializar o app
$ npm dev ou yarn dev

```

<p>Será necessário criar um banco no postgres chamado 'taskboard' e depois mude <strong>spring.jpa.hibernate.ddl-auto</strong> para create no arquivo application.properties: </p>
```java
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.datasource.url= jdbc:postgresql://localhost:5432/taskboard
spring.datasource.username=(Seu username postgres)
spring.datasource.password=(Sua senha postgres)
spring.jpa.hibernate.ddl-auto=create (após a primeira execução do projeto, mude para update)
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration

```


<h3>Licença</h3>
<a href="https://github.com/matheusmarks/taskboard-frontend/blob/main/LICENSE">MIT Licence</p>
