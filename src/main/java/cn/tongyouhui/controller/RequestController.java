package cn.tongyouhui.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.tongyouhui.service.RequestService;
import cn.tongyouhui.vo.ListItem;

@Controller
public class RequestController {
	@Autowired
	private RequestService requestService;
	
	@RequestMapping(value="getlist")
	public String getList(HttpServletRequest request,ModelMap model){
		
		String type = request.getParameter("type").trim();  //用来区分门票、路线、演出、亲子还是户外
		System.out.println("jinru "+type+" getlist Controller");
		
		List<ListItem> list = requestService.getList(type);
		System.out.println(list.size());
		
		String redirectPage = "";
		if("menpiao".equals(type)){
			redirectPage = "list_menpiao";
		}
		if("yanchu".equals(type)){
			redirectPage = "list";
		}
		if("luxian".equals(type)){
			redirectPage = "list_luxian";
		}
		if("qinzi".equals(type) || "huwai".equals(type)){
			redirectPage = "list";
		}
		if("zhuanxiang".equals(type)){
			redirectPage = "list_zhuanxiang";
		}
		
		model.addAttribute("list", list);
		
		return redirectPage;
	}
	
	@RequestMapping(value="getdetail")
	public String getDetail(HttpServletRequest request,ModelMap model){
		
		String type = request.getParameter("type").trim();  //用来区分门票、路线、演出、亲子还是户外
		String idStr = request.getParameter("id").trim();  //id
		System.out.println("jinru "+type+" getDetail Controller");
		int id = 0;
		try{
			id = Integer.parseInt(idStr);
		}catch(Exception e){
			e.printStackTrace();
			id = 0;
		}
		
		ListItem item = requestService.getDetail(type, id);
		model.addAttribute("item", item);
		
		String redirectPage = "";
		
		if("menpiao".equals(type)){
			redirectPage = "detail";
		}
		if("yanchu".equals(type) || "zhuanxiang".equals(type)){
			redirectPage = "detail_piaowu";
		}
		if("luxian".equals(type)){
			redirectPage = "detail_luxian";
		}
		if("qinzi".equals(type) || "huwai".equals(type)){
			redirectPage = "detail_qinzi";
		}
		
		return redirectPage;
	}

}
