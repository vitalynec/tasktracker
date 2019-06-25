package vitane.tasktracker.dao;

import vitane.tasktracker.entity.Task;

import java.util.List;

public interface TaskDAO {
    void save(final String orderId);
    List<Task> findAll();
    List<Task> getTaskByOrder(final String orderId);
}
