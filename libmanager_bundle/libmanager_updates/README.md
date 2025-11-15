# LibManager — Sistema de Gerenciamento de Biblioteca

## 📌 Visão Geral
LibManager é uma aplicação Web REST construída em **Spring Boot**, estruturada no padrão **Controller–Service–Repository**.
O sistema foi refatorado para aplicar três Design Patterns fundamentais:

- **Factory Method** (Criacional)
- **Decorator** (Estrutural)
- **Strategy** (Comportamental)

## 📁 Estrutura do Projeto
```
src/
 ├── main/
 │   ├── java/com/example/libmanager/
 │   │   ├── controller/
 │   │   ├── service/
 │   │   ├── repository/
 │   │   ├── model/
 │   │   └── patterns/
 │   └── resources/
 └── test/
     └── java/com/example/libmanager/
         ├── service/
         ├── controller/
         └── patterns/
```

## 🚀 Endpoints REST
### Livros
- `GET /books`
- `POST /books`
- `PUT /books/{id}`
- `DELETE /books/{id}`

### Usuários
- `GET /users`
- `POST /users`

## 🧪 Testes Unitários e de Integração
Os testes utilizam:
- **JUnit 5**
- **Mockito**
- **Spring Boot Test**
- **MockMvc**

Cobrem:
- Controllers com MockMvc  
- Services com Mockito  
- Padrões de projeto isoladamente  

## ▶️ Como Executar o Projeto
```
mvn spring-boot:run
```

## ▶️ Executar Testes
```
mvn test
```
