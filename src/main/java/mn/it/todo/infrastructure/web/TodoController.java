package mn.it.todo.infrastructure.web;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import mn.it.todo.domain.Todo;
import mn.it.todo.domain.TodoCreator;
import mn.it.todo.domain.TodoUpdater;
import mn.it.todo.domain.Todos;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;
import java.util.UUID;

import static io.micronaut.http.HttpResponse.created;
import static io.micronaut.http.HttpResponse.notFound;
import static io.micronaut.http.HttpResponse.ok;
import static mn.it.todo.infrastructure.web.TodoController.TODOS_URI;

@Controller(TODOS_URI)
class TodoController {
    static final String TODOS_URI = "/todos";
    private Todos todos;

    TodoController(Todos todos) {
        this.todos = todos;
    }

    @Get
    public HttpResponse<Collection<Todo>> findAll() {
        return ok(todos.findAll());
    }

    @Get("/{id}")
    public HttpResponse<Todo> get(UUID id) {
        return todos.findById(id)
                .map(HttpResponse::ok)
                .orElse(notFound());
    }

    @Post
    public HttpResponse<Todo> create(@Valid CreateTodoDto dto) {
        Todo todo = todos.save(TodoCreator.create(dto));
        return created(todo, toLocation(todo));
    }

    @Put("/{id}")
    public HttpResponse<Todo> update(UUID id, @Valid UpdateTodoDto dto) {
        return todos.findById(id)
                .map(todo -> TodoUpdater.update(todo, dto))
                .map(HttpResponse::ok)
                .orElse(notFound());
    }

    private URI toLocation(Todo todo) {
        return URI.create(TODOS_URI + "/" + todo.getId().toString());
    }
}
