package com.bz;
/**
模板方法模式：
	主要涉及：继承和多态
 */
public class GTemplateMethod {

	public static void main(String[] args) {
		///模板方法模式是通过把不变行为搬移到超类，去除子类中的重复代码，来体现它的优势。

		AbstractClass c1 = new Concrete();
		c1.fun1();
	}

}
//抽象类，其实就是一个抽象模板，定义并实现一个模板方法。
abstract class AbstractClass{
	//一些抽象行为，放到子类实现
	public abstract void operation1();
	public abstract void operation2();
	
	//模板方法，给出了逻辑的骨架，而【逻辑的组成则是一些相应的抽象操作，它们都推迟到子类实现】
	public void fun1(){
		operation1();
		operation2();
	}
}

//具体实现类，实现了父类所定义的一个或多个方法
class Concrete extends AbstractClass{

	@Override
	public void operation1() {
		System.out.println("1");
	}

	@Override
	public void operation2() {
		System.out.println("2");
	}
	
}