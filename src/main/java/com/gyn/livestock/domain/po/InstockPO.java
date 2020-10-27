package com.gyn.livestock.domain.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Table(name = "instock")
@Data
public class InstockPO {

    @Column(name = "id")
    private BigInteger id;
    private Integer livestockSpecies;
    private Integer livestockType;
    private String imageUrl;
    private Integer instockLocationId;
    private Integer employeeId;
    private Date buyTime;
    private BigDecimal buyAmount;
    private Integer buyLocationId;
    private String buyer;
    private String sellerInfo;
    private String remark;
    private String createUser;
    private Date createTime;
    private String updateUser;
    private Date updateTime;
}
