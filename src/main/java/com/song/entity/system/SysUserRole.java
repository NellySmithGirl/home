package com.song.entity.system;

import lombok.Data;

import java.io.Serializable;

/**
 * 系统用户角色实体
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 18:00:27
 */
@Data
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 用户id
     */
    private Integer userId;


}