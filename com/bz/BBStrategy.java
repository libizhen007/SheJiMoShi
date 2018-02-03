package com.bz;



/**
 * 以超市促销收银为例子，将普通工厂模式和策略模式结合
 * 	促销：打折、满返和打折加满返
 */
public class BBStrategy {
	public static void main(String[] args) {
		//正常收费
		CashContext cc = new CashContext("正常收费");
		System.out.println(cc.getResult(100));
		//满300返100
		cc = new CashContext("满300返100");
		System.out.println(cc.getResult(1600));
		//打8折
		cc = new CashContext("打8折");
		System.out.println(cc.getResult(100));
		
	}
}

//1.收取现金的超类
abstract class CashSuper{
	//现金超类的抽象方法，收取现金，参数为原价，返回的为当前价
	public abstract double acceptCash(double money);
}

//1.1	正常收费子类
class CashNormal extends CashSuper{
	//正常收费，原价返回
	public double acceptCash(double money) {
		return money;
	}
}

//1.2	打折收费子类
class CashRebate extends CashSuper{
	//打折收费，初始化时必须输入折扣率。
	private double moneyRebate = 1d;
	public CashRebate(double moneyRebate){
		this.moneyRebate = moneyRebate;
	}
	public double acceptCash(double money) {
		return money * moneyRebate;
	}
}

//1.3	返利收费子类
class CashReturn extends CashSuper{
	
	private double moneyCondition = 0.0d;
	private double moneyReturn = 0.0d;
	/**
	 * 返利收费，初始化时必须输入返利条件和返利值。
	 * 比如满300返100,moneyCondition为300，moneyReturn为100
	 */
	public CashReturn(double moneyCondition,double moneyReturn){
		this.moneyCondition = moneyCondition;
		this.moneyReturn = moneyReturn;
	}
	//若收取的现金大于返利条件则需要减去返利值
	public double acceptCash(double money) {
		double result = money;
		if(money >= moneyCondition){
			result = money - (Math.floor(money / moneyCondition) * moneyReturn);
		}
		return result;
	}
}

/**
 * 2.	策略模式和简单工厂模式结合
 * 			用一个CashSuper的子类来配置，维护一个对CashSuper对象的引用。
 */
class CashContext{
	CashSuper cs = null;
	
	//注意参数不是具体的策略对象，而是一个字符串，表示收费类型
	public CashContext(String type){
		//将实例化具体策略的过程由客户端(main)转移到context中。简单工厂的应用。
		switch (type) {
		case "正常收费":
			cs = new CashNormal();
			break;
		case "打8折":
			cs = new CashRebate(0.8);
			break;
		case "满300返100":
			cs = new CashReturn(300, 100);
			break;
		}
	}
	public double getResult(double money){
		return cs.acceptCash(money);
	}
}