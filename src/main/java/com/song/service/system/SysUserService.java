package com.song.service.system;

import com.song.entity.system.SysUser;
import com.song.service.BaseService;

import java.util.HashMap;
import java.util.List;

/**
 * 系统用户Service
 *
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 17:36:32
 */
public interface SysUserService extends BaseService<SysUser, Long> {

    Integer addUser(SysUser user);

    String sign(SysUser user);

    List<SysUser> findByParam(HashMap<String, Object> map);

    SysUser findByUserId(Long id);

    Integer delByUserId(Long id);

    void update(SysUser user);

    String updateAccount(String loginName, String oldPassword, String newPassword1, String newPassword2);
}
