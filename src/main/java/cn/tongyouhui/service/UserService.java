package cn.tongyouhui.service;

import cn.tongyouhui.vo.UserResult;

public interface UserService {

	public UserResult checkLogin(String mobile, String password)throws Exception;

	public UserResult regist(String mobile, String password)throws Exception;
}
