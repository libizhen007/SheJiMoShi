package com.bz;
/**
单例模式：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 */
public class PSingleton {

	public static void main(String[] args) {
			for(int i=0; i<10; i++){
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						//System.out.println(ASingleton.getInstance());//线程不安全
						//System.out.println(BSingleton.getInstance());//线程安全
						//System.out.println(CSingleton.getSingleton());//线程安全
						System.out.println(DSingleton.getSingleton());//线程局部变量不可应用于单例模式
					}
				}).start();
			}
	}

}


//单例模式的几种实现方式
/**
懒汉式，线程不安全
是否 Lazy 初始化：是
是否多线程安全：否
实现难度：易
描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 */
class ASingleton {  
    private static ASingleton instance;  
    private ASingleton (){}  
  
    public static ASingleton getInstance() {  
    if (instance == null) {  
        instance = new ASingleton();  
    }  
    	return instance;  
    }  
}  


/*饿汉式
是否 Lazy 初始化：否
是否多线程安全：是
实现难度：易
描述：这种方式比较常用，但容易产生垃圾对象。
优点：没有加锁，执行效率会提高。
缺点：类加载时就初始化，浪费内存。
它基于 classloder 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化，虽然导致类装载的原因有很多种，
在单例模式中大多数都是调用 getInstance 方法， 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化 instance 显然没有达到 lazy loading 的效果。
*/
class BSingleton {  
    private static BSingleton instance = new BSingleton();  
    private BSingleton (){}  
    public static BSingleton getInstance() {  
    	return instance;  
    }  
}  

/*双检锁/双重校验锁（DCL，即 double-checked locking）
JDK 版本：JDK1.5 起
是否 Lazy 初始化：是
是否多线程安全：是
实现难度：较复杂
描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
getInstance() 的性能对应用程序很关键。
代码实例：*/
class CSingleton {  
    private volatile static CSingleton singleton;  //一重锁
    private CSingleton (){}  
    public static CSingleton getSingleton() {  
    if (singleton == null) {  
        synchronized (CSingleton.class) {  //二重锁
        if (singleton == null) {  
            singleton = new CSingleton();  
        }  
        }  
    }  
    return singleton;  
    }  
}  


//使用线程局部变量
class DSingleton{
	private static ThreadLocal<DSingleton> local = new ThreadLocal<DSingleton>();
	
	private DSingleton(){};
	
	public static DSingleton getSingleton(){
		if(local.get()==null){
			local.set(new DSingleton());
		}
		return local.get();
	}
	
}