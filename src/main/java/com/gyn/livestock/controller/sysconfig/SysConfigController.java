package com.gyn.livestock.controller.sysconfig;

import com.gyn.livestock.common.domain.Page;
import com.gyn.livestock.domain.bo.CfgValuePairBO;
import com.gyn.livestock.domain.query.QueryInstockParam;
import com.gyn.livestock.domain.vo.InstockVO;
import com.gyn.livestock.service.InstockService;
import com.gyn.livestock.service.SysConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sysConfig")
@Slf4j
public class SysConfigController {

    @Autowired
    private SysConfigService sysConfigService;

    @GetMapping("/listByCode")
    public List<CfgValuePairBO> getListByPage(String cfgCode) {
        return sysConfigService.getConfigValueList(cfgCode);
    }
}
