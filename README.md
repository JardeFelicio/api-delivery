# Order Management System

Este é um projeto de estudo focado na construção de um sistema simples de gerenciamento de pedidos usando Java Spring Boot. O projeto foi criado para me ajudar a explorar e entender as principais tecnologias e conceitos, como Java Spring Boot, autenticação JWT, controle de acesso e documentação de API com Swagger.

## Tecnologias utilizadas

![Java](https://img.shields.io/badge/java-000.svg?style=for-the-badge&logo=openjdk&logoColor=%23ED8B00)
![Spring](https://img.shields.io/badge/Spring-000?style=for-the-badge&logo=spring)
![Swagger](https://img.shields.io/badge/Swagger-000?style=for-the-badge&logo=swagger)
![springsecurity](https://img.shields.io/badge/Springsecurity-000?style=for-the-badge&logo=springsecurity)
![jsonwebtokens](https://img.shields.io/badge/Jsonwebtokens-000?style=for-the-badge&logo=jsonwebtokens)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-000?style=for-the-badge&logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-000?style=for-the-badge&logo=docker)

### Passos para iniciar a aplicação

1. **Certifique-se de que o Docker e o Docker Compose estão instalados.**

2. **Clone o repositório do projeto:**
   ```bash
   git clone https://github.com/JardeFelicio/api-delivery.git
   cd api-delivery
   ```

3. **Observação sobre Configuração:**
   Antes de iniciar os containers, certifique-se de que as variáveis de ambiente estão corretamente configuradas no seu arquivo `docker-compose.yml`.

4. **Construa e inicie os containers usando o Docker Compose:**
   ```bash
   docker-compose up -d
   ```

5. **Aguarde até que todos os containers estejam em execução.**

6. **Acesse a API através do Swagger:**
   Abra seu navegador e visite [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) para explorar os endpoints da API.

