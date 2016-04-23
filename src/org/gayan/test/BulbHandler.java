package org.gayan.test;

import java.lang.reflect.Method;

public class BulbHandler implements IBulb{
	IBulb ibulb;
	
	public BulbHandler(IBulb bulb) {
		this.ibulb = bulb;
		}

	public Object invoke(Object proxy, Method method, Object[] args)
	throws Throwable {
	System.out.println("Bulb handler invoke " + method.getName());
	return method.invoke(ibulb, args);
	}

	public void on() {
		System.out.println("Light on");
		
	}

	public void off() {
		System.out.println("Light off");
		
	}
}
