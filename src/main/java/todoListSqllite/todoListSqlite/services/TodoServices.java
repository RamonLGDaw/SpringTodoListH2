package todoListSqllite.todoListSqlite.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoListSqllite.todoListSqlite.model.TodoModel;
import todoListSqllite.todoListSqlite.repositories.ITodoRepository;

@Service
public class TodoServices {

    @Autowired
    ITodoRepository itodoRepository;


    public ArrayList<TodoModel> getTask(){
        ArrayList<TodoModel> taskList = (ArrayList<TodoModel>) itodoRepository.findAll();
        return taskList;
    }


    public TodoModel createTask(TodoModel task){
        return itodoRepository.saveAndFlush(task);
    }


    public Optional<TodoModel> getOneById(Long id){
        return itodoRepository.findById(id);
    }


     public String deleteTask(Long id) {
        if (itodoRepository.existsById(id)) {
            itodoRepository.deleteById(id);
            return "The task was deleted successfully.";
        } else {
            return "The task with ID " + id + " does not exist.";
        }
    }


    public Optional<TodoModel> updateTask(Long id, TodoModel updatedTask){
        Optional<TodoModel> task = itodoRepository.findById(id);
        
        task.ifPresent(item ->{
            item.setTask(updatedTask.getTask());

            itodoRepository.save(item);
        });

        return task;
    }
}
