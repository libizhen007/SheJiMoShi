package com.bz;
/*
中介者模式：
		用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
 */
public class TMediator {

	public static void main(String[] args) {
		concreteMediator cm = new concreteMediator();
		
		//让两个人认识中介
		ZhangSanA zs = new ZhangSanA(cm);//卖家
		LisiA ls = new LisiA(cm);//买家
		
		//让中介者认识两个人
		cm.zs = zs;
		cm.ls = ls;
		
		//李四让中介帮忙问房子多少钱
		cm.coordinate("多少钱", ls);
		
		//张三回答
		cm.coordinate("255", zs);
	}

}
//抽象中介者
abstract class Mediator{
	//协调
	public abstract void coordinate(String msg,PersonA person);
}

//抽象的Person
abstract class PersonA{
	protected Mediator mediator;
	public PersonA(Mediator mediator){
		this.mediator = mediator;
	}
	
	//得到来自中介者的通知
	public abstract void getMsg(String msg);
}

//具体的person
class ZhangSanA extends PersonA{

	public ZhangSanA(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getMsg(String msg) {
		System.out.println("张三得到的信息是：" + msg);
	}
	
}

class LisiA extends PersonA{

	public LisiA(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getMsg(String msg) {
		System.out.println("李四得到的信息是：" + msg);
	}
	
}


//具体中介者
class concreteMediator extends Mediator{
	ZhangSanA zs;
	LisiA ls;
	
	@Override
	public void coordinate(String msg, PersonA person) {
		if(person == zs){
			//张三通过中介发给李四
			ls.getMsg(msg);
		}else{
			zs.getMsg(msg);
		}
	}
	
}