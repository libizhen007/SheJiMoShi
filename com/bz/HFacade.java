package com.bz;
/**
外观模式：*有点像代理模式
	为子系统中的一组接口提供一个一致的界面，此模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
	例子：以投资为例；股民——>基金——>股票(其他)
 */
public class HFacade {

	public static void main(String[] args) {
		new Fund().sellFund();
	}

}

//股票类
class Stock{
	public void sell(){
		System.out.println("卖出股票");
	}
	public void buy(){
		System.out.println("购买股票");
	}
}
//证券其他类似

//基金类
class Fund{
	Stock s1;
	
	public Fund(){
		s1 = new Stock();
	}
	public void sellFund(){

		s1.sell();
	}
	public void buyFund(){

		s1.buy();
	}
	
}