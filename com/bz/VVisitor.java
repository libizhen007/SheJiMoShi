package com.bz;

import java.util.ArrayList;
import java.util.List;

/*
 * 访问者模式Visitor:
 * 		表示一个作用于某对象结构中的各元素的操作。它使你可以在不改变各元素的前提下定义作用于这些元素的新操作。
	例子:男人和女人的状态
 */
public class VVisitor {

	public static void main(String[] args) {
		ObjectStructure os = new ObjectStructure();
		os.add(new Man());
		os.add(new WoMan());
		
		//成功状态，得到反应
		Success s = new Success();
		os.show(s);
		
	}

}

//状态抽象类和人的抽象类
abstract class Action{
	//男人和女人都是具体的数据结构
	
	//得到男人的结论或反应
	public abstract void getManConclusion(Man concreteElementA);
	//得到女人的结论或反应
	public abstract void getWoManConclusion(WoMan concreteElementB);
}

abstract class PersonV{
	//接受状态
	public abstract void accept(Action action);
}

/**
 二次分派：	
 	首先在客户程序中将具体状态作为参数传递给“男”类完成一次分派，然后“男”类调用作为参数的“具体状态”中的方法“男人反应”，同时将自己this作为参数传递进去。这便完成了二次分派
 */
//男人类和女人类
class Man extends PersonV{

	@Override
	public void accept(Action action) {
		action.getManConclusion(this);
	}
	
}
class WoMan extends PersonV{

	@Override
	public void accept(Action action) {
		action.getWoManConclusion(this);
	}
	
}



/*
 * 这里关键就在于人就只分为男人和女人，这个性别的分类是稳定的，所以可以在状态类中，增加“男人反应”和“女人反应”，方法个数是稳定的，
 * 不会很容易的发生变化。而“人”抽象类中有一个抽象方法“接受”，它是用来获得“状态”对象的。每一种具体状态都继承“状态”抽象类，实现两个反应的方法；*/

//成功状态
class Success extends Action{

	@Override
	public void getManConclusion(Man concreteElementA) {
		System.out.println("每一个男人成功的背后都一个女人");
	}

	@Override
	public void getWoManConclusion(WoMan concreteElementB) {
		System.out.println("每一个女人成功的背后都有一个失败的男人");
	}
	
}

/**
 * 对象结构类，由于总是需要“男人”与“女人”在不同状态的对比，所以我们需要一个“对象结构”来针对不同“状态”遍历”男人“与”女人“，得到不同的反应

 */
class ObjectStructure{
	private List<PersonV> ps = new ArrayList<PersonV>();
	
	public void add(PersonV person){
		ps.add(person);
		
	}
	public void remove(PersonV person){
		ps.remove(person);
		
	}
	
	public void show(Action action){
		for(PersonV p : ps){
			p.accept(action);
		}
	}
}
