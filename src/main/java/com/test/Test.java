package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mapper.LogMapper;
import com.pojo.LogInfo;

public class Test {
	public static void main(String[] args) throws IOException {

//		一.MyBatis 接口绑定方案及多参数传递
//		1.作用:实现创建一个接口后,把mapper.xml由mybatis生成接口的实现类,通过调用接口对象就可以获取mapper.xml中编写的sql.
//		 1.1 接口+xml---->生成接口实现类
//		2.后面mybatis 和spring 整合时使用的是这个方案.
//		3.实现步骤:
//			3.1 创建一个接口
//				3.1.1 接口包名和接口名与mapper.xml中<mapper>namespace相同
//				3.1.2 接口中方法名和mapper.xml 标签的id 属性相同
//			3.2 在mybatis.xml 中使用<package>进行扫描接口和mapper.xml
//		4.代码实现步骤:
//			4.1 在mybatis.xml中<mappers>下使用<package>
//			4.2 在com.bjsxt.mapper下新建接口
//			4.3 在com.bjsxt.mapper新建一个LogMapper.xml
//				4.3.1 namespace 必须和接口全限定路径(包名+类名)一致
//				4.3.2 id 值必须和接口中方法名相同
//				4.3.3 如果接口中方法为多个参数,可以省略parameterType
//		5.多参数实现办法
//			5.1 在接口中声明方法
//			5.2 在mapper.xml 中添加
//				5.2.1 #{}中使用0,1,2 或param1,param2
//		6,可以使用注解方式
//			6.1 在接口中声明方法
//			6.2 在mapper.xml 中添加
//				6.2.1 #{} 里面写@Param(“内容”)参数中的内容
		
		
		InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();

		System.out.println("------------------------------getMapper");
		LogMapper logMapper = session.getMapper(LogMapper.class);
		List<LogInfo> selAll = logMapper.selAll();
		for (LogInfo logInfo : selAll) {
			System.out.println(logInfo);
		}
		System.out.println("------------------------------selByAccOutAccIn1");
		List<LogInfo> selAll1 = logMapper.selByAccOutAccIn1("1", "2");
		for (LogInfo logInfo : selAll1) {
			System.out.println(logInfo);
		}
		System.out.println("------------------------------selByAccOutAccIn2");
		List<LogInfo> selAll2 = logMapper.selByAccOutAccIn2("1", "2");
		for (LogInfo logInfo : selAll2) {
			System.out.println(logInfo);
		}
		System.out.println("------------------------------selByAccOutAccIn3");
		List<LogInfo> selAll3 = logMapper.selByAccOutAccIn3("1", "2");
		for (LogInfo logInfo : selAll3) {
			System.out.println(logInfo);
		}

		session.close();
	}

}
