# Yals API 
This is API of Proof of concept for Yals project 

## For Ops
### How to Deploy app

* Our docker image: `kyberorglab/yals-api`

* We need H2 (default profile) or PostgreSQL database (local/prod profiles) to run

#### Kubernetes

EnvVars: 

* SPRING_PROFILES_ACTIVE: `local, prod and actuator`

* DB_HOST: `hostname or service (container) name`

* DB_NAME: `database name`

* DB_USER: `username for database`

* DB_PASSWORD: `password for db user`

* CORS_ALLOWED_DOMAINS: `normally frontend domain (format: https://mydomain.tld)`

Optional EnvVars: 

* LOG_LEVEL_APP: `see Logging part`

* PORT: `start server at port other than 8080 `

* JAVA_DEBUG_PORT: `port for remote debugging` (this is internal port, need to expose it to connect from outside word)

Ports: 

* host port: `select yourself`

* container port: `8080 (or PORT)`

Volumes:

* dumps: should be mounted as `/opt/dumps` (volume to store heap dumps, when app crashed)

## For Developers
### How to start coding

* Git clone ``` git clone repoUrl ```

* Import into an IDE as **Maven** project

* Select all autodetected Spring facets

### About: local profile
To develop with locally running dockerized PostgreSQL database use `local` profile.

Profile can activated in IDEA or by setting env `SPRING_PROFILES_ACTIVE` to `local`

PostgreSQL can be started from `docker/local` directory by running:

```shell script
docker-compose up -d
``` 

PostgreSQL can be stopped from `docker/local` directory by running:

```shell script
docker-compose down
```

### API Doks
Located: [here](http://localhost:8080/api.html)

### Logging
To adjust logging we use ENV variables or `-D` vars: 

* Use `LOG_LEVEL_CORE` or `-Dlog.level.core` for setting overall log level

* Use `LOG_LEVEL_APP` or `-Dlog.level.app` for setting application (package: `ee.yals`) log level

* Use `LOG_LEVEL_SPRING` or `-Dlog.level.spring` for setting Spring (package: `org.springframework`) log level

* Use `LOG_LEVEL_DB` or `-Dlog.level.db` for setting Database SQL (package: `org.hibernate`) log level

### About: Tests

Selenide tests will be in separate repo
