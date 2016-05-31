package cn.tongyouhui.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.tongyouhui.service.RequestService;
import cn.tongyouhui.vo.ListItem;

public class TestRequestController {
	@Autowired
	private RequestService requestService;

	@Test
	public void test() {
		//fail("Not yet implemented");
		List<ListItem> list = requestService.getList("luxian");
		System.out.println(list.size());
	}

}
