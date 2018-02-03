package com.bz;
/**
 * 工厂方法：
 * 	修改简单工厂的计算器类
 *
 */
public class EFactoryMethod {

	public static void main(String[] args) {
		EOperationFactory factoryMethod = new AddFactory();
		Operation operationAdd = factoryMethod.createOperation();
		operationAdd.setStrNumberA(10);
		operationAdd.setStrNumberB(52);
		System.out.println(operationAdd.getResult());
		
		factoryMethod = new SubFactory();
		Operation operationSub = factoryMethod.createOperation();
		operationSub.setStrNumberA(10);
		operationSub.setStrNumberB(52);
		System.out.println(operationSub.getResult());
	}

}


//1.先写一个总工厂类,Operation在ASimpleFactory
abstract class EOperationFactory{
	public abstract Operation createOperation();
}

//2.再写一个加法工厂类
class AddFactory extends EOperationFactory{
	@Override
	public Operation createOperation() {
		return new OperationAdd();
	}
}

//3.如果再写一个减法
class OperationSub extends Operation{

	@Override
	public double getResult() {
		double resule = 0d;
		resule = getStrNumberA() - getStrNumberB();
		return resule;
	}
}
class SubFactory extends EOperationFactory{
	@Override
	public Operation createOperation() {
		return new OperationSub();
	}
}
