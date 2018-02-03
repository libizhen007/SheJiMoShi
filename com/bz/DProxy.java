package com.bz;
/**
 *代理模式的模板
 */
public class DProxy {
	public static void main(String[] args) {
		RealSubjectProxy p = new RealSubjectProxy();
		p.show();
	}
}

/**
 * Subject类(相同接口，使用抽象类或者接口都行)，定义了RealSubject和proxy的共用接口，
 * 	这样就可以在任何使用RealSubject的地方都能使用proxy
 */
abstract class Subject{
	public abstract void show();
}

/**
 * 定义了代理proxy所代表的真实实体
 */
class RealSubject extends Subject{

	@Override
	public void show() {
		System.out.println("代理真实实体要做的事！");
	}
}

/**
 * 
 */
class RealSubjectProxy extends Subject{
	private RealSubject realSubject;
	@Override
	public void show() {
		if(realSubject == null){
			realSubject = new RealSubject();
		}
		//在这里可以做一些其他事
		realSubject.show();
		//在这里可以做一些其他事
	}
}