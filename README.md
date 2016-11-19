# spring-docker-link
Example setup of 2 dockerized Spring Boot apps that can talk to each other

## Running example by hand

* `docker run -p 8081:8080 --name server mszarlinski/server-app`
* `docker run -p 8082:8080 --name client --link <server_id> mszarlinski/client-app`
* `curl http://localhost:8082/client`

You can check Docker magic by executing:

* `docker exec client bash -c 'cat /etc/hosts'` - notice an entry for `server` container
* `docker exec client bash -c 'env'` - extra environment variables

## Running example with `docker-compose`
TBD

## Docker commands cheat sheet
* `docker images`
* `docker ps`
* `docker run -p 9090:8080 --name client --link <container_id> <image_name>`
* `docker stop, rm [-f], rmi`
* `docker exec <container> bash -c 'cat /etc/hosts' , bash -c 'env'`
* `docker attach`
