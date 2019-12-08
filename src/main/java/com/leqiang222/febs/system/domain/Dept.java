package com.leqiang222.febs.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 
 *
 * @author leqiang222
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_dept")
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
            @TableId(value = "DEPT_ID", type = IdType.AUTO)
    private Long deptId;

    /**
     * 上级部门ID
     */
        @TableField("PARENT_ID")
    private Long parentId;

    /**
     * 部门名称
     */
        @TableField("DEPT_NAME")
    private String deptName;

    /**
     * 排序
     */
        @TableField("ORDER_NUM")
    private Double orderNum;

    /**
     * 创建时间
     */
        @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
        @TableField("MODIFY_TIME")
    private LocalDateTime modifyTime;


}
