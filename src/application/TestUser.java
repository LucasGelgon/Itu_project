package application;

import java.util.*;

/**
 * test user.java
 */
public class TestUser{
	
	
    /**
     * main method where there are all the tests
     * @param agrs[] an array of strings that holds the command-line 
     * arguments passed to the program at runtime
     */ 
    public static void main(String args[]){
        TestUser test = new TestUser();
        test.testCreateUser();
    }

	/**
	 * test the class user
	 */
	public void testCreateUser(){
		
		System.out.println("*** testCreateUser()");
		User user1 = new User("Lucas", "Gelgon", 18, "example@gmail.com");
		System.out.println(user1.getName());
		System.out.println(user1.getSurname());
		System.out.println(user1.getAge());
		System.out.println(user1.getEmail());
		System.out.println(Arrays.toString(user1.getBadges()));
		
	}
}
		
		
		

		
		

