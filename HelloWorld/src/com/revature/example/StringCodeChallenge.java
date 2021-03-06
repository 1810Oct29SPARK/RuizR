package com.revature.example;

public class StringCodeChallenge {
	
	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 *
	 * @param string
	 * @return
	 */

	public static String main(String[] args) {
		String challengeString = "Hello World";
		System.out.println("String: " + challengeString);
		
		//Using reverseCharArray: 
		System.out.println("Reverse Using reverseCharArray: "+ reverseCharArray(challengeString));
		
		return challengeString;
	}
		public static String reverseCharArray(String s) {
		    char[] reverseStringArray = new char[s.length()];
		    for (int i = s.length() - 1, j = 0; i != -1; i--, j++) {
		        reverseStringArray[j] = s.charAt(i);
		    }
		    return new String(reverseStringArray);
		}
	}
