package sy.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sy.model.User;
import sy.service.UserServiceI;

public class TestMybatis {
	
	private ApplicationContext ac;
	private UserServiceI userService;

	@Before
	public void before() {
		ac = new ClassPathXmlApplicationContext(new String[] { "spring.xml", "spring-mybatis.xml" } );
		userService = (UserServiceI) ac.getBean("UserService");
		
	}
	
	@Test 
	public void test1() {
		ac = new ClassPathXmlApplicationContext(new String[] { "spring.xml", "spring-mybatis.xml" } );
		userService = (UserServiceI) ac.getBean("UserService");
		
		User u = userService.getUserById("1");
		System.out.println(u.getName());
	}
}
