package mn.it.version.domain;

public final class Version {
    private final String version;

    private Version(String version) {
        this.version = version;
    }

    public static Version of(String version) {
        return new Version(version);
    }

    public String version() {
        return version;
    }
}
