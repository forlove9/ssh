package cn.itcast.d_anno;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.persistence.Table;


import org.junit.Test;

/**
 * 测试：自定义注解的语法
 * @author Jie.Yuan
 *
 */
public class App_2 {
	
	private String test;
	
	@Id
	@Author(remark = "保存信息！！！", age = 19)
	public void save() throws Exception {
		// 获取注解信息： name/age/remark
		
		// 1. 先获取代表方法的Method类型;
		Class clazz = App_2.class;
		Method m = clazz.getMethod("save");
		
		// 2. 再获取方法上的注解
		Author author = m.getAnnotation(Author.class);
		// 获取输出注解信息
		System.out.println(author.authorName());
		System.out.println(author.age());
		System.out.println(author.remark());
	}
	
	
	
	@Test
	public void testMain() throws Exception {
		save();
	}
}
