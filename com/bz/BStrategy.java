package com.bz;
/**
 * 策略模式：
 * 	它定义了算法家族(一堆算法),分别封装起来，让它们之间可以互相替换，此模式让算法的变化不会影响到使用算法的客户。
 * 以下是简单的模板
 */
public class BStrategy {
	//4.客户端
	public static void main(String[] args) {
		Context context;
		context = new Context(new ConcretaStrategyA());
		context.ContextInterfata();
		
		context = new Context(new ConcretaStrategyB());
		context.ContextInterfata();
	}
}

//1.抽象算法类。定义所有支持的算法的公共接口
abstract class Strategy{
	//算法方法
	public abstract void algorithmInterfact();
}

//2.ConcreteStrategy,封装了具体的算法或行为，继承于Strategy，也就是具体的策略。
class ConcretaStrategyA extends Strategy{

	@Override
	public void algorithmInterfact() {
		System.out.println("策略算法A实现！");
	}
	
}
class ConcretaStrategyB extends Strategy{

	@Override
	public void algorithmInterfact() {
		System.out.println("策略算法B实现！");
	}
}

//3.Context,用一个ConcreteStrategy来配置，维护一个对Strategy对象的引用。
class Context{
	Strategy strategy;
	
	//3.1 初始化时传入具体的策略对象
	public Context(Strategy strategy){
		this.strategy = strategy;
	}
	
	//3.2 上下文接口，根据具体的策略对象，调用其算法的方法。
	public void ContextInterfata(){
		strategy.algorithmInterfact();
	}
	
}
