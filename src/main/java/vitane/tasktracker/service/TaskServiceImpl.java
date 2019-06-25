package vitane.tasktracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitane.tasktracker.dao.TaskDAO;
import vitane.tasktracker.entity.Task;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    public TaskDAO taskDAO;

    @Override
    public void save(String orderId) {
        taskDAO.save(orderId);
    }

    @Override
    public List<Task> findAll() {
        return taskDAO.findAll();
    }

    @Override
    public List<Task> getTaskByOrder(String orderId) {
        return taskDAO.getTaskByOrder(orderId).isEmpty() ? taskDAO.findAll() : taskDAO.getTaskByOrder(orderId);
    }
}
