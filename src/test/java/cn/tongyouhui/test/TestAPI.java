package cn.tongyouhui.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestAPI {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-M-d");
		System.out.println(date.format(today));
		
		String path = "E:\\tyhpics\\huwai\\2016-04-22-1461312550443\\1461312550443_0.jpg";
		System.out.println(path.substring(3).replaceAll("\\", "/"));
	}

}
