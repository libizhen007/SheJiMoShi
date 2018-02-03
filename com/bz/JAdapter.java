package com.bz;
/**适配器模式：
将一个类的接口转换成客户希望的另外一个接口。Adaptero模式使得原本由于接口不兼容而不能一起工作的类可以一起工作。
	*系统的数据和行为都正确，但接口不符合时，我们应该考虑使用适配器，目的是使控制范围之外的一个原有对象与某个接口匹配。
	*适配器模式主要是应用于希望复用一些现存的类，但是接口又与复用环境要求不一致的情况。
*/
public class JAdapter {

	public static void main(String[] args) {
		//现在我要将MP4的数据读取、写入
		Computer computer = new Computer();
		computer.setMobileStorageInter(new MP4());
		computer.readData();
		computer.writeData();
		//现在我要将MP3的数据读取、写入
		computer.setMobileStorageInter(new MP3());
		computer.readData();
		computer.writeData();
		
		//现在来了一个平板usb，但是手机上没有实现MobileStorageInter接口，所以我们需要使用 适配器设计模式
		PAD pad = new PAD();
		
		computer.setMobileStorageInter(new PADAdapter(pad));
		computer.readData();
		computer.writeData();
	}

}

//手机存储接口
interface MobileStorageInter {
	public void read();
	public void write();
}

//计算机类
class Computer {
	private MobileStorageInter mobileStorageInter;//相当于usb

	public Computer(MobileStorageInter mobileStorageInter) {
		this.mobileStorageInter = mobileStorageInter;
	}

	public Computer() {
		super();
	}

	public MobileStorageInter getMobileStorageInter() {
		return mobileStorageInter;
	}

	public void setMobileStorageInter(MobileStorageInter mobileStorageInter) {
		this.mobileStorageInter = mobileStorageInter;
	}
	
	public void readData(){
		this.getMobileStorageInter().read();
	}
	public void writeData(){
		this.getMobileStorageInter().write();
	}
}

class MP4 implements MobileStorageInter {

	@Override
	public void read() {
		System.out.println("读MP4......");
	}

	@Override
	public void write() {
		System.out.println("写入MP4......");
	}

}
class MP3 implements MobileStorageInter{

	@Override
	public void read() {
		System.out.println("读MP3......");
	}

	@Override
	public void write() {
		System.out.println("写入MP3......");
	}
	
}

class PAD {
	/**
	 * 读取平板数据
	 */
	public void rd(){
		System.out.println("读PAD......");
	}
	/**
	 * 写入平板
	 */
	public void wt(){
		System.out.println("写入PAD......");
	}
}


/**
 * 相当于转接头
 * @author Administrator
 *
 */
class PADAdapter implements MobileStorageInter {

	private PAD pad;
	
	public PADAdapter(PAD pad) {
		super();
		this.pad = pad;
	}

	public PAD getPad() {
		return pad;
	}

	public void setPad(PAD pad) {
		this.pad = pad;
	}

	@Override
	public void read() {
		this.pad.rd();
	}

	@Override
	public void write() {
		this.pad.wt();
	}

}
