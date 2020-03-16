package com.song.service.impl.system;

import com.song.entity.system.SysUser;
import com.song.entity.system.SysUserRole;
import com.song.mapper.BaseMapper;
import com.song.mapper.system.SysUserMapper;
import com.song.mapper.system.SysUserRoleMapper;
import com.song.service.impl.BaseServiceImpl;
import com.song.service.system.SysUserService;
import com.song.util.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * 系统用户ServiceImpl
 *
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 17:36:32
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, Long> implements SysUserService {

	private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

	private HashMap<String,Object> map;

	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;

	@Override
	public BaseMapper<SysUser, Long> getMapper() {
		return sysUserMapper;
	}

	@Override
	public Integer addUser(SysUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setCreatTime(new Date());
		user.setMobile(user.getLoginName());
		user.setCount(0);
		user.setStatus("1");
		sysUserMapper.save(user);
		SysUserRole userRole = new SysUserRole();
		userRole.setRoleId(2);
		userRole.setUserId(Integer.parseInt(user.getId().toString()));
		return sysUserRoleMapper.save(userRole);
	}

	@Override
	public String sign(SysUser user) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("loginName",user.getLoginName());
		SysUser sysUser = sysUserMapper.findSelective(map);
		if (sysUser==null){
			return "用户不存在!";
		}
		if (!bCryptPasswordEncoder.matches(user.getPassword(),sysUser.getPassword() )){
			return "密码错误!";
		}
		map.clear();
		Date date = new Date();
		if (sysUser.getLoginTime()!=null){
			map.put("lastLoginTime",sysUser.getLoginTime());
			map.put("loginTime",date);
		}else {
			map.put("lastLoginTime",date);
			map.put("loginTime",date);
		}
		Integer integer = new Integer(1);
		map.put("count",sysUser.getCount()+integer);
		map.put("id",sysUser.getId());
		sysUserMapper.updateSelective(map);
		return "登录成功!";
	}

	@Override
	public List<SysUser> findByParam(HashMap<String, Object> map) {
		return sysUserMapper.listSelective(map);
	}

	@Override
	public SysUser findByUserId(Long id) {
		return sysUserMapper.findByPrimary(id);
	}

	@Override
	public Integer delByUserId(Long id) {
		return sysUserMapper.delByUserId(id);
	}

	@Override
	public void update(SysUser user) {
		sysUserMapper.update(user);
	}

	@Override
	public String updateAccount(String loginName, String oldPassword, String newPassword1, String newPassword2) {
		if (!newPassword1.equals(newPassword2)){
			return "两次密码不一致!";
		}
		HashMap<String, Object> map = new HashMap<>();
		map.put("loginName",loginName);
		SysUser sysUser = sysUserMapper.findSelective(map);
		if (sysUser!=null){
			SysUser user = sysUserMapper.findByPrimary(sysUser.getId());
			if (!bCryptPasswordEncoder.matches(user.getPassword(),user.getPassword() )){
				return "原密码错误!";
			}
			this.map.put("password",bCryptPasswordEncoder.encode(newPassword1));
			this.map.put("id",sysUser.getId());
			sysUserMapper.updateSelective(this.map);
		}
		return "修改成功!";
	}

}