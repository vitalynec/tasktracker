package vitane.tasktracker.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {
    private int id;
    private String orderId;
    private LocalDateTime dateTime;
}
