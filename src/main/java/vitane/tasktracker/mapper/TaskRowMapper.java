package vitane.tasktracker.mapper;

import org.springframework.jdbc.core.RowMapper;
import vitane.tasktracker.entity.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskRowMapper implements RowMapper<Task> {

    @Override
    public Task mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Task task = new Task();

        task.setId(rs.getInt("ID"));
        task.setOrderId(rs.getString("ORDER_ID"));
        task.setDateTime(LocalDateTime.parse(
                rs.getString("DATE_TIME"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        );
        return task;
    }
}
