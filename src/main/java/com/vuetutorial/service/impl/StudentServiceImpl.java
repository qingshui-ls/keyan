package com.vuetutorial.service.impl;

import com.vuetutorial.entity.Student;
import com.vuetutorial.mapper.StudentMapper;
import com.vuetutorial.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-15
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
