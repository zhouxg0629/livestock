package com.gyn.livestock.service;

import com.github.pagehelper.PageHelper;
import com.gyn.livestock.common.domain.Page;
import com.gyn.livestock.domain.po.InstockPO;
import com.gyn.livestock.domain.query.QueryInstockParam;
import com.gyn.livestock.domain.vo.InstockConverter;
import com.gyn.livestock.domain.vo.InstockVO;
import com.gyn.livestock.mapper.InstockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class InstockService {

    @Autowired
    private InstockMapper instockMapper;

    @Autowired
    private SysConfigService sysConfigService;

    public Page<InstockVO> getInstockList(QueryInstockParam param){
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        Example example = new Example(InstockPO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",param.getId())
                .andEqualTo("livestockType",param.getLivestockType())
                .andEqualTo("employeeId",param.getEmployeeId())
                .andEqualTo("instockLocationId",param.getInstockLocationId())
                .andEqualTo("buyLocationId",param.getBuyLocationId())
                .andGreaterThanOrEqualTo("buyTime",param.getStartBuyTime())
                .andLessThanOrEqualTo("buyTime",param.getEndBuyTime());
        if(!StringUtils.isEmpty(param.getOrderByClause())){
            example.setOrderByClause(param.getOrderByClause());
        }
        List<InstockPO> instockList = instockMapper.selectByExample(example);

        Map<String,String> livestockTypeMap = sysConfigService.getConfigValuePair("livestockType");
        Map<String,String> employeeMap = sysConfigService.getConfigValuePair("employee");
        Map<String,String> instockLocationMap = sysConfigService.getConfigValuePair("instockLocation");
        Map<String,String> buyLocationMap = sysConfigService.getConfigValuePair("buyLocation");

        return InstockConverter.convert(instockList,livestockTypeMap,employeeMap,instockLocationMap,buyLocationMap);
    }
}
