package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repository.TodoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "TodosService")
public class TodoServiceImpl implements TodosService
{
    @Autowired
    TodoRepo todorepo;

    @Override
    public void markComplete(long todoid)
    {
        Todo t = new Todo();
        t = todorepo.findById(todoid)
                .orElseThrow(() -> new EntityNotFoundException("To Do Item " + todoid  + "Not Found!"));
        t.setCompleted(true);
    }


}
