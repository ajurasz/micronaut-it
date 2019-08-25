package mn.it.version.infrastructure.service

import io.micronaut.context.annotation.Replaces
import mn.it.version.domain.Version
import mn.it.version.domain.VersionProvider

import javax.inject.Singleton

@Replaces(ApplicationVersionProvider)
@Singleton
class MockedVersionProvider implements VersionProvider {
    @Override
    Version version() {
        Version.of("0.0.0")
    }
}
