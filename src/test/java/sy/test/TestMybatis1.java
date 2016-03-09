package sy.test;

import java.util.List;

import org.apache.log4j.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import sy.model.User;
import sy.service.UserServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" } )
public class TestMybatis1 {
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(TestMybatis1.class);
	
	private UserServiceI userService;
	
	public UserServiceI getUserService() {
		return userService;
	}


	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	@Test
	public void test1() {
		User u = userService.getUserById("0");
		//System.out.println(u.getName());
		logger.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void test2() {
		List<User> l = userService.getAll();
		//System.out.println(u.getName());
		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
	}

	
}
