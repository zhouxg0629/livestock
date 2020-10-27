package com.gyn.livestock.domain.query;

import com.gyn.livestock.common.domain.PageParam;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class QueryInstockParam extends PageParam {

    private BigInteger id;

    private Integer livestockType;

    private Date startBuyTime;

    private Date endBuyTime;

    private Integer instockLocationId;

    private Integer buyLocationId;

    private Integer employeeId;
}
