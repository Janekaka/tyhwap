package cn.tongyouhui.service;

public interface UploadMenpiaoService {
	
	public int uploadMenpiao(String type,String name,String jianjie,String price,String oldprice,String group,String tags,int weight,String introduction,
			String details,String notice,String process,String picsdir,String suoluetu);

}
