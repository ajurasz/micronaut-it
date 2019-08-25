package mn.it

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.support.TestPropertyProvider
import mn.it.docker.MySqlContainer
import org.flywaydb.core.Flyway
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest(environments = "it")
abstract class IntegrationSpecification extends Specification implements TestPropertyProvider {

    @Inject
    private ApplicationContext applicationContext

    @Inject
    private Flyway flyway

    @Inject
    @Client('/')
    RxHttpClient httpClient

    def cleanup() {
        flyway.clean()
        flyway.migrate()
    }

    protected <T> T getBean(Class<T> beanType) {
        applicationContext.getBean(beanType)
    }

    @Override
    Map<String, String> getProperties() {
        ["datasources.default.port": MySqlContainer.MY_SQL_CONTAINER.firstMappedPort] as Map<String, String>
    }
}
