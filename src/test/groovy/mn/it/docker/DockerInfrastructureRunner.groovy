package mn.it.docker

import org.spockframework.runtime.extension.IGlobalExtension
import org.spockframework.runtime.model.SpecInfo
import org.testcontainers.containers.GenericContainer

class DockerInfrastructureRunner implements IGlobalExtension {
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
    void visitSpec(SpecInfo specInfo) {
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
