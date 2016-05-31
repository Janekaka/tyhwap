package cn.tongyouhui.service;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tongyouhui.dao.UserDao;
import cn.tongyouhui.util.MD5Util;
import cn.tongyouhui.vo.User;
import cn.tongyouhui.vo.UserResult;
@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;
	
	@Override
	public UserResult checkLogin(String mobile, String password) throws Exception {
		UserResult result = new UserResult();
		User user = userDao.findByMobile(mobile);
		String md5 = MD5Util.md5(password);
		if(user==null){
			result.setStatus(1);
			result.setMsg("用户不存在");
		}
		else if(!user.getPassword().equals(md5)){
			result.setStatus(2);
			result.setMsg("密码不正确");
		}
		else{
			result.setStatus(0);
			result.setMsg("用户名和密码正确");
			result.setData(user.getUser_id());//返回用户ID
		}
		return result;
	}
	public UserResult regist(String mobile, String password) throws Exception{
		UserResult result = new UserResult();
		User has_user = userDao.findByMobile(mobile);
		if(has_user!=null){
			result.setStatus(1);
			result.setMsg("用户名已被占用");
			return result;
		}
		User user = new User();
		user.setMobile(mobile);
		String md5_pwd = MD5Util.md5(password);
		user.setPassword(md5_pwd);
		//获取系统时间
		String time=new SimpleDateFormat("yyyy-MM-dd-HH:mm").format(Calendar.getInstance().getTime());
		user.setLoginTime(time);
		userDao.save(user);
		result.setStatus(0);
		result.setMsg("注册成功");
		return result;

	}

}
