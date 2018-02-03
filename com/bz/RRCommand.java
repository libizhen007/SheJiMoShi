package com.bz;

import java.util.ArrayList;
import java.util.List;

/*
 * 命令模式：有点小懵
 * 		将一个请求	封装成一个对象，从而使你可以用不同的请求对客户进行参数化；(功能？)对请求排队或记录请求日志，以及支持可撤销的操作；
 * 敏捷开发原则：
 * 			不要为代码添加基于猜测的、实际不需要的功能。
 * 			如果不清楚一个系统是否需要某个模式，一般就不要急于实现它，
 * 			事实上，在需要的时候通过重构实现这个模式并不困难，只有在真正需要某个功能时，把原来的代码重构为某命令模式才有意义。
 */
public class RRCommand {

	public static void main(String[] args) {
		//来了一个客户
		Barbecuer bizhen = new Barbecuer();
		
		//点菜
		ACommand ac1 = new Fun1(bizhen);
		ACommand ac2 = new Fun2(bizhen);
		
		//服务员准备
		Waiter w = new Waiter();
		w.setCommand(ac1);
		w.setCommand(ac2);
		
		//通知厨师
		w.executeCommand();
		
	}

}

//要吃烧烤的人 、、receiver
class Barbecuer{
	public void fun1(){
		System.out.println("烤羊肉");
	}
	public void fun2(){
		System.out.println("烤牛肉干");
	}
}


//命令类，只需要知道要吃烧烤的是谁
abstract class ACommand{
	protected Barbecuer receiver;
	public ACommand(Barbecuer receiver){
		this.receiver = receiver;
	}
	
	//执行命令
	abstract public void execute();
}

																	
//烤羊肉的具体命令
class Fun1 extends ACommand{
	public Fun1(Barbecuer receiver){
		super(receiver);
	}
	@Override
	public void execute() {
		receiver.fun1();
	}
	
}

//烤牛肉干的具体命令
class Fun2 extends ACommand{
	public Fun2(Barbecuer receiver){
		super(receiver);
	}
	@Override
	public void execute() {
		receiver.fun2();
	}
	
}

//要求该命令执行这个请求;//invoke
class Waiter{
	private List<ACommand> commands = new ArrayList<ACommand>();
	//设置订单
	public void setCommand(ACommand command) {
		commands.add(command);
	}
	//取消订单
	public void removeCommand(ACommand command){
		commands.remove(command);
	}
	//通知厨师
	public void executeCommand(){
		for(ACommand c : commands){
			c.execute();
		}
	}
}