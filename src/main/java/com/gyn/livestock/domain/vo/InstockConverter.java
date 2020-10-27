package com.gyn.livestock.domain.vo;

import com.github.pagehelper.PageInfo;
import com.gyn.livestock.common.domain.Page;
import com.gyn.livestock.domain.po.InstockPO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InstockConverter {

    public static Page<InstockVO> convert(List<InstockPO> instockList,
                                          Map<String, String> livestockTypeMap,
                                          Map<String, String> employeeMap,
                                          Map<String, String> instockLocationMap,
                                          Map<String, String> buyLocationMap) {
        PageInfo<InstockPO> instockPOByPage = new PageInfo<>(instockList);
        Page<InstockVO> instockVOByPage = new Page<>();
        instockVOByPage.setPageNumber(instockPOByPage.getPageNum());
        instockVOByPage.setPageSize(instockPOByPage.getSize());
        instockVOByPage.setTotalCount(instockPOByPage.getTotal());
        instockVOByPage.setPages(instockPOByPage.getPages());

        List<InstockVO> instockVOList = new ArrayList<>();
        for (InstockPO instockPO : instockPOByPage.getList()) {
            InstockVO instockVO = new InstockVO();
            instockVO.setId(instockPO.getId());
            String livestockTypeName = livestockTypeMap.get(instockPO.getLivestockType() + "");
            if (!StringUtils.isEmpty(livestockTypeName)) {
                instockVO.setLivestockTypeName(livestockTypeName);
            }
            String employeeName = employeeMap.get(instockPO.getEmployeeId() + "");
            if(!StringUtils.isEmpty(employeeName)){
                instockVO.setEmployeeName(employeeName);
            }
            String instockLocationName = instockLocationMap.get(instockPO.getInstockLocationId() + "");
            if(!StringUtils.isEmpty(instockLocationName)){
                instockVO.setInstockLocationName(instockLocationName);
            }
            String buyLocationName = buyLocationMap.get(instockPO.getBuyLocationId() + "");
            if(!StringUtils.isEmpty(buyLocationName)){
                instockVO.setBuyLocationName(buyLocationName);
            }
            instockVO.setImageUrl(instockPO.getImageUrl());
            instockVO.setBuyTime(instockPO.getBuyTime().getTime());
            instockVO.setBuyAmount(instockPO.getBuyAmount());
            instockVO.setBuyer(instockPO.getBuyer());
            instockVO.setSellerInfo(instockPO.getSellerInfo());
            instockVO.setRemark(instockPO.getRemark());
            instockVOList.add(instockVO);
        }
        instockVOByPage.setData(instockVOList);
        return instockVOByPage;
    }
}
