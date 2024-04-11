# Springboot-Microservice

 Micro Serviços 3

### Tecnologias

- Java 21 (Records)
- Spring Boot (Controller, Repository, JPA, Tests)
- H2 Banco de dados
- Docker (Docker-compose)
- Lombok
- Postman
- Zipkin (Sleuth)


## Dependências

Microservices

1. service-registry
    - Eureka Server
2. config-server
    - Eureka Client
    - Config Server
3. api-gateway
    - Eureka Client
4. zipkin (Distributed tracing system)
    - Docker configuration
5. stream-service
    - Web
    - JPA
    - H2
    - Cloud Config
    - Eureka Client
    - Sleuth (Agregador e rastreamento de logs e requisições)
    - Zipkin
6. filme-service
    - Web
    - Cloud Config
    - Eureka Client
    - Zipkin

# Components

- Service registry
    - http://localhost:9001
- Config Server
    - http://localhost:9002/actuator/health
- API Gateway
    - http://localhost:8000/actuator/health
- Filme Service
    - http://localhost:8081/actuator/health
- Stream Service
    - http://localhost:8082/actuator/health
- Zipkin (Distributed tracing System)
    - http://localhost:9411/zipkin

