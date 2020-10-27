package com.gyn.livestock.domain.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_config")
@Data
public class SysConfigPO {

    @Column(name = "id")
    private Integer id;
    private String cfgCode;
    private String cfgName;
    private String cfgDesc;
    private String cfgValue;
    private Integer cfgState;
    private String createUser;
    private Date createTime;
    private String updateUser;
    private Date updateTime;
}
