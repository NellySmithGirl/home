package com.song.entity.system;

import lombok.Data;

import java.io.Serializable;

/**
 * 系统角色菜单实体
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 18:07:42
 */
@Data
public class SysRoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 权限id
     */
    private Integer menuId;

    /**
     * 角色id
     */
    private Integer roleId;


}