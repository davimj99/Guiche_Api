# 🎫 Guichê API

API REST desenvolvida com **Java e Spring Boot** para evoluir o backend de um sistema de gerenciamento de guichês, filas e atendimentos, inicialmente desenvolvido em Django.

O objetivo é construir uma API organizada, segura e escalável, com separação de responsabilidades, persistência em PostgreSQL, autenticação baseada em JWT e documentação interativa dos endpoints.

> 🚧 **Status:** em desenvolvimento. A estrutura da API, a integração com o banco de dados, a autenticação JWT e a documentação Swagger estão implementadas. Os demais módulos e integrações seguem em evolução.

## 🚀 Tecnologias

| Tecnologia | Finalidade |
|---|---|
| Java 26 | Linguagem de programação |
| Spring Boot 4.1.1 | Framework principal |
| Spring Web MVC | Construção dos endpoints REST |
| Spring Data JPA | Persistência e acesso a dados |
| Hibernate | Mapeamento objeto-relacional (ORM) |
| PostgreSQL 18 | Banco de dados relacional |
| Spring Security | Segurança e autenticação |
| JWT / HS256 | Geração e validação de tokens |
| SpringDoc OpenAPI | Documentação da API |
| Swagger UI | Testes interativos dos endpoints |
| Maven | Gerenciamento de dependências e build |
| GitHub Actions | Integração contínua (CI) |

## 📦 Funcionalidades

### ✅ Implementado

- [x] Estrutura inicial do projeto Spring Boot.
- [x] Organização da aplicação em camadas.
- [x] Conexão com PostgreSQL.
- [x] Configuração do Spring Data JPA e Hibernate.
- [x] Entidade `Guiche` e repositório correspondente.
- [x] Endpoint para listagem de guichês.
- [x] Autenticação de usuários com `AuthenticationManager`.
- [x] Geração e validação de tokens JWT.
- [x] Proteção de endpoints com Spring Security.
- [x] Endpoint `POST /auth/login`.
- [x] Endpoint `GET /auth/me` para consultar o usuário autenticado.
- [x] Documentação interativa com Swagger/OpenAPI.
- [x] Configuração de pipeline CI com GitHub Actions.

### 🚧 Em desenvolvimento / próximos passos

- [ ] Completar o CRUD de guichês.
- [ ] Implementar e completar as operações de filas.
- [ ] Implementar e completar as operações de atendimentos.
- [ ] Ampliar as validações de entrada.
- [ ] Expandir os testes automatizados.
- [ ] Evoluir as regras de negócio e o tratamento de exceções.
- [ ] Integrar a API ao sistema Django existente.
- [ ] Configurar Docker e fluxo de deploy automatizado (CD).

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas, com o objetivo de separar as responsabilidades e facilitar a manutenção.

```text
src/
├── main/
│   ├── java/br/com/davi/guiche_api/
│   │   ├── config/        # Configurações da aplicação
│   │   ├── controller/    # Endpoints REST
│   │   ├── dto/           # Objetos de transferência de dados
│   │   │   ├── auth/
│   │   │   ├── fila/
│   │   │   ├── guiche/
│   │   │   └── atendimento/
│   │   ├── entity/        # Entidades persistidas
│   │   ├── exception/     # Exceções e tratamento de erros
│   │   ├── repository/    # Acesso a dados
│   │   └── service/       # Regras de negócio
│   └── resources/
│       └── application.properties
└── test/                  # Testes automatizados
```

**Responsabilidades das camadas:**

- **Controller:** recebe as requisições HTTP e retorna as respostas da API.
- **Service:** concentra as regras de negócio.
- **Repository:** realiza operações de persistência por meio do Spring Data JPA.
- **Entity:** representa os dados persistidos no banco.
- **DTO:** define os dados de entrada e saída dos endpoints.
- **Config:** centraliza configurações de segurança e documentação.
- **Exception:** organiza o tratamento e a padronização de erros.

## 🔐 Autenticação e segurança

A API utiliza Spring Security com autenticação baseada em JSON Web Token (JWT).

### Fluxo de autenticação

1. O cliente envia suas credenciais para `POST /auth/login`.
2. O `AuthenticationManager` valida as credenciais.
3. Após a autenticação, a API gera um JWT assinado com HS256.
4. O token inclui informações como emissor, usuário, emissão, expiração e permissões.
5. O cliente envia o token nas requisições protegidas por meio do cabeçalho `Authorization`.
6. O Spring Security valida o token antes de permitir o acesso ao recurso.

Exemplo de cabeçalho:

```http
Authorization: Bearer <seu_token_jwt>
```

