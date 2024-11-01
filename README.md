# Sistema de Gerenciamento de Produtos

Este projeto é uma aplicação Java que implementa um sistema de gerenciamento de produtos com operações básicas de CRUD (Create, Read, Update, Delete). A aplicação utiliza o padrão de projeto Singleton para gerenciar o serviço de produtos e emprega o Mockito para testes unitários.

## Tecnologias Utilizadas

- **Java SE 11**
- **Maven**
- **JUnit 4**
- **Mockito 3.6**

## Estrutura do Projeto

O projeto é composto pelas seguintes classes:

1. **Produto**: Representa um produto com atributos `id`, `nome` e `preco`.
2. **ProdutoService**: Classe de serviço que gerencia a lógica de negócios para produtos. Implementada como um Singleton.
3. **ProdutoRepository**: Interface que define operações básicas de CRUD para produtos.
4. **ProdutoRepositoryImpl**: Implementação da interface `ProdutoRepository`, armazenando produtos em uma lista.
5. **ProdutoServiceTest**: Classe de testes unitários que valida a funcionalidade do `ProdutoService` utilizando Mockito.

## Funcionalidades

- **Adicionar Produto**: Permite adicionar um novo produto.
- **Buscar Produto por ID**: Retorna um produto com base no seu ID.
- **Atualizar Produto**: Atualiza o nome e preço de um produto existente.
- **Deletar Produto**: Remove um produto com base no ID.
- **Listar Produtos**: Lista todos os produtos cadastrados.

## Configuração do Ambiente

1. **Clone o Repositório**:
   git clone https://github.com/seu_usuario/nome_do_repositorio.git
   cd nome_do_repositorio

2. **Adicione as Dependências**:

  Baixe os JARs do Mockito e JUnit e coloque-os na pasta lib do projeto.
  No IntelliJ, adicione os JARs ao seu projeto:
  Vá para File > Project Structure > Modules > Dependencies.
  Clique no + e selecione JARs or directories.
  Selecione os JARs do Mockito e JUnit.
  Executar a Aplicação:

3. **Compile e execute a classe MainApp para interagir com o sistema de gerenciamento de produtos.**

4. **Executar os Testes**:

  Execute os testes unitários da classe ProdutoServiceTest para garantir que todas as funcionalidades estão funcionando como esperado.
