package com.revature.demo;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

//@Ignore //will ignore all tests
public class JUnitProcedureTest {
	
	//executes before each test
	//doesn't matter the location of @before
	@Before
	public void beforeTests() {
		System.out.println("in beforeTests");
	}
	
	@After
	public void afterTests() {
		System.out.println("in afterTests");
	}

	@Test
	public void testCase1() {
		System.out.println("in testCase1");
	}
	
	@Ignore //will not run testCase2
	@Test
	public void testCase2() {
		System.out.println("in testCase2");
		fail();
	}
	
	//executes before all tests
	@Before
	public static void beforeAllTests() {
		System.out.println("in beforeAllTests");
	}
	
	//executes after all tests
	@AfterClass
	public static void afterAllTests() {
		System.out.println("in afterAllTests");
	}
	
}
