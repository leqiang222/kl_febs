package com.leqiang222.febs.common.domain.router;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author LeQiang Li
 * @Date Created in 15:46 2019/7/9
 * @Description: Vue路由 Meta
 * @Modified By:
 */
@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RouterMeta implements Serializable {
    private static final long serialVersionUID = 5499925008927195914L;

    private Boolean closeable;

    private Boolean isShow;
}
