package com.bz;
/**
 * 桥接模式：将抽象与它的实现部分(我觉得应该指功能)分离，使它们都可以独立地变化；
 * 			实现系统可能有多角度分类，每一种分类都有可能变化，那么就把这种	 多角度分离  出来让它们独立变化，减少他们之间的耦合 ；
 * 		涉及到的原则：合成/聚合原则：能用合成/聚合的不要用继承；
 * 					大雁和翅膀：合成；
 * 					大雁和雁群：聚合。
 */
public class QBridge {
	public static void main(String[] args) {
		Abstracts ab = new AbstractA();
		ab.setImp(new ConcreteImpA());
		ab.operation();
		
		ab.setImp(new ConcreteImpB());
		ab.operation();
	}
}

//一个功能抽象实现类
abstract class Implements{
	 abstract public void operation(); 
}
//具体实现类A
class ConcreteImpA extends Implements{

	@Override
	public void operation() {
		System.out.println("具体实现类A");
	}
	
}

//具体实现类B
class ConcreteImpB extends Implements{

	@Override
	public void operation() {
		System.out.println("具体实现类B");
	}
}

//一个抽象部分
abstract class Abstracts{
	private Implements imp;
	
	abstract public void operation();

	public Implements getImp() {
		return imp;
	}

	public void setImp(Implements imp) {
		this.imp = imp;
	}
}

//抽象部分的实现
class AbstractA extends Abstracts{

	@Override
	public void operation() {
		getImp().operation();
	}
	
}
