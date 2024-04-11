# api-gateway


## Rodando o projeto

```shell
mvn spring-boot:run 
```

## validando o acesso ao projeto

```shell
curl http://localhost:8000/actuator/health
```



### Depois de configurar os servicos


 filme-service

```shell
curl http://localhost:8000/filme
```

 stream-service

```shell
curl http://localhost:8000/stream
```