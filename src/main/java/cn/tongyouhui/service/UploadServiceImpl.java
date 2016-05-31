package cn.tongyouhui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tongyouhui.dao.UploadMenpiaoDao;

@Service
public class UploadServiceImpl implements UploadMenpiaoService {
	
	@Autowired
	private UploadMenpiaoDao uploadDao;

	@Override
	public int uploadMenpiao(String type,String name, String jianjie, String price,
			String oldprice, String group, String tags, int weight,
			String introduction, String details, String notice, String process,
			String picsdir, String suoluetu) {
		// TODO Auto-generated method stub
		return uploadDao.uploadMenpiao(type,name, jianjie, price, oldprice, group, tags, weight, introduction, details, notice, process, picsdir, suoluetu);
	}

	

}
