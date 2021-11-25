<p>
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/HelderRodriguesMendes/Challenge---API-USER">

  <a href="https://opensource.org/licenses/MIT">
    <img src="https://img.shields.io/badge/License-MIT-green.svg" alt="License MIT">
  </a>
</p>

# Challenge API USER

## Challenge by Coodesh

### Descrição Geral
Esse pequeno projeto é referente a uma API REST que importa dados a cada 24:00 horas da Random User (https://randomuser.me/documentation),
armazena os mesmos em sua própria base de dados, e permite com que esses dados importados sejam consumidos pelos seus clientes.

### Instruções Técnicas
A API está configurada para realizar as importações automaticamente sempre a partir das 23:40 hrs, para que ela faça a primeira importação apartir do momento que você desejar 
é necessário alterar esse horário de forma manual, o caminho para essa alteração é nas seguistes pastas: 
src/main/java/com.testePratico.API_User/requests/service/UserServiceRequest.java no método checkFirstImport, alterando o valor da variável hourNewImport.

#### Endpoints
* Retornar uma mensagem "REST Back-end Challenge 20201209 Running": (GET) http://localhost:8080/users
* Receber atualizações dos dados: (PUT) http://localhost:8080/users/ID
* Remover um user da base: (DELETE) http://localhost:8080/users/ID
* Obter a informação somente de um user da base de dados: (GET) http://localhost:8080/users/ID
* Listar todos os usuários da base de dados: (GET) http://localhost:8080/users/users

### Tecnologias e ferramentas utilizadas
* Spring Boot
* JPA
* Maven
* Java 8
* Lombok
* Retrofit2
* Converter-Gson
* Postgresql
* Intellij
* pgAdmin 4



