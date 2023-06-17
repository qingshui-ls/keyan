package com.vuetutorial.service.impl;

import com.vuetutorial.entity.Todolist;
import com.vuetutorial.mapper.TodolistMapper;
import com.vuetutorial.service.TodolistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-15
 */
@Service
public class TodolistServiceImpl extends ServiceImpl<TodolistMapper, Todolist> implements TodolistService {

}
