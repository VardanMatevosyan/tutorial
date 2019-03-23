package ru.matevosyan.entity;

import ru.matevosyan.utils.DateAdapter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Task class.
 * @author Matevosyan Vardan.
 * @version 1.0
 * created 06.07.2018
 */
@XmlRootElement
public class Task {
    private Integer id;
    private String description;
    private Timestamp createDate;
    private boolean done;

    /**
     * Default constructor.
     */
    public Task() {
    }

    /**
     * Description constructor.
     */
    public Task(final String description) {
        this.description = description;
    }

    /**
     * Description constructor.
     */
    public Task(final boolean done) {
        this.done = done;
    }


    /**
     * Custom constructor.
     * @param id  task id.
     * @param description task description.
     * @param done task done.
     */

    public Task(final int id, final String description, final Boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }


    /**
     * Getter for task id.
     * @return task id.
     */

    public Integer getId() {
        return id;
    }

    /**
     * Getter for task description.
     * @return task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter for task create date.
     * @return task create date.
     */
    @XmlJavaTypeAdapter(DateAdapter.class)
    public Timestamp getCreateDate() {
        return createDate;
    }

    /**
     * Getter for task done.
     * @return task done.
     */
    public boolean getDone() {
        return done;
    }


    /**
     * Setter for task id.
     * @param id task id.
     */

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Setter for task description.
     * @param description task description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Setter for task createDate.
     * @param createDate task createDate.
     */
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    /**
     * Setter for task done.
     * @param done task done.
     */
    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        return Objects.equals(id, task.id)
                && Objects.equals(description, task.description)
                && Objects.equals(createDate, task.createDate)
                && Objects.equals(done, task.done);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, createDate, done);
    }
}
