package mn.it.docker

import org.spockframework.runtime.extension.AbstractGlobalExtension
import org.testcontainers.containers.GenericContainer

class DockerInfrastructureRunner extends AbstractGlobalExtension {
    private final Collection<GenericContainer> containers = [
            MySqlContainer.MY_SQL_CONTAINER
    ]

    @Override
    void start() {
        containers.each {
            if (!it.isRunning()) {
                it.start()
            }
        }
    }

    @Override
    void stop() {
        containers.each {
            if (it.isRunning()) {
                it.stop()
            }
        }
    }
}
