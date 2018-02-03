package com.bz;
/**
复制简历例子
	浅复制：被复制对象的所有变量都含有与原来对象相同的值，而所有的对其他对象的引用都仍然指向原来的对象。
	深复制：把引用对象的变量指向复制过的新对象，而不是原有的被引用的对象
 */

public class FFPrototype {

	public static void main(String[] args) throws CloneNotSupportedException {
		Resume r1 = new Resume("张三");
		r1.setPersonInfo(35);
		r1.setWorkExperience("2005-2015", "百度");
		
		
		Resume r2 = (Resume) r1.myClone();
		r2.setPersonInfo(37);
		r2.setWorkExperience("2017-", "新浪");
		
		
		Resume r3 = (Resume) r1.myClone();
		r3.setPersonInfo(55);
		r3.setWorkExperience("2017-2055", "新浪");
		/**运行一下代码将会得到以下结果，浅复制。
		 *  张三 今年35 在新浪 工作了2017-2055
			张三 今年37 在新浪 工作了2017-2055
			张三 今年55 在新浪 工作了2017-2055
		 */
		r1.show();
		r2.show();
		r3.show();
		
		/**
		 * 深复制：
		 * 		1.让工作经验类也实现Cloneable
		 * 		2.在简历类加上一个构造函数
		 * 		3.调用私有的构造方法，让 工作经历类克隆完成，然后再给这个简历对象的相关字段复制，最终返回一个深复制的简历对象
		 */
		
	}

}
//简历类
class Resume implements Cloneable{
	private String name;
	private int age;
	/**
	 * 浅复制。
	 
	private String timeArea;//工作时间区间
	private String company;//公司*/
	public void setPersonInfo(int age){
		this.age = age;
	}
	//设置工作经历,如果使用这个而不是使用WorkExperience，则不会出现深浅复制现象
/*	public void setWorkExperience(String timeArea,String company){
		this.timeArea = timeArea;
		this.company = company;
	}*/
	
	
	private WorkExperience work;//深复制
	//在实例化简历类的同时也实例化工作经历类
	
	public Resume(String name){
		this.name = name;
		
		work = new WorkExperience();//深复制
	}
	
	/**
	 * 
	 * 深复制所需构造函数,定为私有
	 */
	private Resume(WorkExperience work) throws CloneNotSupportedException{
		this.work = (WorkExperience) work.myWockClone();
	}
	
	//设置工作经历
	public void setWorkExperience(String timeArea,String company){
		work.setTimeArea(timeArea);
		work.setCompany(company);
	}
	//重写clone
	public Object myClone() throws CloneNotSupportedException{
		/**
		 * 调用私有的构造方法，让 工作经历类克隆完成，然后再给这个简历对象的相关字段复制，最终返回一个深复制的简历对象
		 */
		Resume r = new Resume(this.work);
		r.age = this.age;
		r.name = this.name;
		return r;
		
		/**
		 * 浅复制
		 */
	//	return this.clone();
		
	}
	
	public void show(){
		System.out.println(name + " 今年" + age +" 在" + work.getCompany() + " 工作了" + work.getTimeArea());
	}
}


//深复制所需。通常来说，我们需要把工作经历写成一个类
class WorkExperience implements Cloneable{
	private String timeArea;//工作时间区间
	private String company;//公司
	public String getTimeArea() {
		return timeArea;
	}
	public void setTimeArea(String timeArea) {
		this.timeArea = timeArea;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public Object myWockClone() throws CloneNotSupportedException{
		return this.clone();
	}
}

