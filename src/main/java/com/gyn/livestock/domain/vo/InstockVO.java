package com.gyn.livestock.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Data
public class InstockVO {
    private BigInteger id;
    private String livestockTypeName;
    private String imageUrl;
    private String instockLocationName;
    private String employeeName;
    private long buyTime;
    private BigDecimal buyAmount;
    private String buyLocationName;
    private String buyer;
    private String sellerInfo;
    private String remark;
}
