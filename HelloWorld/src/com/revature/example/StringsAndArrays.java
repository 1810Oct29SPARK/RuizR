package com.revature.example;

import java.util.Arrays;

import com.revature.transport.Car;
import com.revature.transport.Kayak;
import com.revature.transport.Tornado;
import com.revature.transport.Vehicle;

public class StringsAndArrays {

	public static void main(String[] args) {
		//funWithStrings();
		funWithArrays();
	}
	
	static void funWithArrays() {
		String[] arr1 = {"this","is","an","array"}; //Array Literal
		/*
		 * augmented (enhanced) for loops - moving through an Array or Iterable 
		 */
		
		for (String s: arr1) {
			System.out.println(s);
		}
		
		String[] arr2 = new String[4];
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = "element " +i;
		}
		System.out.println("toString from Array: " + arr2.toString());
		System.out.println("toString from Arrays: " + Arrays.toString(arr2)); //Arrays have a static method! Didn't have to make an object method.
		
		int[][] arr3 = new int[4][3]; //Array Constructor
		arr3[0][0] = 7;
		arr3[0][2] = 8;
		arr3[3][0] = 9;
		arr3[3][2] = 10;
		
		for (int [] a : arr3) {
			System.out.println(Arrays.toString(a));
		}
		
		Vehicle[] vehicles = new Vehicle[4];
		System.out.println(Arrays.toString(vehicles)); //all null for now - default value for all reference types.
		//vehicles[2].move(); //compiles just fine, declared type is vehicle.. but throws NullPointerException at runtime
		vehicles[0] = new Tornado(140.2);
		vehicles[1] = new Kayak("red", 4.2, 2,2);
		vehicles[2] = new Car(2021, "spaceship", "Tesla", 50);
		vehicles[3] = new Tornado(256.4);
		
		/*
		 * Array methods:
		 * sort
		 * binarySearch
		 * fill
		 * copyOfRange
		 * copyOf
		 * asList
		 * parallelPrefix
		 */
		
		/*
		int[] arr = {2,1,3,4,6,1,7,3,6,8,9,2,4};
		IntBinaryOperator op = (x,y) -> x+y;
		Arrays.parallelPrefix(array, op);
		Arrays.parallelPrefix(array, (x,y) -> compute(x,y));
		Arrays.stream(arr).forEach(e -> System.out.println(e + " "););
		*/
	}

	static void funWithStrings() {
		//string literal
		String a = "hello";
		String b = new String ("hello");
		
		/*
		 * .equals () is inherited from Object
		 * most reference types override to define "equality"
		 * (usually by the fields)
		 * String has it overridden to check the String literal
		 */
		System.out.println("string is equal to string b: " + a.equals(b));
		
		/*
		 * == is good for comparing primitives
		 * or checking whether two objects are the same object
		 * (compare the REFERENCE)
		 */
		System.out.println("string a is the same object as string b: " + (a==b));
		
		// a and b are two different objects pointing to the same literal in the string pool
		
		/*
		 * String API methods
		 * toUpperCase
		 * toLowerCase
		 * substring
		 * concat
		 * replace
		 * indexOf
		 * split
		 * trim
		 */
		
		String test1 = "hello world";
		System.out.println(test1.toUpperCase()); //toUpperCase
		String test2 = "HeLlO WOrlD";
		System.out.println(test2.toLowerCase()); //toLowerCase
		System.out.println(test1.substring(3,8)); //substring
		System.out.println(test1.concat(test2)); //concat
		System.out.println(test1.replace('l','p')); //replace
		System.out.println(test1.indexOf('l')); //indexOf
		System.out.println(test1.indexOf('L')); //no uppercase L!
		String test3 = "the quick brown fox jumped over the lazy dog";
		String[] words = test3.split(" "); //split
		for (String w : words) {
			System.out.println(w);
		}
	}
}
