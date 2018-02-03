package com.bz;

import java.util.HashMap;
import java.util.Map;

/*
 * 享元模式：运用共享技术有效的支持大量细粒度的对象。
 * 
 * 
例子：多个用户多个网站，网站有些是一样的；
 */
public class UFlyweight {

	public static void main(String[] args) {
		WebSite webSite = WebSiteFactory.getWebSite("计算机行业");
		webSite.Use(new UserW("张三"));
		
		WebSite webSite1 = WebSiteFactory.getWebSite("计算机行业");
		webSite1.Use(new UserW("李四"));
		
		WebSite webSite2 = WebSiteFactory.getWebSite("计算机行业");
		webSite2.Use(new UserW("王五"));
		
		WebSite webSite3 = WebSiteFactory.getWebSite("典当");
		webSite3.Use(new UserW("赵六"));
		
		System.out.println("一共有：" + WebSiteFactory.webSiteNum());
	}

}

class UserW{
	private String name;
	
	public UserW(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}

abstract class WebSite{
	//设置当前网站所属
	public abstract void Use(UserW user);
}

//具体网站
class ConcreteWebSite extends WebSite{
	private String wname;
	public ConcreteWebSite(String wname){
		this.wname = wname;
	}
	@Override
	public void Use(UserW user) {
		System.out.println("当前网站分类："+ wname + " 所属用户:" + user.getName());
	}
}

//网站工厂
class WebSiteFactory {
	private static Map<String,WebSite> webSites  = new HashMap<String,WebSite>();
	
	
	//得到具体网站,
	public static WebSite getWebSite(String key){
		if(webSites.get(key)!=null){
			return webSites.get(key);
		}else{
			webSites.put(key, new ConcreteWebSite(key));//这里设置不好，ConcreteWebSite
			return webSites.get(key);
		}
	}
	
	
	
	//具体网站分类的个数
	public static int webSiteNum(){
		return webSites.size();
	}
	
}