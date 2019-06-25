package vitane.tasktracker.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vitane.tasktracker.entity.Task;
import vitane.tasktracker.mapper.TaskRowMapper;

import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(final String orderId) {
        jdbcTemplate.update(
                "INSERT INTO call_task (order_id) VALUES (?)",
                orderId
        );
    }

    public List<Task> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM call_task",
                new TaskRowMapper()
        );
    }

    public List<Task> getTaskByOrder(final String orderId) {
        return jdbcTemplate.query(
                "SELECT * FROM call_task WHERE ORDER_ID = ?",
                new TaskRowMapper(),
                orderId
        );
    }
}
