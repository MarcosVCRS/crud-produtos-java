# CRUD de Produtos

Projeto simples de CRUD em Java, feito para praticar fundamentos antes de estudar Spring.

O sistema roda no terminal e permite:

- cadastrar produtos;
- listar todos os produtos;
- buscar produto por ID;
- atualizar preco;
- deletar produto.

## Tecnologias

- Java
- Maven
- Programacao orientada a objetos
- ArrayList para armazenar os dados em memoria
- Exceptions personalizadas

## Estrutura

```text
src/main/java/br/com/vinipaes
  Main.java
  model/Product.java
  repository/ProductRepository.java
  service/ProductService.java
  exception/ProductInvalidException.java
  exception/ProductNotFoundException.java
```

## Como executar

Na pasta do projeto, rode:

```bash
mvn test
```

Depois execute:

```bash
java -cp target/classes br.com.vinipaes.Main
```

## Objetivo do projeto

Este projeto foi criado como primeiro CRUD em Java, com foco em entender separacao de responsabilidades:

- `model`: representa os dados do produto;
- `repository`: guarda e busca os produtos;
- `service`: concentra as regras de negocio;
- `exception`: representa erros especificos do sistema;
- `Main`: exibe o menu e interage com o usuario.
