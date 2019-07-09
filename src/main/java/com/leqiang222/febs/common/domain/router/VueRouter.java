package com.leqiang222.febs.common.domain.router;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author LeQiang Li
 * @Date Created in 15:45 2019/7/9
 * @Description: 构建 Vue路由
 * @Modified By:
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VueRouter <T> implements Serializable {
    private static final long serialVersionUID = -3327478146308500708L;

    @JsonIgnore
    private String id;

    @JsonIgnore
    private String parentId;

    private String path;

    private String name;

    private String component;

    private String icon;

    private String redirect;

    private RouterMeta meta;

    private List<VueRouter<T>> children;

    @JsonIgnore
    private boolean hasParent = false;

    @JsonIgnore
    private boolean hasChildren = false;

    public void initChildren(){
        this.children = new ArrayList<>();
    }
}
