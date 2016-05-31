package cn.tongyouhui.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.tongyouhui.service.UploadMenpiaoService;

@Controller
public class UploadController {
	@Autowired
	private UploadMenpiaoService uploadService;
	
	@RequestMapping(value="upload")
	public String uploadMenpiao(@RequestParam(value = "files") MultipartFile[] files, HttpServletRequest request,ModelMap model){
		 
		String name = request.getParameter("name").trim();
		String jianjie = request.getParameter("jianjie").trim();
		String price = request.getParameter("price").trim();
		String oldprice = request.getParameter("oldprice").trim();
		String group = request.getParameter("group").trim();
		String[] tags = request.getParameterValues("tags");
		String weight = request.getParameter("weight").trim();
		String introduction = request.getParameter("editor01");
		String details = request.getParameter("editor02");
		String notice = request.getParameter("editor03");
		String process = request.getParameter("editor04");
		
		String type = request.getParameter("type");  //用来区分上传的门票、路线、演出、亲子还是户外
		
		System.out.println("jinru "+type+"upload Controller");
		
		StringBuffer sb = new StringBuffer();
		int tagsArrayLength = tags.length;
		for(int i=0;i<tagsArrayLength;i++){
			if(i==tagsArrayLength-1){
				sb.append(tags[i]);
			}else{
				sb.append(tags[i]).append(",");
			}	
		}
		int weightInt = 0;
		try{
			weightInt = Integer.parseInt(weight);
		}catch(Exception e){
			e.printStackTrace();
			weightInt = 0;
		}
		
		
		String os = System.getProperty("os.name");
		String path  = "";
		String suoluetuPath = "";
		//获取图片文件夹的路径
		if(os.startsWith("win") || os.startsWith("Win")){
			path = "E:\\tyhpics\\"+type+"\\";
		}else{
			path = "/home/ravenwu/tyhpics/"+type+"/";
		}
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String dir = date.format(today) + "-" + System.currentTimeMillis() + File.separator;  //日期+当前时刻作为此次上传的图片所在文件夹名称，例如2016-04-14-1460614679674
		String picsdir = path + dir;   //图片文件夹的完整路径
		File outputDir = new File(picsdir);
		if(!outputDir.exists() || !outputDir.isDirectory()){
			outputDir.mkdir();
		}
		try{
			for(int i=0;i<files.length;i++){
				MultipartFile file = files[i];
				if(file != null){
					String fileName = file.getOriginalFilename();
					String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
					String outputName = System.currentTimeMillis() + "_" + i + suffix;
					if(i==0){  //第一个是上传的缩略图
						suoluetuPath = path + dir + outputName;
					}
					String output = path + dir + outputName;
					System.out.println(output);
					file.transferTo(new File(output));  //将文件转存
				}		
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("保存文件出错");
		}
		
		System.out.println("缩略图地址" + suoluetuPath);
		
		int count = uploadService.uploadMenpiao(type,name, jianjie, price, oldprice, group, sb.toString(), weightInt, introduction, details, notice, process, picsdir, suoluetuPath);
		
		String redirectAddress = type+"shch.html";
		model.addAttribute("address", redirectAddress);
		System.out.println("count: "+count);
		if(count > 0){
			return "success";
		}else{
			return "failure";
		}
	}

}
