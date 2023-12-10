package application;

import java.io.*;
import java.util.ArrayList;

public class Model {
	
	private ArrayList<ArrayList<String>> user_password;
	private String user;
	private ArrayList<Poll> poll;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public ArrayList<Poll> get_Poll(){
		return poll;
	}

	public Model () {
		user_password = new ArrayList<ArrayList<String>>();
		user_password.add(new ArrayList<String>());
		user_password.add(new ArrayList<String>());
		user_password.get(0).add("Robin");
		user_password.get(1).add("toto");
		poll = new ArrayList<Poll>();
		poll.add(this.get_info("C:\\Users\\Robin\\Desktop\\Cours 2A\\Workspace\\Itue_project\\src\\application\\Poll_Question1.txt"));
		poll.add(this.get_info("C:\\Users\\Robin\\Desktop\\Cours 2A\\Workspace\\Itue_project\\src\\application\\Poll_Question2.txt"));
		
		
		
	}
	
    public boolean check_user(String user,String password) {
    	int index = user_password.get(0).indexOf(user);
    	if (index == -1) {
    		return false;
    	}
    	if(user_password.get(1).get(index).equals(password)) {
    		this.user = user;
    		return true;
    	}
    	
        return false;
    }
    
    public boolean add_user (String user, String password) {
    	if (user.isBlank() || password.isBlank()) {
    		return false;
    	}
    	user_password.get(0).add(user);
		user_password.get(1).add(password);
		
		return true;
    }
    
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
