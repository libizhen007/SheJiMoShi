package com.bz;
/**
 * 小明穿着装饰类
 */
public class CCDecorator {

	
	public static void main(String[] args) {
		Person p = new Person("小明");
		System.out.println("开始装扮");
		
		XHK xhk = new XHK();
		MY my = new MY();
		
		
		xhk.setComponent(p);
		my.setComponent(xhk);
		my.show();
		
		
		
		
	}

}
//ConcreteComponent
class Person{
	public Person(){
		
	}
	private String name;
	public Person(String name){
		this.name = name;
	}
	public void show(){
		System.out.println("  name:"  + name);
	}
}


/**

服饰类 decorator
 */
class Finery extends Person{

	//设置 Person （组成）
	private Person component;
	public void setComponent(Person component) {
		this.component = component;
	}
	
	//重写show()，实际执行的是component的show()
	public void show() {
		if(component!=null) component.show();
	}
	
}
/**

*具体服饰类 :ConcreteDecorator
*嘻哈裤
 */
class XHK extends Finery{
	//添加独有的功能，以区别ConcreteDecoratorB
	private String xhk;//嘻哈裤

	//首先运行Component的operation()，再执行本类的功能，比如address，相当于对原Component进行的装饰
	@Override
	public void show() {
		super.show();
		xhk = "嘻哈裤";
		System.out.println("穿上：" + xhk);
		//super.show();
	}

}
//毛衣
class MY extends Finery{
	//添加独有的功能，以区别ConcreteDecoratorA
	private String my;

	//首先运行Component的operation()，再执行本类的功能，比如name，相当于对原Component进行的装饰
	@Override
	public void show() {
		super.show();
		my = "毛衣";
		System.out.println("穿上：" + my);
		//super.show();
	}

}