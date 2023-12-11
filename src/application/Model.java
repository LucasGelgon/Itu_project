package application;

import java.io.*;
import java.util.ArrayList;
/**
 * Class to manage all the model like users, polls, ...
 * @author Robin
 *
 */
public class Model {
	/**
	 * Stores 2 arrays of string; the first one is an array of registered users and the second one is an array of password.
	 * The index of the String arrays are linked to each other. 
	 */
	private ArrayList<ArrayList<String>> user_password;
	/**
	 * Represent the user currently Logged In
	 */
	private String user;
	/**
	 * Represent the index of the user currently Logged In in the Arrays.
	 */
	private int index_user;
	/**
	 * Array of Boolean Arrays. Each Boolean Array is used to check if the user already answered a specific poll 
	 */
	private ArrayList<ArrayList<Boolean>> answered;
	/**
	 * List of all the created poll
	 */
	private ArrayList<Poll> poll;
	
	/**
	 * Get only the Boolean Array of the current user and not the array of boolean array.
	 * @return Boolean Array of the current user
	 */
	public ArrayList<Boolean> getAnswered() {
		return answered.get(index_user);
	}
	/**
	 * Allow to change if the user answered to a question or not
	 * @param index index of the user
	 * @param poll_index index of the poll (question 1,2,3,4)
	 * @param value the value to be set (most of the time true )
	 */
	public void setAnswered(int index,int poll_index,boolean value) {
		this.answered.get(index).set(poll_index, value); 
	}
	
	public void setIndexUser(int index) {
		this.index_user = index;
	}
	
	public int getIndexUser() {
		return index_user;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public ArrayList<Poll> get_Poll(){
		return poll;
	}

	/**
	 * Constructor of the Model. Initialize the model
	 */
	public Model () {
		user_password = new ArrayList<ArrayList<String>>();
		user_password.add(new ArrayList<String>());
		user_password.add(new ArrayList<String>());
		poll = new ArrayList<Poll>();
		poll.add(this.get_info("C:\\Users\\Robin\\Desktop\\Cours 2A\\Workspace\\Itue_project\\src\\application\\Poll_Question1.txt"));
		poll.add(this.get_info("C:\\Users\\Robin\\Desktop\\Cours 2A\\Workspace\\Itue_project\\src\\application\\Poll_Question2.txt"));
		poll.add(this.get_info("C:\\Users\\Robin\\Desktop\\Cours 2A\\Workspace\\Itue_project\\src\\application\\Poll_Question3.txt"));
		poll.add(this.get_info("C:\\Users\\Robin\\Desktop\\Cours 2A\\Workspace\\Itue_project\\src\\application\\Poll_Question4.txt"));
		answered = new ArrayList<ArrayList<Boolean>>();
		add_user("Robin","toto");
		
		
		
		
		
	}
	/**
	 * Check if the combination user/password exist in the database 
	 * @param user 
	 * @param password
	 * @return -1 if something wrong or index of the user if OK
	 */
    public int check_user(String user,String password) {
    	int index = user_password.get(0).indexOf(user);
    	if (index == -1) {
    		return -1;
    	}
    	if(user_password.get(1).get(index).equals(password)) {
    		this.user = user;
    		return index;
    	}
    	
        return -1;
    }
    /**
     * Add a new user to the database and create a new Array List of answered poll for the new user
     * @param user
     * @param password
     * @return false if the String are empty or filled with blank
     */
    public boolean add_user (String user, String password) {
    	if (user.isBlank() || password.isBlank()) {
    		return false;
    	}
    	user_password.get(0).add(user);
		user_password.get(1).add(password);
		answered.add(new ArrayList<Boolean>());
		answered.get(user_password.get(0).indexOf(user)).add(false);
		answered.get(user_password.get(0).indexOf(user)).add(false);
		answered.get(user_password.get(0).indexOf(user)).add(false);
		answered.get(user_password.get(0).indexOf(user)).add(false);
		
		return true;
    }
    /**
     * Parse a text file to generate a poll
     * @param path path to the text file
     * @return String Array with all the information
     */
    private Poll get_info(String path) {
  
         ArrayList<String> lines = new ArrayList<String>();
         File file = new File(path);
         try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
             String line;
             while ((line = reader.readLine()) != null) {
                lines.add(line);
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
    	return (new Poll(lines));
    }
}
