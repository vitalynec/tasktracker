package vitane.tasktracker.service;

import vitane.tasktracker.entity.Task;

import java.util.List;

public interface TaskService {

    void save(final String orderId);

    List<Task> findAll();

    List<Task> getTaskByOrder(final String orderId);
}
