## Сервис выдачи gif в зависимости от курса


### Стэк:
Java 11/ Spring boot/ Lombok/ Gradle

### Запуск:

#### Gradle:
build.gradle 

run ExrateApplication

#### Docker:

docker build -t exrate .

docker run -p 8080:8080 exrate

#### Endpoint:
get /api/gif/{currency}
