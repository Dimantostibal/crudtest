package crud.controller;

import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
        model.addAttribute("AllUsers", list);
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("person", userService.getUser(id));
        return "show";
    }

    @GetMapping("/create")
    public String createUser(@ModelAttribute("newUser") User user) {
        return "create";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("newUser") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/update")
    public String edit(@PathVariable("id") int id, ModelMap model){
        model.addAttribute("updateUser", userService.getUser(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("updateUser") User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")int id) {
        userService.delete(id);
        return "redirect:/users";
    }



}
