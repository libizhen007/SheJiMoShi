package com.bz;
/**
 * A：顺序
 * @author Administrator
 *	简单工厂模式
 *	以计算器为例子，涉及面向对象编程的三大特性：
 *		封装、继承和多态。
 */
public class ASimpleFactory {
	
	//主要test方法
	public static void main(String[] args) {
		Operation operation = OperationFactory.createOperation("+");
		operation.setStrNumberA(20d);
		operation.setStrNumberB(30d);
		System.out.println(operation.getResult());
	}
}


/**
 * 1.先写一个运算类
 * */
class Operation{
	private double strNumberA;
	private double strNumberB;
	public double getResult() {
		double resule = 0d;
		return resule;
	}
	public double getStrNumberA() {
		return strNumberA;
	}
	public void setStrNumberA(double strNumberA) {
		this.strNumberA = strNumberA;
	}
	public double getStrNumberB() {
		return strNumberB;
	}

	public void setStrNumberB(double strNumberB) {
		this.strNumberB = strNumberB;
	}
}
/**
 * 2.编写加法类、减法类等等
 *		这里只写加法类
 */
class OperationAdd extends Operation{

	public double getResult() {
		double resule = 0d;
		resule = getStrNumberA() + getStrNumberB();
		return resule;
	}
}
/**
 * 
 * 3.编写简单工厂类
 */
class OperationFactory{
	public static Operation createOperation(String operate){
		Operation operation = null;
		switch (operate) {
		case "+":
			operation = new OperationAdd();
			break;
		default:
			System.out.println("请输入加减乘除运算符！");
			break;
		}
		return operation;
	}
}