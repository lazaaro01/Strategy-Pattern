# 📬 Notification Service

## 📖 Overview

**Notification Service** é uma API backend desenvolvida em **Java 21 com Spring Boot** para envio de notificações de forma assíncrona utilizando mensageria.

O sistema foi projetado com foco em **arquitetura escalável**, utilizando filas, workers e o **Strategy Pattern** para suportar múltiplos canais de notificação.

A API recebe requisições de envio e publica eventos em uma fila. Workers processam essas mensagens e executam o envio de acordo com o canal escolhido.

---

# 🏗️ Architecture

O projeto segue princípios inspirados em **Clean Architecture** e **Hexagonal Architecture**, separando claramente as responsabilidades da aplicação.

```
Controller
   ↓
Service
   ↓
UseCase
   ↓
Repository
   ↓
Message Producer
   ↓
Queue
   ↓
Consumer Worker
   ↓
Strategy Channel
```

---

# ⚙️ Tech Stack

## Backend

- Java 21
- Spring Boot
- Spring Data JPA
- Spring AMQP
- Redis
- RabbitMQ
- PostgreSQL

## Infraestrutura

- Docker
- Docker Compose

## Arquitetura e Padrões

- Clean Architecture
- Strategy Pattern
- Event Driven Architecture
- Asynchronous Processing

---

# 📂 Project Structure

```
src/main/java/com/notification

application
 ├── dto
 ├── service
 └── usecase

domain
 ├── entity
 ├── enums
 └── repository

infrastructure
 ├── channels
 ├── config
 ├── messaging
 └── repository

interfaces
 └── controller
```

---

# 🔁 Notification Flow

```
Client
  ↓
REST API
  ↓
UseCase
  ↓
Save Notification
  ↓
Producer
  ↓
RabbitMQ Queue
  ↓
Consumer Worker
  ↓
Channel Strategy
  ↓
Send Notification
```

---

# 📡 Supported Channels

Atualmente o sistema suporta os seguintes canais:

- Email
- SMS
- Webhook

Cada canal possui uma implementação própria utilizando o **Strategy Pattern**, permitindo adicionar novos canais facilmente.

---

# 🚀 API Endpoint

## Send Notification

### Request

**POST** `/notifications`

```json
{
  "recipient": "user@email.com",
  "message": "Hello world",
  "channel": "EMAIL"
}
```

### Response

```json
{
  "id": "uuid",
  "recipient": "user@email.com",
  "message": "Hello world",
  "channel": "EMAIL",
  "status": "PENDING",
  "createdAt": "2026-03-09T12:00:00"
}
```

---

# 🐳 Running with Docker

## Build da aplicação

```bash
mvn clean package
```

## Subir o ambiente

```bash
docker compose up --build
```

---

# 🧩 Services

| Service | Port |
|------|------|
| API | 8080 |
| PostgreSQL | 5432 |
| RabbitMQ | 5672 |
| RabbitMQ Dashboard | 15672 |
| Redis | 6379 |

---

# 🐰 RabbitMQ Dashboard

Acesse:

```
http://localhost:15672
```

Login:

```
guest
guest
```

---

# 👨‍💻 Feito por

**Lázaro Vasconcelos**
