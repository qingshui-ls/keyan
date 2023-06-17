package com.vuetutorial.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Timestamp;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author baomidou
 * @since 2023-06-15
 */
@Getter
@Setter
@TableName("doctor")
@ApiModel(value = "Doctor对象", description = "用户表")
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "doctorId", type = IdType.AUTO)
    private Long doctorId;

    @ApiModelProperty("用户名")
    @TableField("doctorName")
    private String doctorName;

    @ApiModelProperty("新增时间")
    @TableField("addTime")
    private Timestamp addTime;

    @ApiModelProperty("性别")
    @TableField("sex")
    private String sex;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("角色")
    @TableField("role")
    private String role;

    @ApiModelProperty("头像")
    @TableField("avatar")
    private String avatar;
}
