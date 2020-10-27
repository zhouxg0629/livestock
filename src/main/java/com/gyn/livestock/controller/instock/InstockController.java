package com.gyn.livestock.controller.instock;

import com.gyn.livestock.common.domain.Page;
import com.gyn.livestock.domain.query.QueryInstockParam;
import com.gyn.livestock.domain.vo.InstockVO;
import com.gyn.livestock.service.InstockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instock")
@Slf4j
public class InstockController {

    @Autowired
    private InstockService instockService;

    @GetMapping("/listByPage")
    public Page<InstockVO> getListByPage(QueryInstockParam param) {
        return instockService.getInstockList(param);
    }
}
