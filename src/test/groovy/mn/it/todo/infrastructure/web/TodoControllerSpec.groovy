package mn.it.todo.infrastructure.web

import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpResponse
import mn.it.IntegrationSpecification

import static io.micronaut.http.HttpRequest.GET
import static io.micronaut.http.HttpRequest.POST
import static io.micronaut.http.HttpStatus.CREATED
import static io.micronaut.http.HttpStatus.OK

class TodoControllerSpec extends IntegrationSpecification {
    def "should get all todos"() {
        when:
        HttpResponse<Todo[]> response = httpClient.toBlocking().exchange(GET("/todos"), Todo[])

        then:
        response.status() == OK
        Todo[] todos = response.body()
        todos.size() == 2

        todos[0].id
        todos[0].task == "Learn Micronaut"
        !todos[0].done

        todos[1].id
        todos[1].task == "Write Blogpost"
        !todos[1].done
    }

    def "should create new todo"() {
        given:
        String dto = """
            | {
            |   "task": "new task"
            | }
        """.stripMargin()

        when:
        HttpResponse<Todo> response = httpClient.toBlocking().exchange(POST("/todos", dto), Todo)

        then:
        response.status() == CREATED
        response.header(HttpHeaders.LOCATION) == "/todos/${response.body().id.toString()}"
    }

    def "should get all todos 2"() {
        when:
        HttpResponse<Todo[]> response = httpClient.toBlocking().exchange(GET("/todos"), Todo[])

        then:
        response.status() == OK
        Todo[] todos = response.body()
        todos.size() == 2
    }

    static class Todo {
        UUID id
        String task
        Boolean done
    }
}
