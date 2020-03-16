package com.song.entity.system;

import lombok.Data;

import java.io.Serializable;

/**
 * 系统菜单实体
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 17:54:09
 */
@Data
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单顺序
     */
    private String order;

    /**
     * 父级id
     */
    private Integer parentId;

    /**
     * 菜单类型
     */
    private String type;

    /**
     * 菜单地址
     */
    private String url;


}