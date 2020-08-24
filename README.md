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
select * from ${table}
```

## Running Spring Boot App with local profile

1.
```
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

2.
```
java -jar -Dspring.profiles.active=local car-query-api.jar 
```