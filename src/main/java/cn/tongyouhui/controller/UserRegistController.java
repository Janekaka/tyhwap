package cn.tongyouhui.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tongyouhui.service.UserService;
import cn.tongyouhui.vo.UserResult;
@Controller
//@RequestMapping(value="/user")
public class UserRegistController{

    @Resource
	private UserService userService;
    
    @RequestMapping(value="regist")
	@ResponseBody
	public UserResult execute(String mobile,String password) throws Exception{
		UserResult result = userService.regist(mobile,password);
		return result;
	}
}
