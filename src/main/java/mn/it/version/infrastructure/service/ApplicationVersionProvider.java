package mn.it.version.infrastructure.service;

import mn.it.version.domain.Version;
import mn.it.version.domain.VersionProvider;

import javax.inject.Singleton;

@Singleton
class ApplicationVersionProvider implements VersionProvider {
    public Version version() {
        return Version.of("1.0.0");
    }
}
