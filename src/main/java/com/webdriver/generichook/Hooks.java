package com.webdriver.generichook;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	/*
	 * @Before public void beforeScenario(){ System.out.println("@Before"); }
	 * 
	 * @After public void afterScenario(){ System.out.println("@After"); }
	 * 
	 * @Before("@First") public void beforeFirst(){
	 * System.out.println("@Before(\"@First\")"); }
	 * 
	 * @Before("@Second") public void beforeSecond(){
	 * System.out.println("@Before@Second"); }
	 * 
	 * @Before("@Third") public void beforeThird(){
	 * System.out.println("@Before@Third"); }
	 * 
	 * @After("@First") public void afterFirst(){
	 * System.out.println("@After@First"); }
	 * 
	 * @After("@Second") public void afterSecond(){
	 * System.out.println("@After@Second"); }
	 * 
	 * @After("@Third") public void afterThird(){
	 * System.out.println("@After@Third"); }
	 */

	// Priority of hooks
	@Before
	public void before() {
		System.out.println("@Before");
	}

	@Before(order = 1)
	public void beforeScenario() {
		System.out.println("@Before(order=1)");
	}

//	@Before(order = 0)
//	public void beforeScenarioStart() {
//		System.out.println("@Before(order=0)");
//	}

	@After(order = 0)
	public void afterScenarioFinish() {
		System.out.println("@After(order=0)");
	}

	@After(order = 1)
	public void afterScenario() {
		System.out.println("@After(order=1)");
	}
	@After
	public void after() {
		System.out.println("@After");
	}

}

/*
 * OUTPUT
 * 
 * @Before
 * 
 * @Before("@First") 
 * 
 * scenario
 * 
 * @After
 * 
 * @After@First
 */

/*
@Before(order=0)
@Before(order=1)
@Before
This is the first
This is the second step
This is the third step
@After
@After(order=1)
@After(order=0)
*/