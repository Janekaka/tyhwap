package cn.tongyouhui.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tongyouhui.service.UserService;
import cn.tongyouhui.vo.UserResult;
@Controller
//@RequestMapping(value="/user")
public class UserLoginController {
	
	@Resource//注入
	private UserService userService;
	
	@RequestMapping(value="login")
	@ResponseBody
	public UserResult execute(String mobile,String password) throws Exception{
		UserResult result = userService.checkLogin(mobile, password);
		return result;
	}	
}
