package cn.tongyouhui.service;

import java.util.List;

import cn.tongyouhui.vo.ListItem;

public interface RequestService {
	
	public List<ListItem> getList(String type);
	public ListItem getDetail(String type,int id);

}
