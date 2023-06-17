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
@TableName("todolist")
@ApiModel(value = "Todolist对象", description = "")
public class Todolist implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "taskId", type = IdType.ASSIGN_ID)
    private Long taskId;

    @TableField("taskName")
    private String taskName;

    @TableField("addTime")
    private Timestamp addTime;

    @TableField("taskDescribe")
    private String taskDescribe;

    @ApiModelProperty("0表示为完成，1表示进行中，2表示已完成")
    @TableField("state")
    private Integer state;

    @TableField("projectId")
    private Long projectId;

    @TableField("studentId")
    private String studentId;
}
