package com.bz;
/**
 * 
 *代理模式例子：张三rang李四帮忙，代自己送花给小红
 */
public class DDProxy {

	public static void main(String[] args) {
		LiSi l = new LiSi();
		l.sendFlower();
	}

}

//送花类，张三和李四都共有的接口。
interface Flower{
	public void sendFlower();
}

//要送花的真实主人
class ZhangSan implements Flower{
	@Override
	public void sendFlower() {
		System.out.println("小红，这是送你的花");
	}
	
}

//送花的代理
class LiSi implements Flower{

	private ZhangSan zs;
	@Override
	public void sendFlower() {
		if(zs == null) zs = new ZhangSan();
		zs.sendFlower();
	}
	
}