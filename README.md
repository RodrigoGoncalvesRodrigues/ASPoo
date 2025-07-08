🧾 API de Produtos e Categorias
Esta é uma API REST desenvolvida em Java + Spring Boot, com foco na gestão de produtos e suas respectivas categorias.

📦 Entidades
🗂️ Categoria
Representa o agrupamento de produtos.

Campo	Tipo	Descrição
id	Long	Identificador único da categoria
nomeCategoria	String	Nome da categoria
produtos	List<Produto>	Lista de produtos associados

🛒 Produto
Representa um item que será vendido.

Campo	Tipo	Descrição
id	Long	Identificador único do produto
nomeProduto	String	Nome do produto
precoProduto	int	Preço do produto
categoria	Categoria	Categoria à qual o produto pertence (@ManyToOne)

🌐 Endpoints Disponíveis
📁 Categoria (/categorias)
Método	Rota	Descrição
GET	/	Retorna uma lista paginada de todas as categorias e seus produtos.
GET	/{id}	Retorna uma categoria específica pelo seu ID.
POST	/	Cria uma nova categoria. Requer nomeCategoria no corpo da requisição.
PUT	/{id}	Atualiza os dados de uma categoria existente pelo ID.
DELETE	/{id}	Remove uma categoria do sistema com base no ID.

🧾 Observações
A API retorna objetos do tipo DTO (Data Transfer Object) para evitar ciclos infinitos e garantir segurança nos dados expostos.

Todas as operações seguem os padrões REST, com retornos em JSON.
