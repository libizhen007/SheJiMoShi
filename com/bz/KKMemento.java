package com.bz;
/**备忘录模式：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态。
 * 游戏角色状态保存
 * */
public class KKMemento {

	public static void main(String[] args) {
		GameRole role = new GameRole();
		
		role.setVit(55);
		
		GameCaretaker caretaker = new GameCaretaker();
		caretaker.setMemento(role.createMemento());//备份
		
		role.setVit(1);
		role.show();
		
		role.recover(caretaker.getMemento());//恢复
		role.show();
	}

}

//游戏角色
class GameRole{
	private int vit;//生命
	private int atk;//攻击力
	private int def;//防御力
	
	
	public int getVit() {
		return vit;
	}
	public void setVit(int vit) {
		this.vit = vit;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public GameRole() {
		vit = 100;
		atk = 100;
		def = 100;
	}
	/**
	 * 创建一个备忘录memento，将当前需要保存的信息进行备份并实例化一个Memento对象
	 */
	public GameMemento createMemento(){
		return new GameMemento(vit,atk,def);
	}
	/**
	 * 恢复备忘录，将一个Memento导入并恢复相关数据
	 */
	public void recover(GameMemento memento){
		this.vit = memento.getVit();
		this.atk = memento.getAtk();
		this.def = memento.getDef();
	}
	
	public void show(){
		System.out.println("生命：" + vit + " 攻击力：" + atk + " 防御力:" + def);
	}
}

//备忘录
class GameMemento{
	private int vit;//生命
	private int atk;//攻击力
	private int def;//防御力
	public int getVit() {
		return vit;
	}
	public void setVit(int vit) {
		this.vit = vit;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public GameMemento(int vit, int atk, int def) {
		this.vit = vit;
		this.atk = atk;
		this.def = def;
	}
	
}

//管理备忘录的class
class GameCaretaker{
	private GameMemento memento;

	public GameMemento getMemento() {
		return memento;
	}

	public void setMemento(GameMemento memento) {
		this.memento = memento;
	}

}
