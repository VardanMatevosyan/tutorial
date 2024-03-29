package com.practice.repository;

import org.hibernate.Query;
import com.practice.entity.Task;
import com.practice.utils.SessionManager;

import java.sql.Timestamp;
import java.util.List;

/**
 * TaskRepository class for holding main method to manipulate with task.
 */
public class TaskRepository {
    private static final SessionManager TRANSACTION = SessionManager.TRANSACTION;

    /**
     * Add task to database.
     * @param task todoList.
     */
    public void add(Task task) {
        task.setCreateDate(new Timestamp(System.currentTimeMillis()));
        TRANSACTION.use(session -> session.save(task));
    }

    /**
     * GetAll method.
     * Get all task.
     * @return list of task
     */
    public List<Task> getAll() {
        return TRANSACTION.use(session -> {
                    Query query = session.createQuery("FROM Task order by createDate desc");
                    return (List<Task>) query.list();
        });
    }

    /**
     * Get the last added task.
     * @return last task
     */
    public Task getLastAddedTask() {
        return TRANSACTION.use(session -> {
            Query query = session.createQuery("FROM Task order by createDate asc");
            List<Task> quryList = (List<Task>) query.list();
            return quryList.get(quryList.size() - 1);
        });
    }

    /**
     * Change task done state in db.
     * @param stateButtonValue done state.
     * @param taskId task id.
     * @return count of updated rows.
     */
    public boolean changeTaskState(Boolean stateButtonValue, Integer taskId) {
        Integer updated = TRANSACTION.use(session -> {
            Query query = session.createQuery("UPDATE Task set done=:done WHERE id=:id");
            query.setBoolean("done", stateButtonValue);
            query.setInteger("id", taskId);
            return query.executeUpdate();
        });
        return updated == 1;
    }

}
