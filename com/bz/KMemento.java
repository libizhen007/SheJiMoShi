package com.bz;
/**备忘录模式：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态。*/
public class KMemento {

	public static void main(String[] args) {
		Originator originator = new Originator();
		originator.setState("99%");
		
		Caretaker caretaker = new Caretaker();
		caretaker.setMemento(originator.createMemento());//设置备份点
		
		originator.setState("over");
		originator.show();
		
		originator.recover(caretaker.getMemento());//成功恢复
		originator.show();
	}

}

//发起人。发起备份命令
class Originator{
	private String state;//需要保存的状态

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * 创建一个备忘录memento，将当前需要保存的信息进行备份并实例化一个Memento对象
	 */
	public Memento createMemento(){
		return new Memento(state);
	}
	/**
	 * 恢复备忘录，将一个Memento导入并恢复相关数据
	 */
	public void recover(Memento memento){
		this.state = memento.getState();
	}
	
	public void show(){
		System.out.println(this.state);
	}
}

//备忘录
class Memento{
	private String state;//需要保存的属性，可以有多个
	public Memento(String state){
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}

//管理备忘录的class
class Caretaker{
	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
}
