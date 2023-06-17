package com.vuetutorial.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("document")
@ApiModel(value = "Document对象", description = "")
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "docID", type = IdType.ASSIGN_ID)
    private Long docID;

    @TableField("docName")
    private String docName;

    @TableField("studentID")
    private Long studentID;

    @TableField("studentName")
    private String studentName;

    @TableField("taskID")
    private Long taskID;

    @TableField("docPath")
    private String docPath;
}
