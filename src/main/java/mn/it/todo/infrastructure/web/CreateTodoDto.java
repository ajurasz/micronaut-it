package mn.it.todo.infrastructure.web;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotEmpty;

@Introspected
public class CreateTodoDto {
    @NotEmpty private String task;

    public String getTask() {
        return task;
    }
}
