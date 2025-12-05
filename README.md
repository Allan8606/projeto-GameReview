# 🎮 GameReview 

API REST desenvolvida em Java com Spring Boot para cadastro, avaliação e gerenciamento de games.  
O sistema permite associar jogos a estúdios, múltiplas plataformas e avaliações (reviews).

---

## 🚀 Tecnologias Utilizadas

- Java 17+ 
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Lombok
- Maven
- Postman (para testes)

---

## 📁 Estrutura do Projeto

O projeto segue a arquitetura em camadas:

- controllers -> Camada de entrada (endpoints HTTP)
- services -> Regras de negócio
- repositories -> Acesso ao banco de dados
- models -> Entidades JPA
- dtos -> Request e Response
- mapper -> Conversão entre Model ↔ DTO



---

## 🧩 Funcionalidades

### ✅ Game
- Criar game com:
  - Título
  - Estúdio
  - Plataformas
  - Avaliação (comentário e nota)
- Listar todos os games
- Buscar por título (ignore case)
- Buscar por ID
- Atualizar game
- Deletar game

---

### ✅ Plataforma
- Criar plataforma
- Listar plataformas
- Atualizar plataforma
- Deletar plataforma
- Associação automática com jogos

---

### ✅ Studio
- Criar estúdio
- Listar estúdios
- Buscar por ID
- Atualizar estúdio
- Deletar estúdio

---

### ✅ Review
- Criado automaticamente ao criar um game
- Atualizar avaliação
- Listar avaliações

---

## 🔗 Exemplos de Endpoints

### 🎮 Criar Game
```http
POST /game/criar
{
  "titulo": "Cyberpunk 2077",
  "studioId": "UUID_DO_STUDIO",
  "plataformasIds": [
    "UUID_DA_PLATAFORMA_1",
    "UUID_DA_PLATAFORMA_2"
  ],
  "reviewComentario": "Jogo lindo, mas problemático no lançamento",
  "reviewNota": 8.2
}
```


--- 
## 🛢️ Banco de Dados
- PostgreSQL
- Relacionamentos:
  - Game → Studio (ManyToOne)
  - Game → Plataforma (ManyToMany)
  - Game → Review (OneToOne)
 

--- 
## 👨‍💻 Autor
Projeto desenvolvido por Allan Isaac.
Estudante de Desenvolvimento Backend.

### 📌 Observação
Este projeto foi desenvolvido com fins educacionais, focado em boas práticas de desenvolvimento backend e arquitetura REST.

