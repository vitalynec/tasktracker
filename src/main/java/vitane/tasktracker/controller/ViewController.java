package vitane.tasktracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vitane.tasktracker.service.TaskService;

@Controller
public class ViewController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tasks")
    public String getAllTasksPage(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "tasklist";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public String getAddPage() {
        return "add";
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/find"})
    public String getTasksPage(String orderId, Model model) {
        model.addAttribute("tasks", taskService.getTaskByOrder(orderId));
        return "tasklist";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String addTask(String orderId) {
        taskService.save(orderId);
        return "redirect:/add";
    }
}
