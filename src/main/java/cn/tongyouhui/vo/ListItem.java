package cn.tongyouhui.vo;

public class ListItem {
	private int id;
	private String name;
	private String jianjie;
	private String price;
	private String oldprice;
	private String tags;
	private String group;
	private int weight;
	private String suoluetu;
	private String type;
	//以下项目在详情页才有
	private String introduction;
	private String details;
	private String notice;
	private String process;
	private String pics_dir;
	

	public ListItem(int id, String name, String jianjie, String price,
			String oldprice, String tags, String group, int weight,
			String suoluetu,String type) {
		super();
		this.id = id;
		this.name = name;
		this.jianjie = jianjie;
		this.price = price;
		this.oldprice = oldprice;
		this.tags = tags;
		this.group = group;
		this.weight = weight;
		this.suoluetu = suoluetu;
		this.type = type;
	}
	
	public ListItem(int id, String name, String jianjie, String price,
			String oldprice, String tags, String group, int weight,
			String suoluetu, String type, String introduction, String details,
			String notice, String process, String pics_dir) {
		super();
		this.id = id;
		this.name = name;
		this.jianjie = jianjie;
		this.price = price;
		this.oldprice = oldprice;
		this.tags = tags;
		this.group = group;
		this.weight = weight;
		this.suoluetu = suoluetu;
		this.type = type;
		this.introduction = introduction;
		this.details = details;
		this.notice = notice;
		this.process = process;
		this.pics_dir = pics_dir;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getPics_dir() {
		return pics_dir;
	}

	public void setPics_dir(String pics_dir) {
		this.pics_dir = pics_dir;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJianjie() {
		return jianjie;
	}
	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getOldprice() {
		return oldprice;
	}
	public void setOldprice(String oldprice) {
		this.oldprice = oldprice;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getSuoluetu() {
		return suoluetu;
	}
	public void setSuoluetu(String suoluetu) {
		this.suoluetu = suoluetu;
	}
}
