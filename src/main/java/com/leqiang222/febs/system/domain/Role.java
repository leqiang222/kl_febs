package com.leqiang222.febs.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.leqiang222.febs.common.converter.TimeConverter;
import com.leqiang222.febs.common.domain.BaseDomain;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @Author LeQiang Li
 * @Date Created in 11:01 2019/7/8
 * @Description:
 * @Modified By:
 */
@Data
@TableName("t_role")
@Excel("角色信息表")
public class Role extends BaseDomain {
    @TableId(value = "ROLE_ID", type = IdType.AUTO)
    private Long roleId;

    @NotBlank(message = "{required}")
    @Size(max = 10, message = "{noMoreThan}")
    @ExcelField(value = "角色名称")
    private String roleName;

    @Size(max = 50, message = "{noMoreThan}")
    @ExcelField(value = "角色描述")
    private String remark;

    @ExcelField(value = "创建时间", writeConverter = TimeConverter.class)
    private Date createTime;

    @ExcelField(value = "修改时间", writeConverter = TimeConverter.class)
    private Date modifyTime;

    private transient String createTimeFrom;
    private transient String createTimeTo;
    private transient String menuId;
}
