
#Short overview

## Purpose of this codebase

Application is playground for messing with postgres, concurrency and spring boot. I'm especially 
interested in concurrent access do same data in DB in case of application replication (using Docker)

## Docker compose in project

Docker compose file located under resources path. It has defined db (postgres) and this application
as a service (docker swarm) replicated 2 times. I have other stack with defined "architecture" services,
but in case of running this example:
    - you can uncomment postgres service path in docker compose yml file;
    - switch network declaration in yaml (comment 'external' propery, uncomment 'name' part);
    - uncomment mounted volume for postgres (located at the bottom of file);


Deploy stack:
```yaml
docker stack deploy --with-registry-auth -c docker-compose-pietraspg.yml pietraspg
```
Check container id's - command below show id's of two last started containers. In case you run 
docker compose with postgres service on, it may show postgres instead of one of our app:
```yaml
docker container ps -n 2
```
To check container logs (if you are using default docker logging driver, which is json-file) type:
```yaml
docker logs -f <containerID>
```
or
```yaml
docker logs <containerID> | less
```

## Rest endpoints

To simply add random record to DB type in terminal:
```http request
curl -X POST http://localhost:8080/add
```