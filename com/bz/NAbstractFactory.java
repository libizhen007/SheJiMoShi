package com.bz;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;

/**
	抽象工厂模式，例子：使用反射和抽象工厂切换数据库
	提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 */
public class NAbstractFactory {

	public static void main(String[] args) throws Exception {
		
		//创建解析器工厂
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		//创建解析器
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		//解析xml
		Document document = builder.parse("src/com/bz/NDatabaseConfig.xml");   //这里的这个Document是w3c的包下的
		
		String daoName = document.getElementsByTagName("database").item(0).getTextContent();
		
		//通过反射
		Class concreteClass = Class.forName(daoName);
		IDao dao = (IDao) concreteClass.newInstance();
		System.out.println(dao.createDepartment(10));
		System.out.println(dao.createUser(10));
	}

}

class User{
	
}
class Department{
	
}

//总抽象工厂
interface IDao{
	User createUser(int id);
	Department createDepartment(int id);
}

//mysql
class MysqlDao implements IDao{

	@Override
	public User createUser(int id) {
		System.out.println("mysql实现User");
		return new User();
	}

	@Override
	public Department createDepartment(int id) {
		System.out.println("mysql实现Department");
		return new Department();
	}
}

//oracle
class OracleDao implements IDao{

	@Override
	public User createUser(int id) {
		System.out.println("oracle实现");
		return new User();
	}

	@Override
	public Department createDepartment(int id) {
		System.out.println("oracle实现");
		return new Department();
	}
}





