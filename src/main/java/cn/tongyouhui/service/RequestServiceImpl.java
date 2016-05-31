package cn.tongyouhui.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tongyouhui.dao.RequestDao;
import cn.tongyouhui.vo.ListItem;
@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	private RequestDao requestDao;
	
	@Override
	public List<ListItem> getList(String type) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> mapList = requestDao.getList(type);
		List<ListItem> itemList = new ArrayList<ListItem>();
		String groupKey = type + "_group";
		
		String os = System.getProperty("os.name");
		int startIndex = 14;
		/*if(os.startsWith("win") || os.startsWith("Win")){
			startIndex = 3;		//Windows下图片文件夹为 E:\tyhpics\,图片文件夹会放到项目目录下, webapp/tyhpics
		}else{
			startIndex = 14;   //Linux下图片文件夹为 /home/ravenwu/tyhpics/,图片文件夹会放到项目目录下, webapp/tyhpics
		}*/
		for(Map<String,Object> map : mapList){
			String old_suoluetu = (String)map.get("suoluetu");
			String new_suoluetu = "";
			/*if(!old_suoluetu.equals("")){
				if(startIndex==3){
					new_suoluetu = old_suoluetu.substring(startIndex).replace("\\", "/");
				}
				if(startIndex==14){
					new_suoluetu = old_suoluetu.substring(startIndex);
				}
			}*/
			if(old_suoluetu.length()>14){
				new_suoluetu = old_suoluetu.substring(startIndex);
			}
			ListItem item = new ListItem((Integer)map.get("id"),(String)map.get("name"),(String)map.get("jianjie"),(String)map.get("price"),(String)map.get("oldprice"),(String)map.get("tags"),
					(String)map.get(groupKey),(Integer)map.get("weight"),new_suoluetu,type);
			itemList.add(item);
		}
		return itemList;
	}

	@Override
	public ListItem getDetail(String type, int id) {
		// TODO Auto-generated method stub
		
		List<Map<String,Object>> mapList = requestDao.getDetail(type,id);
		Map<String,Object> map = mapList.get(0);		//根据id只能查出一行记录
		
		String groupKey = type + "_group";
		String detailKey1 = "",detailKey2 = "",detailKey3 = "",detailKey4 = "";
		
		if("menpiao".equals(type) || "yanchu".equals(type)){
			detailKey1 = "introduction";
			detailKey2 = "details";
			detailKey3 = "notice";
			detailKey4 = "process";
		}
		if("luxian".equals(type)){
			detailKey1 = "feature";
			detailKey2 = "xingcheng";
			detailKey3 = "notice";
			detailKey4 = "attention";
		}
		if("qinzi".equals(type) || "huwai".equals(type)){
			detailKey1 = "subject";
			detailKey2 = "content";
			detailKey3 = "notice";
			detailKey4 = "process";
		}
		int startIndex = 14;
		String old_suoluetu = (String)map.get("suoluetu");
		String new_suoluetu = "";
		if(old_suoluetu.length()>14){
			new_suoluetu = old_suoluetu.substring(startIndex);
		}
		
		
		ListItem item = new ListItem((Integer)map.get("id"),(String)map.get("name"),(String)map.get("jianjie"),(String)map.get("price"),(String)map.get("oldprice"),(String)map.get("tags"),
				(String)map.get(groupKey),(Integer)map.get("weight"),new_suoluetu,type,(String)map.get(detailKey1),(String)map.get(detailKey2),(String)map.get(detailKey3),(String)map.get(detailKey4),
				(String)map.get("pics_dir"));
		
		return item;
	}

}
