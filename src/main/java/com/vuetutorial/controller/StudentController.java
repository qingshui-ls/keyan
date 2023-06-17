package com.vuetutorial.controller;

import com.vuetutorial.entity.Student;
import com.vuetutorial.service.StudentService;
import com.vuetutorial.entity.result.Result;
import com.vuetutorial.entity.result.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2023-06-15
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/api/user/{id}")
    public Result<Student> getUserInfo(@PathVariable("id") Long id) {
        return new Result<>(ResultEnum.SUCCESS, studentService.getById(id));
    }
}
