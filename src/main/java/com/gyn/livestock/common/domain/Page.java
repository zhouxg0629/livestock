package com.gyn.livestock.common.domain;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {
    private int pageNumber;
    private int pageSize;
    private long totalCount;
    private Integer pages;
    private List<T> data;
}
