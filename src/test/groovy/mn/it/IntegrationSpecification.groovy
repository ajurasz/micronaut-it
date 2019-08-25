package mn.it

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.RxHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import mn.it.docker.MySqlContainer
import org.flywaydb.core.Flyway
import spock.lang.AutoCleanup
import spock.lang.Specification

abstract class IntegrationSpecification extends Specification {

    @AutoCleanup
    private static EmbeddedServer embeddedServer = ApplicationContext.run(
            EmbeddedServer,
            ["datasources.default.port": MySqlContainer.MY_SQL_CONTAINER.firstMappedPort] as Map<String, Object>,
            "it")

    private Flyway flyway = getBean(Flyway)

    RxHttpClient httpClient = embeddedServer.applicationContext.createBean(RxHttpClient, embeddedServer.getURI())

    def cleanup() {
        flyway.clean()
        flyway.migrate()
    }

    protected <T> T getBean(Class<T> beanType) {
        embeddedServer.applicationContext.getBean(beanType)
    }
}
