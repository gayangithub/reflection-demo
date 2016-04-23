package org.gayan.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Class reflect = School.class;

		// class name
		System.out.println("Class name with package: " + reflect.getName());
		System.out.println("Class name: " + reflect.getSimpleName());

		// Modifier
		System.out.println("-------------------------------");
		int modifiertype = reflect.getModifiers();
		System.out
				.println("Is public class:" + Modifier.isPublic(modifiertype));
		System.out.println("Is abstract class:"
				+ Modifier.isAbstract(modifiertype));
		System.out.println("Is final class:" + Modifier.isFinal(modifiertype));
		System.out.println("Is private class:"
				+ Modifier.isPrivate(modifiertype));

		// Interfaces
		System.out.println("-------------------------------");
		Class[] interfaces = reflect.getInterfaces();
		System.out.println("interface :" + interfaces[0].getName());

		// supercalss
		System.out.println("-------------------------------");
		Class superclass = reflect.getSuperclass();
		System.out.println("superclass :" + superclass.getName());

		// Methods (public)
		System.out.println("-------------------------------");
		Method[] method = reflect.getMethods();
		for (int i = 0; i < method.length; i++) {
			System.out.println("Method Name of " + i + " is : "
					+ method[i].getName());
			System.out.println("Method Modifier of " + i + " is : "
					+ method[i].getModifiers());
			System.out.println("Method Parameter count of " + i + " is : "
					+ method[i].getParameterCount());
			System.out.println("Method Return type of " + i + " is : "
					+ method[i].getReturnType());

			Class[] parametertype = method[i].getParameterTypes();
			System.out.print("Parameter types : ");
			for (int j = 0; j < parametertype.length; j++) {
				System.out.print(parametertype[j].getName() + " ,");

			}
			System.out.println("       ");
			System.out.println("       ");
			System.out.println("       ");

		}
		// Constructor
		Constructor constructor = null;
		//Object constructor2 = null;
		try {
			constructor = reflect.getConstructor(new Class[] { Student.class });
			// constructor2 = reflect.getConstructor(int.class,String.class).

			constructor.getParameterTypes();
		} catch (NoSuchMethodException e) {

			e.printStackTrace();

		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------------------------");
		Class[] constructorpara = constructor.getParameterTypes();
		for (int r = 0; r < constructorpara.length; r++) {
			System.out.println("Constructor paramaeters: "
					+ constructorpara[r].getName());

		}

		Student student = null;
		School school = null;
		try {
			school = (School) constructor.newInstance(new Object[] { school });

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Before School name: " + school.getSchoolname());
		school.setSchoolname("Bandaranayake");
		System.out.println("Changed School name: " + school.getSchoolname());

		Field privatestringname = null;

		School school2 = new School(student);
		String valueofschool = "";
		try {
			privatestringname = School.class.getDeclaredField("principle");
			privatestringname.setAccessible(true);
			try {
				valueofschool = (String) privatestringname.get(school2);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------------------------");
		System.out.println("Field value: " + valueofschool);

		//private method
		Method privatemethod = null;
		try {
			privatemethod = School.class.getDeclaredMethod("Bestword",null);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		privatemethod.setAccessible(true);
		String methodvalue="";
		try {
			methodvalue = (String)privatemethod.invoke(school2,null);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("----------------------------------");
		System.out.println("Private Method executed: "+methodvalue);
		
		Class[] methodparameter = new Class[]{Integer.TYPE,String.class};
		Object[] arguments = new Object[]{new Integer(1000),new String("Female")};
		
		try {
			privatemethod = School.class.getDeclaredMethod("description",methodparameter);
			privatemethod.setAccessible(true);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			methodvalue = (String)privatemethod.invoke(school2,arguments);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Private method executed with paramaters: "+privatemethod.getName()+":"+methodvalue);
		
		
		//Proxy
		
		

	}

}
