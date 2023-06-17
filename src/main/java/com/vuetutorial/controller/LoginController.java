package com.vuetutorial.controller;



import com.vuetutorial.entity.User;
import com.vuetutorial.entity.result.Result;
import com.vuetutorial.entity.Project;
import com.vuetutorial.service.ProjectService;
import com.vuetutorial.service.UserService;
import com.vuetutorial.entity.result.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<User> login(@RequestBody User user) {
        return userService.login(user);
    }

    @GetMapping("/api/projects")
    public Result<List<Project>> getProjects() {
        List<Project> list = projectService.list();
        return new Result<>(ResultEnum.SUCCESS, list);
    }
}
