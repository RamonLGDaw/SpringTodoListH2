package todoListSqllite.todoListSqlite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todoListSqllite.todoListSqlite.model.TodoModel;

@Repository
public interface ITodoRepository extends JpaRepository<TodoModel, Long> {

}
