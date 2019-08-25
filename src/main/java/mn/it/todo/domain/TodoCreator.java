package mn.it.todo.domain;

import mn.it.todo.infrastructure.web.CreateTodoDto;

public class TodoCreator {
    public static Todo create(CreateTodoDto dto) {
        return new Todo(dto.getTask());
    }
}
