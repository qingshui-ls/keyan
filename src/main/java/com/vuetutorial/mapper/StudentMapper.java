package com.vuetutorial.mapper;

import com.vuetutorial.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2023-06-15
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
