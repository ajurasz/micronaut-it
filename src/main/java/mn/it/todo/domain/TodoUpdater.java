package mn.it.todo.domain;

import mn.it.todo.infrastructure.web.UpdateTodoDto;

public class TodoUpdater {
    public static Todo update(Todo todo, UpdateTodoDto dto) {
        return todo.setTask(dto.getTask())
                .setDone(dto.getDone());
    }
}
