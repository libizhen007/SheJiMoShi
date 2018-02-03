package com.bz;
/*
 * 职责链模式：使多个对象都有机会处理请求，从而避免请求的发生者和接受者之间的耦合关系。将这个对象连成一条链，并沿着这条链传递该请求，知道有一个对象处理它为止
 */
public class SChain {

	public static void main(String[] args) {
		Handler a = new ConcreteHandlerA();
		Handler b = new ConcreteHandlerB();
		
		a.setSuperHandler(b);
		b.setSuperHandler(null);
		
		a.executeRequest(10);
	}

}

//处理请求的处理者接口
abstract class Handler{
	protected Handler superHandler;
	
	public void setSuperHandler(Handler handler){
		this.superHandler = handler;
	}
	abstract public void executeRequest(int num);
	
}

//具体处理者
class ConcreteHandlerA extends Handler{

	
	@Override
	public void executeRequest(int num) {
		if(num < 10){
			System.out.println("由我A处理");
		}else{
			System.out.println("------------------转交我的上级");
			superHandler.executeRequest(num);
		}
	}

}

class ConcreteHandlerB extends Handler{
	@Override
	public void executeRequest(int num) {
		if(num > 10){
			System.out.println("由我B处理");
		}else{
			System.out.println("------------------转交公司处理");
			
		}
	}
}

