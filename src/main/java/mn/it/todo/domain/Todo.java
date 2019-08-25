package mn.it.todo.domain;

import io.micronaut.core.annotation.Creator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "TODOS")
public class Todo {
    @Id
    private UUID id = UUID.randomUUID();
    private Boolean done = false;
    private String task;

    Todo(String task) {
        this.task = task;
    }

    @Creator
    Todo(UUID id, Boolean done, String task) {
        this.id = id;
        this.done = done;
        this.task = task;
    }

    public UUID getId() {
        return id;
    }

    public Boolean getDone() {
        return done;
    }

    public Todo setTask(String task) {
        this.task = task;
        return this;
    }

    public String getTask() {
        return task;
    }

    public Todo setDone(Boolean done) {
        this.done = done;
        return this;
    }
}
