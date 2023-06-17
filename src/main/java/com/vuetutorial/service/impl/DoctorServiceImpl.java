package com.vuetutorial.service.impl;

import com.vuetutorial.entity.Doctor;
import com.vuetutorial.mapper.DoctorMapper;
import com.vuetutorial.service.DoctorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-15
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {

}
