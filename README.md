
# Pure Energy - Projeto em Java

**Pure Energy** é uma aplicação Java desenvolvida para gerenciar cômodos e aparelhos eletrônicos em uma residência, com foco em arquitetura limpa e modular, seguindo boas práticas de desenvolvimento. Este projeto implementa funcionalidades para cadastrar, atualizar, visualizar e gerenciar cômodos e aparelhos eletrônicos de forma eficiente.

---

## Alunos RM

- **Keven Ike Pereira da Silva** - 553215  
- **Vitor Cruz dos Santos** - 553621  
- **José Ribeiro dos Santos Neto** - 553844 

## Estrutura do Projeto

O projeto é organizado em camadas, separando responsabilidades para facilitar a manutenção e evolução da aplicação.

### Camadas Principais:

1. **DTO (Data Transfer Objects)**:
   - **Requests**: Objetos para entrada de dados.
   - **Responses**: Objetos para saída de dados.
   - **Mappers**: Responsáveis por converter entre entidades e DTOs.

2. **Domain**:
   - **Model**: Representações de objetos de domínio.
   - **Exceptions**: Classes de exceção para tratamento de erros específicos.

3. **Repository**:
   - Contém as entidades e interfaces para interação com o banco de dados.

4. **Service**:
   - Contém a lógica de negócio, organizada por serviços.

5. **Ports**:
   - **In**: Interfaces que definem as operações disponíveis para os controladores.
   - **Out**: Interfaces para comunicação com repositórios e outros serviços externos.

6. **Controller**:
   - Pontos de entrada da aplicação para receber e processar requisições HTTP.

---

## Funcionalidades

- **Gerenciamento de Cômodos**:
  - Cadastrar, atualizar e consultar cômodos.

- **Gerenciamento de Aparelhos Eletrônicos**:
  - Associar aparelhos a cômodos.
  - Cadastrar, atualizar e consultar aparelhos.

- **Autenticação e Controle de Usuários**:
  - Implementação de controle de acesso a funcionalidades específicas.

---

## Tecnologias Utilizadas

- **Java 17**: Linguagem principal para desenvolvimento.
- **Spring Boot**: Framework para construção da aplicação.
- **Hibernate**: ORM para mapeamento objeto-relacional.
- **Jakarta Persistence (JPA)**: Gerenciamento de persistência de dados.
- **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
- **Swagger**: Documentação da API.
- **Lombok**: Para simplificar o código reduzindo boilerplate.

---

## Organização de Pacotes

- `adapter.http`:
  - **DTOs**: Contém os objetos de transferência de dados.
  - **Mapper**: Classes responsáveis por mapear entidades para DTOs.
  - **Controller**: Controladores responsáveis por processar requisições HTTP.

- `repository`:
  - **Entities**: Representações das tabelas do banco de dados.
  - **Mappers**: Classes para conversão entre entidade e modelo de domínio.

- `domain`:
  - **Models**: Objetos de domínio.
  - **Exceptions**: Exceções personalizadas para regras de negócio.

- `service`:
  - **Service**: Implementações das regras de negócio.

- `ports`:
  - **In**: Interfaces para entrada de dados na aplicação.
  - **Out**: Interfaces para saída de dados, como comunicação com o repositório.

---

## Configuração e Execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/pure-energy-gs/PureEnergy-GsJava
   ```
2. Acesse a pasta do projeto:
   ```bash
   cd pure-energy-java
   ```
3. Configure o ambiente:
   - Certifique-se de ter o Java 17 instalado.
   - Configure as variáveis de ambiente necessárias (ex.: banco de dados).
4. Execute a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

---

## Endpoints Principais

- **Cômodos**:
  - `POST /comodos`: Cadastrar cômodo.
  - `GET /comodos`: Listar cômodos.
  - `PUT /comodos/{id}`: Atualizar cômodo.
  - `DELETE /comodos/{id}`: Deletar cômodo.

- **Aparelhos Eletrônicos**:
  - `POST /aparelhos`: Cadastrar aparelho.
  - `GET /aparelhos`: Listar aparelhos.
  - `PUT /aparelhos/{id}`: Atualizar aparelho.
  - `DELETE /aparelhos/{id}`: Deletar aparelho.

---

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir **issues** ou enviar **pull requests** para melhorias e correções.

---

## Licença

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais informações.

---
