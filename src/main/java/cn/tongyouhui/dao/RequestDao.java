package cn.tongyouhui.dao;

import java.util.List;
import java.util.Map;

public interface RequestDao {
	public List<Map<String, Object>> getList(String type);
	public List<Map<String,Object>> getDetail(String type,int id);
}
