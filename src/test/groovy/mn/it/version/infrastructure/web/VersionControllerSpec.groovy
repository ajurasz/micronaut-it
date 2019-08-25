package mn.it.version.infrastructure.web

import io.micronaut.http.HttpResponse
import mn.it.IntegrationSpecification

import static io.micronaut.http.HttpRequest.GET
import static io.micronaut.http.HttpStatus.OK

class VersionControllerSpec extends IntegrationSpecification {
    def "should get application version"() {
        when:
        HttpResponse<String> response = httpClient.toBlocking().exchange(GET("/version"), String)

        then:
        response.status() == OK
        response.body() == "0.0.0"
    }
}