O endpoint `GET /auth/me` permite consultar o nome de usuário e as roles presentes no token autenticado.

**Boas práticas adotadas:**

- Sessões configuradas como stateless.
- Chave JWT e credenciais fornecidas por configuração externa.
- Endpoints protegidos por autenticação.
- Documentação Swagger preparada para testar chamadas autenticadas.

## 📚 Documentação da API

A documentação interativa é disponibilizada por meio do SpringDoc OpenAPI e Swagger UI.

Com a aplicação em execução local, acesse:

- **Swagger UI:** [http://localhost:8080/doc](http://localhost:8080/doc)
- **OpenAPI JSON:** [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

No Swagger, é possível consultar os endpoints, visualizar os parâmetros e executar requisições. Para testar rotas protegidas, faça login, copie o token retornado e utilize a opção **Authorize** para informar o JWT.

## ⚙️ Integração contínua (CI)

O projeto possui um workflow no GitHub Actions para automatizar a validação do código.

O pipeline está configurado para:

- Executar em pushes nas branches `main`, `feature/**` e `release/**`.
- Executar em pull requests direcionados à `main`.
- Configurar o Java 26 com a distribuição Temurin.
- Utilizar cache de dependências Maven.
- Inicializar PostgreSQL 16 como service container para os testes.
- Executar os testes automatizados com `./mvnw test`.
- Gerar o pacote da aplicação com `./mvnw clean package`.
- Utilizar `ddl-auto: create-drop` no ambiente de testes, quando configurado, para criar e remover o schema de teste.

O uso de variáveis de ambiente permite configurar o banco de dados e outros parâmetros sem precisar alterar os arquivos versionados.

## 🗄️ Banco de dados

A aplicação utiliza PostgreSQL como banco relacional e Spring Data JPA com Hibernate para o mapeamento e a persistência dos dados.

**Banco utilizado no ambiente local:**

```text
guiche_db
```

A URL de conexão, o usuário e a senha devem ser configurados conforme o ambiente de execução. Não versione credenciais reais nem chaves secretas.

> **Observação:** o ambiente de CI utiliza PostgreSQL 16, enquanto o ambiente local informado utiliza PostgreSQL 18. A compatibilidade deve ser validada nos testes e no ambiente de destino.

## ▶️ Como executar localmente

### Pré-requisitos

- JDK 26 instalado.
- PostgreSQL instalado e em execução.
- Banco de dados `guiche_db` criado.
- Maven Wrapper disponível no repositório.
- Variáveis de ambiente configuradas.

### 1. Clone o repositório

```bash
git clone <URL_DO_REPOSITORIO>
cd guiche-api
```

### 2. Configure as variáveis de ambiente

Configure os parâmetros de conexão com o PostgreSQL e as credenciais utilizadas na autenticação:

```text
SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
JWT_SECRET
API_AUTH_USERNAME
API_AUTH_PASSWORD
```

O valor de `JWT_SECRET` deve estar no formato Base64 e representar uma chave adequada para HS256.

Certifique-se de que a aplicação utiliza essas variáveis no `application.properties` e de que as credenciais não estão versionadas.

### 3. Execute a aplicação

No Windows, utilizando PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

Ou execute a classe principal `GuicheApiApplication` pela sua IDE.

### 4. Acesse a documentação

Com a aplicação iniciada, abra:

```text
http://localhost:8080/doc
```

## 🧪 Testes e validação

Para executar os testes:

```powershell
.\mvnw.cmd test
```

Para compilar e empacotar a aplicação:

```powershell
.\mvnw.cmd clean package
```

O pipeline de CI executa essas etapas automaticamente conforme os eventos configurados no workflow.

## 🎯 Roadmap

- [ ] Concluir o CRUD de guichês.
- [ ] Implementar as operações de filas.
- [ ] Implementar as operações de atendimentos.
- [ ] Expandir testes unitários e de integração.
- [ ] Aprimorar validações e respostas de erro.
- [ ] Integrar os módulos ao sistema Django.
- [ ] Containerizar a aplicação com Docker.
- [ ] Implementar Continuous Delivery (CD).
- [ ] Evoluir a estratégia de configuração e observabilidade.

## 👨‍💻 Objetivo do projeto

Este projeto faz parte da evolução de uma aplicação existente, explorando a construção de uma API REST com Java e Spring Boot.

O desenvolvimento tem como foco aplicar boas práticas de arquitetura, segurança, persistência, documentação e automação, criando uma base que possa evoluir de forma incremental.

---

**Desenvolvido com ☕ Java, Spring Boot e dedicação ao aprendizado contínuo.**

