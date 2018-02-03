package com.bz;

import java.util.ArrayList;
import java.util.List;

/**
组合模式.有点懵：
 */
public class LComposite {

	public static void main(String[] args) {
		ConcreteCompany baidu = new ConcreteCompany("百度");
		baidu.addCompany(new HRDepartment("-百度总公司人力资源部"));//应该把addCompany改为add
		baidu.addCompany(new FinanceDepartment("-百度总公司财务部"));
		
		//海南分公司
		ConcreteCompany haiNanBaidu = new ConcreteCompany("-海南分公司");
		haiNanBaidu.addCompany(new HRDepartment("--海南分公司人力资源部"));//应该把addCompany改为add
		haiNanBaidu.addCompany(new FinanceDepartment("--海南分公司财务部"));
		baidu.addCompany(haiNanBaidu);
		
		
		//三亚办事处
		ConcreteCompany sanYa = new ConcreteCompany("--三亚办事处");
		sanYa.addCompany(new HRDepartment("---三亚办事处人力资源部"));//应该把addCompany改为add
		sanYa.addCompany(new FinanceDepartment("---三亚办事处财务部"));
		haiNanBaidu.addCompany(sanYa);
		
		
		baidu.show();

	}

}

//公司类
abstract class Company{
	private String name;
	public Company(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public abstract void addCompany(Company c);
	public abstract void removeCompany(Company c);
	public abstract void show();//显示所有公司和分公司
	public abstract void lineOfDuty();//履行职责
}

//具体公司类
class ConcreteCompany extends Company{
	public ConcreteCompany(String name) {
		super(name);
	}

	public List<Company> getChildren() {
		return children;
	}

	private List<Company> children = new ArrayList<Company>();

	@Override
	public void addCompany(Company c) {
		children.add(c);
	}

	@Override
	public void removeCompany(Company c) {
		children.remove(c);
	}

	@Override
	public void show() {
		System.out.println( this.getName());
		System.out.println(children.size());
		for(Company c : children){
			
			c.show();
		}
	}

	@Override
	public void lineOfDuty() {
		for(Company c : children){
			c.lineOfDuty();
		}
	}
}

//人力资源部
class HRDepartment extends Company{

	public HRDepartment(String name) {
		super(name);
	}

	@Override
	public void addCompany(Company c) {
	}

	@Override
	public void removeCompany(Company c) {

	}

	@Override
	public void show() {
		System.out.println(this.getName());
	}

	@Override
	public void lineOfDuty() {
		System.out.print("招聘员工");
	}
}

//财务部
class FinanceDepartment extends Company{

	public FinanceDepartment(String name) {
		super(name);
	}

	@Override
	public void addCompany(Company c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCompany(Company c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		System.out.println(this.getName());
	}

	@Override
	public void lineOfDuty() {
		System.out.println("结算工资");
	}
	
}