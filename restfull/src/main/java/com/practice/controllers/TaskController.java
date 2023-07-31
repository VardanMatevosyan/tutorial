package com.practice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.practice.entity.Task;
import com.practice.services.TaskService;
import javax.servlet.ServletException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

/**
 * AddTask servlet class.
 * Created on 07.07.2018.
 * @author Matevosian Vardan.
 * @version 1.0
 */
@Path("/task")
public class TaskController {
    private static final Logger LOG = LoggerFactory.getLogger(TaskController.class.getName());
    private static final TaskService TASK_SERVICE = new TaskService();

    /**
     * Get all offers.
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getAll() {
        return TASK_SERVICE.getAll();
    }


    /**
     * doPost method insert data to database.
     * @throws ServletException servlet exception.
     * @throws IOException input output exception.
     */
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Task task) throws ServletException, IOException {
        if (task != null) {
            TASK_SERVICE.add(task);
        } else {
            LOG.error("Trying to add to the database but task is not present (null)");
        }
        Task added = TASK_SERVICE.getLastAddedTask();
        return Response.status(201).entity(added).build();
    }


    /**
     * Change offer sell status.
     * @param id task id.
     * @param done task done.
     */
    @PUT
    @Path("/state/{id}/{done}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void change(@PathParam("id") String id, @PathParam("done") boolean done) {
        TASK_SERVICE.changeTaskState(done, Integer.valueOf(id));
    }

}

