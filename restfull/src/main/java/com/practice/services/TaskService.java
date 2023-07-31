package com.practice.services;

import com.practice.entity.Task;
import com.practice.repository.TaskRepository;
import java.util.List;

public class TaskService {
    private static final TaskRepository TASK_REPOSITORY = new TaskRepository();
    /**
     * Add task to database.
     * @param task todoList.
     */

    public void add(Task task) {
        TASK_REPOSITORY.add(task);
    }

    /**
     * GetAll method.
     * Get all task.
     * @return list of task
     */
    public List<Task> getAll() {
        return TASK_REPOSITORY.getAll();
    }

    /**
     * Get the last added task.
     * @return last task
     */
    public Task getLastAddedTask() {
        return TASK_REPOSITORY.getLastAddedTask();
    }

    /**
     * Change task done state in db.
     * @param stateButtonValue done state.
     * @param taskId task id.
     * @return count of updated rows.
     */
    public boolean changeTaskState(Boolean stateButtonValue, Integer taskId) {
        return TASK_REPOSITORY.changeTaskState(stateButtonValue, taskId);
    }

//    /**
//     * Change task done state in db.
//     * @param taskId task id.
//     * @return count of updated rows.
//     */
//    public boolean changeTaskState(Integer taskId) {
//        return TASK_REPOSITORY.changeTaskState(taskId);
//    }
}
