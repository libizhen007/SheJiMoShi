package com.bz;
/**
状态模式例子:上班的不同状态
	9-12点，状态超好
	12-13点，累了困了
	13-16点，状态逐渐恢复
	大于16点，加班，
	大于21点，回家睡觉
 */
public class OOState {
	public static void main(String[] args) {
		Work w = new Work();
		w.writeProgram();
		w.setHour(11);
		w.writeProgram();
		w.setHour(13);
		w.writeProgram();
		w.setHour(16);
		w.writeProgram();
		w.setHour(22);
		w.writeProgram();
	}
}



//抽象状态
abstract class WState{
	//写程序
	public abstract void writeProgram(Work w);
}

//上午状态
class ForenoonState extends WState{

	@Override
	public void writeProgram(Work w) {
		if(w.getHour() <= 12){
			System.out.println("早上状态不错，加油写代码");
		}else{
			System.out.println("到中午了！");
			w.setConcrete(new NoonState());
			w.writeProgram();
		}
	}
	
}

//中午状态
class NoonState extends WState{

	@Override
	public void writeProgram(Work w) {
		if(w.getHour() <= 13){
			System.out.println("中午了，吃饭，困了！");
		}else{
			System.out.println("到下午了了！");
			w.setConcrete(new AfternoonState());
			w.writeProgram();
		}
	}
	
}

//下午状态
class AfternoonState extends WState{

	@Override
	public void writeProgram(Work w) {
		if(w.getHour() <= 16){
			System.out.println("状态恢复了些，继续写代码");
		}else{
			System.out.println("超过下午时间了");
			w.setConcrete(new NightState());
			w.writeProgram();
		}
	}
	
}

//晚上加班状态
class NightState extends WState{

	@Override
	public void writeProgram(Work w) {
		if(w.getHour() <= 21){
			System.out.println("又要加班了!");
		}else{
			System.out.println("回家睡觉");
			
		}
	}
	
}

//工作类
class Work{
	//hour 重点属性，状态转换的依据
	private int hour;
	//当前工作状态
	private WState concrete;
	//初始化状态为上午
	public Work() {
		concrete = new ForenoonState();
	}
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public WState getConcrete() {
		return concrete;
	}
	public void setConcrete(WState concrete) {
		this.concrete = concrete;
	}
	
	public void writeProgram() {
		concrete.writeProgram(this);
	}
}

