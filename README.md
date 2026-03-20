# Desafia 🏆

O Desafia é uma plataforma de engajamento baseada em desafios comunitários, utilizando elementos de gamificação e recompensas de XP para motivar a progressão dos usuários.

### 🚀 Tecnologias

Este projeto foi construído com as seguintes tecnologias:

    Java 17+

    Spring Boot 3 (Data JPA, Web, Validation)

    PostgreSQL (Banco de dados relacional)

    Docker & Docker Compose (Containerização)

    Maven (Gerenciador de dependências)

### 📦 Estrutura do Projeto

A estrutura segue padrões de organização para facilitar a manutenção e o isolamento de ambientes:
Plaintext

```
.
├── docker/
│   ├── dev/            # Configurações de Docker para desenvolvimento
│   └── prod/           # Configurações de Docker para produção
├── src/                # Código-fonte da aplicação
├── docker-compose.yml  # Orquestração principal (App + DB)
└── pom.xml             # Dependências Maven
```

### 🛠️ Como Executar
Pré-requisitos

    Docker e Docker Compose instalados.
    (Opcional) Java 17 e Maven se desejar rodar fora do container.

Passo a Passo

    _Clonar o repositório:
    git clone https://github.com/danielBRTanimacao/DesafiaBackend.git
    cd DesafiaBackend

    _Subir o ambiente com Docker:
    docker-compose up -d

### 🗄️ Banco de Dados

O banco de dados é inicializado automaticamente via Docker. Se precisar conectar manualmente para depuração:

    Host: localhost

    Porta: 5432

    User: admin (conforme definido no .env ou docker-compose)

    Password: admin

    Database: desafia_db

### 🧪 Testes

Para rodar os testes unitários e de integração:

    mvn test

### 🤝 Contribuição

    Faça um Fork do projeto.

    Crie uma nova Branch (git checkout -b feature/nome-da-feature).

    Faça o Commit de suas alterações (git commit -m 'Add: nova funcionalidade').

    Envie para o Branch (git push origin feature/nome-da-feature).

    Abra um Pull Request.

📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

Desenvolvido com ☕ por DanielBRTanimacao.
