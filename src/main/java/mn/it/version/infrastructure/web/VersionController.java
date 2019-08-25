package mn.it.version.infrastructure.web;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import mn.it.version.domain.VersionProvider;

@Controller("/version")
public class VersionController {
    private final VersionProvider versionProvider;

    public VersionController(VersionProvider versionProvider) {
        this.versionProvider = versionProvider;
    }

    @Get
    public String getVersion() {
        return versionProvider.version().version();
    }
}
