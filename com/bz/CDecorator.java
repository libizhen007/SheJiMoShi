package com.bz;
/**
 * 装饰模式：动态地给一个对象添加一些额外的职责，就增加功能来说，装饰模式比生成子类更为灵活。
 * 以下为模板
 *
 */
public class CDecorator {

	
	public static void main(String[] args) {
		ConcreteComponent cc = new ConcreteComponent();//具体的组成
		ConcreteDecoratorA a = new ConcreteDecoratorA();//具体的装饰,要增加的功能A
		ConcreteDecoratorB b = new ConcreteDecoratorB();//具体的装饰,要增加的功能B
		/**
		 * 装饰的方法是：
		 * 		首先用ConcreteComponent实例化对象cc，
		 * 			然后用ConcreteDecoratorA实例化对象a来包装cc，
		 * 				再用ConcreteDecoratorB实例化对象b来包装a，
		 * 最终执行b的operation()
		 */
		
		a.setComponent(cc);
		
		b.setComponent(a);
		b.operation();
		
		/*
		b.setComponent(cc);
		
		a.setComponent(b);
		a.operation();*/
	}

}
/**
Component是定义一个对象接口，可以给这些对象动态地添加职责。
 */
abstract class Component {
	public abstract void operation();
}
/**
ConcreteComponent是定义了一个具体的对象，也可以给这个对象添加一些职责，也就是说，具体装饰对象主要装饰的就是这个ConcreteComponent
 */
class ConcreteComponent extends Component{

	@Override
	public void operation() {
		System.out.println("具体对象的操作！");
	}
	
}
/**
Decorator，装饰抽象类，继承了Component,从外类来扩展component类的功能，但对于Component来说，是无需知道Decorator的存在的。
 */
abstract class Decorator extends Component{

	//设置 Component
	private Component component;
	public void setComponent(Component component) {
		this.component = component;
	}
	
	//重写operation()，实际执行的是component的operation()
	public void operation() {
		if(component!=null) component.operation();
	}
	
}
/**
至于ConcreteDecorator就是具体的装饰对象，起到给Component添加职责的功能。
 */
class ConcreteDecoratorA extends Decorator{
	//添加独有的功能，以区别ConcreteDecoratorB
	private String address;

	//首先运行Component的operation()，再执行本类的功能，比如address，相当于对原Component进行的装饰
	@Override
	public void operation() {
		super.operation();
		address = "海南";
		System.out.println("具体装饰对象A的操作：" + address);
	}

}

class ConcreteDecoratorB extends Decorator{
	//添加独有的功能，以区别ConcreteDecoratorA
	private String name;

	//首先运行Component的operation()，再执行本类的功能，比如name，相当于对原Component进行的装饰
	@Override
	public void operation() {
		super.operation();
		name = "张三";
		System.out.println("具体装饰对象B的操作：" + name);
	}

}