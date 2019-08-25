package mn.it.todo.domain;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.Collection;
import java.util.UUID;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface Todos extends CrudRepository<Todo, UUID> {
    @NonNull
    @Override
    Collection<Todo> findAll();
}
