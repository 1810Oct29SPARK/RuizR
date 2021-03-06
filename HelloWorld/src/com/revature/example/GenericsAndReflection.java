package com.revature.example;

import java.lang.reflect.Field;
import java.util.Arrays;

import com.revature.transport.Car;
import com.revature.transport.Kayak;
import com.revature.transport.MaintenanceException;

public class GenericsAndReflection {

	public static void main(String[] args) {
		
		Car c = new Car (2300, "fury roadster", "mad max", 1000);
		Object[] emptyCars = replicateWithGenerics(c,3);
		try {
			((Car) emptyCars[2]).move();
		} catch(MaintenanceException e) {
			e.printStackTrace();
		}
		//System.out.println(Arrays.toString(emptyCars));
		
		funWithReflections();

	}

	// fills an array of specified size with objects of the same type as passed in
	static Object[] replicate (Object O, int size) {
		Object[] replicants = new Object[size];
		for (int i=0; i<size; i++) {
			replicants[i] = new Object();
		}
		return replicants;
	}
	
	static <T> Object[] replicateWithGenerics (T t, int size) {
		Object[] replicants = new Object[size];
		for (int i=0; i<size; i++) {
			try {
				replicants[i] = (t.getClass()).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return replicants;
	}
	
	
	/* Time to use the reflection API!
	 *  
	 *  Inspect classes at runtime
	 */
	
	static void funWithReflections() {
		
		try {
			//first thing: get a Class object by its fully qualified name
			Class clazz = Class.forName("com.revature.transport.Kayak");
			System.out.println(clazz.getSimpleName());
			
			//get the fields of Kayak
			Field[] fields = clazz.getDeclaredFields();
			System.out.println(Arrays.toString(fields));
			
			// new instance of Kayak
			Kayak k = (Kayak) clazz.newInstance();
			Field numSeats = clazz.getDeclaredField("numSeats");
			numSeats.setAccessible(true);
			numSeats.set(k, 5);
			System.out.println(k);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
}
