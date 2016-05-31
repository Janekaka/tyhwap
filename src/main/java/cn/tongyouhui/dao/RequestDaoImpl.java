package cn.tongyouhui.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class RequestDaoImpl implements RequestDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> getList(String type) {
		// TODO Auto-generated method stub
		String sql = "select id,name,jianjie,price,oldprice,"+type+"_group,tags,weight,suoluetu from "+type+" order by weight desc";
		
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> getDetail(String type, int id) {
		// TODO Auto-generated method stub
		String sql = "";
		if("menpiao".equals(type) || "yanchu".equals(type) || "zhuanxiang".equals(type)){
			sql = "select id,name,jianjie,price,oldprice,"+type+"_group,tags,weight,suoluetu,introduction,details,notice,process,pics_dir from "+type+" where id="+id;
		}
		if("luxian".equals(type)){
			sql = "select id,name,jianjie,price,oldprice,"+type+"_group,tags,weight,suoluetu,feature,xingcheng,notice,attention,pics_dir from "+type+" where id="+id;
		}
		if("qinzi".equals(type) || "huwai".equals(type)){
			sql = "select id,name,jianjie,price,oldprice,"+type+"_group,tags,weight,suoluetu,subject,content,notice,process,pics_dir from "+type+" where id="+id;
		}
		return jdbcTemplate.queryForList(sql);
	}

}
