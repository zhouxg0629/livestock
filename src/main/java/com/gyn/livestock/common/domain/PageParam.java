package com.gyn.livestock.common.domain;

import lombok.Data;

@Data
public class PageParam {
    private Integer pageNumber = 1;
    private Integer pageSize = 20;
    private String orderByClause;
}
