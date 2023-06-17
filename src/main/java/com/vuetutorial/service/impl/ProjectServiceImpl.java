package com.vuetutorial.service.impl;

import com.vuetutorial.mapper.ProjectMapper;
import com.vuetutorial.entity.Project;
import com.vuetutorial.service.ProjectService;
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
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

}
