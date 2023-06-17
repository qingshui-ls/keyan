package com.vuetutorial.mapper;

import com.vuetutorial.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2023-06-15
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
