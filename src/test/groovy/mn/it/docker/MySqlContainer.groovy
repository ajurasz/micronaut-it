package mn.it.docker

import org.testcontainers.containers.GenericContainer

class MySqlContainer {
    static final GenericContainer MY_SQL_CONTAINER = new GenericContainer("mysql:8")
            .withEnv("MYSQL_ROOT_PASSWORD", "password")
            .withEnv("MYSQL_DATABASE", "it")
            .withExposedPorts(3306)
}
