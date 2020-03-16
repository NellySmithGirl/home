package com.song.entity.system;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户实体
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 17:36:32
 */
@Data
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登录次数
     */
    private Integer count;

    /**
     * 创建时间
     */
    private Date creatTime;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 上次登录时间
     */
    private String lastLoginTime;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 登录时间
     */
    private Date loginTime;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 状态
     */
    private String status;

    /**
     * 用户姓名
     */
    private String username;



}