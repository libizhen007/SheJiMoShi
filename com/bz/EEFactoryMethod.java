package com.bz;
/**
 * 
工厂方法例子：学雷锋做事
 */
public class EEFactoryMethod {
	public static void main(String[] args) {
		//首先使用简单工厂模式
		LeiFeng s1 = LeiFengSimpleFactory.createLeiFeng("学生");
		s1.sweep();
		LeiFeng s2 = LeiFengSimpleFactory.createLeiFeng("学生");
		s2.wash();
		
		//以下用工厂方法
		ILeiFeng i = new StudentLeiFengFactory();
		LeiFeng stu1 = i.createLeiFeng();
		LeiFeng stu2 = i.createLeiFeng();
		
		
		
		
	}
}

//雷锋类
class LeiFeng{
	public void sweep(){
		System.out.println("扫地");
	}
	public void wash(){
		System.out.println("洗衣");
	}
}
//学雷锋的学生
class Student extends LeiFeng{
}
//学雷锋的社会志愿者
class Volunteer extends LeiFeng{
}

//写一个雷锋简单工厂
class LeiFengSimpleFactory{
	public static LeiFeng createLeiFeng(String type){
		LeiFeng leifeng = null;
		switch (type) {
		case "学生":
			leifeng =  new Student();	
			break;

		case "志愿者":
			leifeng =  new Volunteer();	
			break;
		}
		return leifeng;
	}
}

//1.雷锋工厂
interface ILeiFeng{
	public LeiFeng createLeiFeng(); 
}
//2.学雷锋的大学生工厂
class StudentLeiFengFactory implements ILeiFeng{
	@Override
	public LeiFeng createLeiFeng() {
		return new Student();
	}
}
//学雷锋的志愿者工厂
class VolunteerLeiFengFactory implements ILeiFeng{
	@Override
	public LeiFeng createLeiFeng() {
		return new Volunteer();
	}
}

