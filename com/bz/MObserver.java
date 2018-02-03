package com.bz;

import java.util.ArrayList;
import java.util.List;

/**有点蒙
	观察者模式：
	定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象在状态发生变化时，会通知所有观察者对象，使他们能够自动更新自己。
 */
public class MObserver {

	public static void main(String[] args) {
		ConcreteSubject subject = new ConcreteSubject();
		subject.add(new ConcreteObserver("张三", subject));
		subject.add(new ConcreteObserver("李四", subject));
		
		subject.setSubjectState("当前状态吖");
		
		subject.notifys();
	}

}

/**
 * 抽象主题类或抽象通知者，一般用一个抽象类或者一个接口实现。
 * 它把所有对观察者对象的引用保存在一个集合里，每个主题都可以有任何数量的观察者。抽象主题提供一个接口，可以增加和删除观察者对象。
 */
abstract class Subjects{
	private List<Observer> observers = new ArrayList<Observer>();
	
	//增加观察者
	public void add(Observer observer){
		observers.add(observer);
	}
	//移除观察者
	public void remove(Observer observer){
		observers.remove(observer);
	}
	//通知所有观察者
	public void notifys(){
		for(Observer ob : observers){
			ob.updates();
		}
	}
	
}
/*****java自带一个：Observer接口
 * 抽象观察者，为所有的具体观察者定义一个接口，在得到主题的通知时更新自己。
 * 这个接口叫做更新接口。抽象观察者一般用一个抽象类或者一个接口实现。更新接口通常包含一个updeta()更新方法。
 */
abstract class Observer{
	public abstract void updates();
}

/**ConcreteSubject,具体主题或具体通知者，将有关状态存入具体观察者对象；
在具体主题的内部状态改变时，给所有登记过的观察者发出通知。具体主题角色通常用一个具体子类实现
*/
class ConcreteSubject extends Subjects{
	//具体被观察者状态
	private String subjectState;

	public String getSubjectState() {
		return subjectState;
	}

	public void setSubjectState(String subjectState) {
		this.subjectState = subjectState;
	}
}

/**concreteObserver，具体观察者，实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题的状态相协调。
具体观察者角色可以保存一个指向具体主题对象的引用。具体观察者角色通常用一个具体子类实现*/
class ConcreteObserver extends Observer{

	private String name;
	private String observerState;
	private ConcreteSubject concreteSubject;
	
	
	public ConcreteObserver(String name, ConcreteSubject concreteSubject) {
		this.name = name;
		this.concreteSubject = concreteSubject;
	}


	@Override
	public void updates() {
		observerState = concreteSubject.getSubjectState();
		System.out.println("观察者是：" + name + "  状态是:" + observerState);
	}


	public ConcreteSubject getConcreteSubject() {
		return concreteSubject;
	}


	public void setConcreteSubject(ConcreteSubject concreteSubject) {
		this.concreteSubject = concreteSubject;
	}
	
}
