package com.bz;
/**
原型模式：用原型实例指定创建对象的种类，并通过拷贝这些原型创建新的对象。
涉及：
	浅复制：见FFPrototype
	深复制：见FFPrototype
	clone()：    创建并返回此对象的一个副本。需要实现Cloneable;这个方法要重写*
 */
public class FPrototype {

	public static void main(String[] args) throws Exception {
		Prototype c1 = new ConcretePrototype(10);
		Prototype c2 = c1.copyPrototype();
		System.out.println(c1);
		System.out.println(c2);
	}

}
//原型类
abstract class Prototype implements Cloneable {
	private int id;
	public Prototype(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	//通过原型创建新对象
	public abstract Prototype copyPrototype() throws Exception;
}

//具体原型类
class ConcretePrototype extends Prototype{


	public ConcretePrototype(int id) {
		super(id);

	}

	@Override
	public Prototype copyPrototype() throws CloneNotSupportedException {
		return (Prototype) this.clone();//创建并返回此对象的一个副本。
	}

	
}

