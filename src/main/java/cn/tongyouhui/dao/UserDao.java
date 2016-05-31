package cn.tongyouhui.dao;

import cn.tongyouhui.vo.User;

public interface UserDao {
	public User findByMobile(String mobile);
	public void save(User user);
}
