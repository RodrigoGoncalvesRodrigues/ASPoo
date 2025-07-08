# 📦 API de Produtos e Categorias

Esta é uma **API REST** desenvolvida em **Java com Spring Boot** para gerenciar produtos e suas respectivas categorias.

---

## 🧩 Entidades

### 📁 Categoria

A entidade **Categoria** agrupa os produtos. Possui os seguintes campos:

- `id`: Identificador único da categoria (`Long`)
- `nomeCategoria`: Nome da categoria (`String`)
- `produtos`: Lista de produtos associados (`List<Produto>`)

---

### 📦 Produto

A entidade **Produto** representa os itens vendidos. Possui os seguintes campos:

- `id`: Identificador único do produto (`Long`)
- `nomeProduto`: Nome do produto (`String`)
- `precoProduto`: Preço do produto (`int`)
- `categoria`: Categoria à qual o produto pertence (`@ManyToOne` com `Categoria`)

---

## 🌐 Endpoints

### 🔹 Categoria: `/categorias`

| Método | Endpoint     | Descrição                                                                 |
|--------|--------------|---------------------------------------------------------------------------|
| GET    | `/`          | Retorna uma lista **paginada** de categorias e seus produtos              |
| GET    | `/{id}`      | Retorna uma **categoria específica** pelo ID                              |
| POST   | `/`          | Cria uma nova categoria (`nomeCategoria`)                                 |
| PUT    | `/{id}`      | Atualiza uma categoria existente                                           |
| DELETE | `/{id}`      | Exclui uma categoria pelo ID                                               |

---

### 🔹 Produto: `/produtos`

| Método | Endpoint     | Descrição                                                                 |
|--------|--------------|---------------------------------------------------------------------------|
| GET    | `/`          | Retorna todos os produtos com suas respectivas categorias (`DTO`)         |
| GET    | `/{id}`      | Retorna um produto específico pelo ID                                     |
| POST   | `/`          | Cria um novo produto (`nomeProduto`, `precoProduto`, `categoriaId`)       |
| PUT    | `/{id}`      | Atualiza um produto existente                                             |
| DELETE | `/{id}`      | Exclui um produto pelo ID                                                 |

---

## 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL (Aurora)
- Maven ou Gradle
- RESTful API
- AWS (EC2, Aurora)
- pgAdmin
