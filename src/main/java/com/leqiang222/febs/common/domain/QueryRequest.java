package com.leqiang222.febs.common.domain;

import lombok.Data;

/**
 * @Author LeQiang Li
 * @Date Created in 11:31 2019/7/10
 * @Description:
 * @Modified By:
 */
@Data
public class QueryRequest extends BaseDomain {
    private int pageSize = 10;
    private int pageNum = 1;

    private String sortField;
    private String sortOrder;
}
