package mn.it.todo.infrastructure.web;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Introspected
public class UpdateTodoDto {
    @NotEmpty private String task;
    @NotNull private Boolean done;

    public String getTask() {
        return task;
    }

    public Boolean getDone() {
        return done;
    }


}
