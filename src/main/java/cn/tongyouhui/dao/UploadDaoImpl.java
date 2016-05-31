package cn.tongyouhui.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UploadDaoImpl implements UploadMenpiaoDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int uploadMenpiao(String type,String name, String jianjie, String price,
			String oldprice, String group, String tags, int weight,
			String introduction, String details, String notice, String process,
			String picsdir, String suoluetu) {
		// TODO Auto-generated method stub
		String sql = "";
		if("menpiao".equals(type)){
			sql = "insert into menpiao (name,jianjie,price,oldprice,menpiao_group,tags,weight,suoluetu,introduction,details,notice,process,pics_dir) values "
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		}
		if("luxian".equals(type)){
			sql = "insert into luxian (name,jianjie,price,oldprice,luxian_group,tags,weight,suoluetu,feature,xingcheng,notice,attention,pics_dir) values "
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		}
		if("yanchu".equals(type)){
			sql = "insert into yanchu (name,jianjie,price,oldprice,yanchu_group,tags,weight,suoluetu,introduction,details,notice,process,pics_dir) values "
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		}
		if("qinzi".equals(type)){
			sql = "insert into qinzi (name,jianjie,price,oldprice,qinzi_group,tags,weight,suoluetu,subject,content,notice,process,pics_dir) values "
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		}
		if("huwai".equals(type)){
			sql = "insert into huwai (name,jianjie,price,oldprice,huwai_group,tags,weight,suoluetu,subject,content,notice,process,pics_dir) values "
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		}
		
			
		int count = jdbcTemplate.update(sql, new Object[]{name,jianjie,price,oldprice,group,tags,weight,suoluetu,introduction,details,notice,process,picsdir});
		return count;
	}

}
