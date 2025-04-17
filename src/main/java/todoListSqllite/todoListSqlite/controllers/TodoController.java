package todoListSqllite.todoListSqlite.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import todoListSqllite.todoListSqlite.model.TodoModel;
import todoListSqllite.todoListSqlite.services.TodoServices;

@RestController
@RequestMapping("/task")
public class TodoController {

    @Autowired

    private TodoServices todoServices;

    @GetMapping()
    public ArrayList<TodoModel> getTasks(){
        return todoServices.getTask();
    }

    @PostMapping
    public TodoModel createTask(@RequestBody TodoModel task){
        return todoServices.createTask(task);
    }

    @GetMapping(path = "/{id}")
    public Optional<TodoModel> getOneById(@PathVariable("id") Long id){
        Optional<TodoModel> task = todoServices.getOneById(id);

        return task;
    }

    @DeleteMapping(path = "/{id}")
    public String deleteTask(@PathVariable("id") Long id){
        return todoServices.deleteTask(id);
    }


    @PutMapping(path = "/{id}")
    public Optional<TodoModel> updateTask(@PathVariable("id") Long id, @RequestBody TodoModel task){
        return todoServices.updateTask(id, task);
    }

}
