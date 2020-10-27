package com.gyn.livestock.service;

import com.alibaba.fastjson.JSON;
import com.gyn.livestock.domain.bo.CfgValuePairBO;
import com.gyn.livestock.domain.po.SysConfigPO;
import com.gyn.livestock.mapper.SysConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SysConfigService {

    @Autowired
    private SysConfigMapper sysConfigMapper;

    public Map<String, String> getConfigValuePair(String cfgCode) {
        List<CfgValuePairBO> cfgValueList = getConfigValueList(cfgCode);
        if (!CollectionUtils.isEmpty(cfgValueList)) {
            return cfgValueList.stream().collect(Collectors.toMap(CfgValuePairBO::getId, CfgValuePairBO::getName));
        } else {
            return Collections.EMPTY_MAP;
        }
    }

    public List<CfgValuePairBO> getConfigValueList(String cfgCode) {
        SysConfigPO sysConfigPO = new SysConfigPO();
        sysConfigPO.setCfgCode(cfgCode);
        SysConfigPO sysConfig = sysConfigMapper.selectOne(sysConfigPO);
        if (sysConfig != null) {
            String cfgValue = sysConfig.getCfgValue();
            return JSON.parseArray(cfgValue, CfgValuePairBO.class);
        } else {
            return Collections.EMPTY_LIST;
        }
    }
}
