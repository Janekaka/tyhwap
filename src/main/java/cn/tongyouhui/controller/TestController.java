package cn.tongyouhui.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping(value="testRequest")
	public void testRequest(HttpServletRequest request){
		System.out.println("jinru testRequest Controller");
        System.out.println("getContextPath"+request.getContextPath());
        System.out.println("getRealPath"+request.getRealPath("/"));
        System.out.println("getRemoteAddr"+request.getRemoteAddr());
        System.out.println("getRemoteHost"+request.getRemoteHost());
        System.out.println("getRemoteUser"+request.getRemoteUser());
         
	}

}
