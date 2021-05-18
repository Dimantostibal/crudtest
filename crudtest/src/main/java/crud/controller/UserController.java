package crud.controller;

import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(ModelMap model){
        List<User> list = userService.getAllUsers();
        model.addAttribute("users", list);
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("person", userService.getUser(id));
        return "show";
    }

}
