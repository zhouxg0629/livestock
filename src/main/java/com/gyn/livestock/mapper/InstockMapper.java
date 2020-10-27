package com.gyn.livestock.mapper;

import com.gyn.livestock.domain.po.InstockPO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface InstockMapper extends Mapper<InstockPO> {
}
