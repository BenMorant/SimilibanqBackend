
# SimilibanqBackend

Similibanq backend project with Java and Spring

## Prerequisite

- [Oracle JDK 8](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
  OR [OpenJDK 8](https://openjdk.java.net/install)
- [Maven 3.6.3](https://maven.apache.org/)
- [MySQL server 5.7+](https://dev.mysql.com/downloads)
  or [MariaDB Server 10.4.13+](https://go.mariadb.com/download-mariadb-server-community.html)

## Installation

Create a new MySQL user:

- once connected to MySQL, type the following commands :

```sh
CREATE USER 'x'@'localhost' IDENTIFIED BY 'y';
GRANT ALL PRIVILEGES ON db_similibanq.* TO 'x'@'localhost';
FLUSH PRIVILEGES;
```

where **X** is your username, and **Y** your password.
Then update the `src/main/resources/application.properties` file.

```sh
spring.datasource.username=X
spring.datasource.password=Y
```

A new database, called "db_similibanq", will be created upon startup.

## Test

Use the following command to run the unit tests:

```sh
gradle clean build
```

## Usage

Run a local server:

```sh
gradle bootRun
```

The server listens on port 8060 by default:

```sh
curl http://localhost:8060/similibanq-backend/index.html
```
