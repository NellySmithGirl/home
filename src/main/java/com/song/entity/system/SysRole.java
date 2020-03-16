package com.song.entity.system;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统角色实体
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 17:49:59
 */
@Data
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色code
     */
    private String code;

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

}