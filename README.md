# Web Service Spring Boot
Este é um projeto de exemplo de um Web Service desenvolvido utilizando o framework Spring Boot.

## Descrição
O Web Service é uma aplicação RESTful que gerencia categorias, produtos, usuários e pedidos de uma loja online. Ele fornece endpoints para realizar operações CRUD (Criar, Ler, Atualizar e Deletar) em cada uma dessas entidades, permitindo que clientes acessem e manipulem os dados da loja.

## Tecnologias Utilizadas
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database (em memória)
- Maven

## Funcionalidades
- Categorias: CRUD de categorias de produtos.
- Produtos: CRUD de produtos, associando-os a uma ou mais categorias.
- Usuários: CRUD de usuários, que podem realizar pedidos.
- Pedidos: CRUD de pedidos, contendo informações sobre produtos, clientes e status de entrega.

## Como Executar

### Clone o repositório para sua máquina local:
git clone https://github.com/jgattringer/web-service-jpa-spring-boot.git

### Navegue até o diretório do projeto:
cd web-service-spring-boot

### Execute a aplicação usando Maven:
mvn spring-boot:run

## Acesse os endpoints através de um cliente HTTP (como Postman ou cURL) ou por meio de uma interface de usuário.

### Endpoints
- GET /categories: Retorna todas as categorias.
- GET /categories/{id}: Retorna uma categoria específica pelo ID.
- POST /categories: Cria uma nova categoria.
- PUT /categories/{id}: Atualiza uma categoria existente.
- DELETE /categories/{id}: Exclui uma categoria.
(E assim por diante para os demais endpoints de produtos, usuários e pedidos.)