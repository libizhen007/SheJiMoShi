package com.bz;
/**状态模式：
当一个对象的内在状态改变时允许改变其行为，这个对象看起来像是改变了其类。

何时用：
当一个对象的行为取决于它的状态，并且它能够在运行时根据状态 改变 它的行为时。
*/
public class OState {

	public static void main(String[] args) {
		//出示状态设置为concreteStateA
		OContext context = new OContext(new ConcreteStateA());
		context.next();
		context.next();
		context.next();
		context.next();
	}

}

//抽象状态类，定义一个接口（方法）以封装与Context的一个特定状态相关的行为
abstract class State{
	public abstract void handle(OContext context);
}

//维护一个具体状态对象concreteState,这个对象定义当前的状态
class OContext{
	private State state;
	
	public OContext(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	//对请求做处理，并设置下一状态
	public void next(){
		System.out.println("已作处理，并成功设置下一状态:" + getState().getClass().getName());
		getState().handle(this);
	}
}

//具体状态
class ConcreteStateA extends State{
	/**
	 * 设置ConcreteStateA的下一状态是ConcreteStateB
	 */
	@Override
	public void handle(OContext context) {
		context.setState(new ConcreteStateB());
	}
}

class ConcreteStateB extends State{
	/**
	 * 设置ConcreteStateB的下一状态是ConcreteStateA
	 */
	@Override
	public void handle(OContext context) {
		context.setState(new ConcreteStateA());
	}
}