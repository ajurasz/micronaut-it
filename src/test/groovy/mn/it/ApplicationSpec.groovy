package mn.it

import io.micronaut.context.ApplicationContext

class ApplicationSpec extends IntegrationSpecification {
    def "should init application context"() {
        expect:
        getBean(ApplicationContext) != null
    }
}
