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
 * 
 * </p>
 *
 * @author baomidou
 * @since 2023-06-15
 */
@Getter
@Setter
@TableName("project")
@ApiModel(value = "Project对象", description = "")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "projectID", type = IdType.ASSIGN_ID)
    private Long projectID;

    @TableField("projecrName")
    private String projecrName;

    @TableField("projectDescribe")
    private String projectDescribe;

    @TableField("addtime")
    private Timestamp addtime;

    @TableField("doctorID")
    private Long doctorID;

    @TableField("studentID")
    private Long studentID;
}
