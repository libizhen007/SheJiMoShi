package com.bz;

import java.util.ArrayList;
import java.util.List;

/**
 * 有点不明所以
建造者模式：将一个复杂对象的构建和它的表示分离，使得同样的构建过程可以构建不同的表示。
		建造者模式是在当创建复杂对象的算法应该独立于该对象的组成部分已经它们的装配方法时所适用的模式。
例子：建造产品

 */
public class IBuild {

	public static void main(String[] args) {
		//客户不需要知道具体的创建过程
		Director d = new Director();
		Build b1 = new ConcreteBuild();
		d.construct(b1);
		
		Product product = b1.getProduct();
		product.show();
	}

}

//产品类,由多个部件组成。
class Product{
	List<String> parts = new ArrayList<String>();
	public void add(String part){
		parts.add(part);
	}
	//列举产品所有部件
	public void show(){
		for(String part:parts){
			System.out.println(part);
		}
	}
}

//建造类——抽象的建造者类，确定产品由两个部件partA和partB组成，并声明一个得到产品建造后的结果
abstract class Build{
	public abstract void buildPartA(); 
	public abstract void buildPartB();
	public abstract Product getProduct();
}

//具体建造者类
class ConcreteBuild extends Build{
	private Product product = new Product();
	
	@Override
	public void buildPartA() {
		product.add("部件A");
	}

	@Override
	public void buildPartB() {
		product.add("部件b");
	}

	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		return product;
	}
	
}
//指挥者类，用来指挥建造过程
class Director{
	public void construct(Build build){
		build.buildPartA();
		build.buildPartB();
	}
}


