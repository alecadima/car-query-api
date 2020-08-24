# Car Query REST API

## Running Cassandra on Local Environment 

1. Running Cassandra Docker Container
```
docker-compose up
```

2. Connecting in Cassandra Docker Container
```
docker run --rm -it -e CQLSH_HOST=localhost --net=host nuvo/docker-cqlsh bash
```

3. Access Cassandra CLI
```
cqlsh
```

4. Showing Keyspaces of Cassandra
```
describe keyspaces
```

5. Using Keyspace
```
use ${keyspace};
```

6. Showing Tables of Keyspace
```
describe tables;
```

7. Selecting data from table
```
INSERT INTO tanzu.car (id, nm_assembler, nm_model, nr_manufacturing_year, nr_model_year) VALUES (6ab09bec-e68e-48d9-a5f8-97e6fb4c9b47, 'Ford','Foucs', 2020, 2020);
SELECT * FROM ${table}
```

## Running Spring Boot App with local profile

1. Running Spring Boot App with Maven plugin
```
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

2. Running Spring Boot App with java -jar
```
java -jar -Dspring.profiles.active=local car-query-api.jar 
```