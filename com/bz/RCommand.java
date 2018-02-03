package com.bz;
/*
 * 命令模式：有点小懵
 * 		将一个请求	封装成一个对象，从而使你可以用不同的请求对客户进行参数化；(功能？)对请求排队或记录请求日志，以及支持可撤销的操作；
 * 敏捷开发原则：
 */
public class RCommand {

	public static void main(String[] args) {
		Receiver r = new Receiver();
		Command c = new ConcreteCommand(r);
		invoke i = new invoke();
		
		i.setCommand(c);
		
		i.executeCommand();
	}

}

//命令类，用来声明执行操作的接口;只需要知道是谁发出的命令即可
abstract class Command{
	protected Receiver receiver;
	public Command(Receiver receiver){
		this.receiver = receiver;
	}
	
	//执行操作
	abstract public void execute();
}

//接收类：知道如何实施与执行一个请求相关的操作，任何类都能成接收者；//发出命令的人
class Receiver{
	public void action(){
		System.out.println("发出命令！！");
	}
}

//将一个接收者对象绑定于一个动作，调用接收者相应的操作
class ConcreteCommand extends Command{
	public ConcreteCommand(Receiver receiver){
		super(receiver);
	}
	@Override
	public void execute() {
		receiver.action();
	}
	
}

//要求该命令执行这个请求
class invoke{
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void executeCommand(){
		command.execute();
	}
}